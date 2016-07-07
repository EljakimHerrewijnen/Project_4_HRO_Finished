using Npgsql;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Parser_Project_4
{
    class DatabaseConnection
    {
            public static void ConnectDatabase(string IPAddress, string Port, string Username, string Password, string Database)
            {
                try
                {
                    // PostgeSQL-style connection string
                    string connstring = String.Format("Server={0};Port={1};" +
                    "User Id={2};Password={3};Database={4};",
                    IPAddress, Port, Username,
                    Password, Database);
                    // Making connection with Npgsql provider
                    NpgsqlConnection conn = new NpgsqlConnection(connstring);
                    conn.Open();
                    // check if the state is open. Send messagebox with state.
                    if (conn.State == ConnectionState.Open) { MessageBox.Show("Connection Open!"); }
                    else { MessageBox.Show("Connection not open!"); }
                    conn.Close();
                }
                catch (Exception msg)
                {
                    // something went wrong, and you want to know why
                    MessageBox.Show(msg.ToString());
                }
            }

            public static void SendQuery(string IPAddress, string Port, string Username, string Password, string Database)
            {
            string Output_TB = Form1._Form1.TB_Output;
                int indexchar = 2;
                int lastindex = 0;
                string query = "";
                int ignorecolons = 0;
                try
                {
                // PostgeSQL-style connection string
                string connstring = String.Format("Server={0};Port={1};" +
                "User Id={2};Password={3};Database={4};",
                IPAddress, Port, Username, Password, Database);

                    // Making connection with Npgsql provider
                    NpgsqlConnection conn = new NpgsqlConnection(connstring);
                    conn.Open();
                    // Check if connection, send messagebox with state and change label if connection is changed.
                    if (conn.State == ConnectionState.Open)
                    {
                        MessageBox.Show("A connection has been opened on user given values.");
                    }
                    else
                    {
                        MessageBox.Show("Connection not open!");
                    }

                    //Starting to send the Query

                    //zie hier uitleg waarom er geknipt moet worden http://stackoverflow.com/questions/32886171/npgsql-i-get-42p01-relation-sometable-does-not-exist
                    //we knipppen hier elke command weer uit (grom grom)

                    while (indexchar < Output_TB.Length)
                    {
                        while (Output_TB[indexchar] != ';' && indexchar < Output_TB.Length - 1)
                        {
                            if (Output_TB[indexchar] == 'D')
                            {
                                if (Output_TB[indexchar + 1] == 'O')
                                {
                                    ignorecolons = 2;
                                }
                            }
                            indexchar++;
                        }

                        indexchar++;
                        if (ignorecolons == 0 && indexchar < Output_TB.Length)
                        {
                            query = Output_TB.Substring(lastindex, indexchar - lastindex);
                            new NpgsqlCommand(query, conn).ExecuteNonQuery();
                            lastindex = indexchar;
                        }
                        else
                        {
                            ignorecolons--;
                        }
                    }

                    // Tell the user when the query has been sent.
                    MessageBox.Show("Query has been send to the connected database.");


                }
                catch (Exception msg)
                {
                    // something went wrong, and you want to know why
                    MessageBox.Show(query + "   \n" + msg.ToString());
                }

            }
        
    }
}
