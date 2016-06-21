using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Npgsql;
using System.Data;
using System.Windows.Forms;

namespace Parser_v2
{
    class DataBaseConnection
    {
        public void ConnectDatabase()
        {
            // getting server values from Form1 and putting them into strings.
            string ServerAddr = ParserGUI._ParserGUI.Get_ServerAddress;
            string ServerPort = ParserGUI._ParserGUI.Get_ServerPort;
            string ServerDatabase = ParserGUI._ParserGUI.Get_ServerDatabase;
            string ServerUname = ParserGUI._ParserGUI.Get_ServerUname;
            string ServerPassword = ParserGUI._ParserGUI.Get_ServerUpass;
            try
            {
                // PostgeSQL-style connection string
                string connstring = String.Format("Server={0};Port={1};" +
                "User Id={2};Password={3};Database={4};",
                ServerAddr, ServerPort, ServerUname,
                ServerPassword, ServerDatabase);
                // Making connection with Npgsql provider
                NpgsqlConnection conn = new NpgsqlConnection(connstring);
                conn.Open();
                // check if the state is open. Send messagebox with state.
                if (conn.State == ConnectionState.Open) { MessageBox.Show("Connection Open!"); ParserGUI._ParserGUI.update_LB_Server("Connected to database"); }
                else { MessageBox.Show("Connection not open!"); ParserGUI._ParserGUI.update_LB_Server("Not connected"); }
                conn.Close();
            }
            catch (Exception msg)
            {
                // something went wrong, and you want to know why
                MessageBox.Show(msg.ToString());
            }
        }

        public void SendQuery()
        {
            // getting server values from form1 and putting them into a string.
            string ServerAddr = ParserGUI._ParserGUI.Get_ServerAddress;
            string ServerPort = ParserGUI._ParserGUI.Get_ServerPort;
            string ServerDatabase = ParserGUI._ParserGUI.Get_ServerDatabase;
            string ServerUname = ParserGUI._ParserGUI.Get_ServerUname;
            string ServerPassword = ParserGUI._ParserGUI.Get_ServerUpass;
            string Output_TB = ParserGUI._ParserGUI.Get_Output;
            int indexchar = 2;
            int lastindex = 0;
            string query = "";
            int ignorecolons = 0;
            try
            {
                // PostgeSQL-style connection string
                string connstring = String.Format("Server={0};Port={1};" +
                "User Id={2};Password={3};Database={4};",
                ServerAddr, ServerPort, ServerUname,
                ServerPassword, ServerDatabase);
                // Making connection with Npgsql provider
                NpgsqlConnection conn = new NpgsqlConnection(connstring);
                conn.Open();
                // Check if connection, send messagebox with state and change label if connection is changed.
                if (conn.State == ConnectionState.Open) {
                    MessageBox.Show("A connection has been opened on requested values.");
                    ParserGUI._ParserGUI.update_LB_Server("Connected to database");
                }
                else {
                    MessageBox.Show("Connection not open!");
                    ParserGUI._ParserGUI.update_LB_Server("Not connected");
                }

                //Starting to send the Query

                //zie hier uitleg waarom er geknipt moet worden http://stackoverflow.com/questions/32886171/npgsql-i-get-42p01-relation-sometable-does-not-exist
                //we knipppen hier elke command weer uit (grom grom)

                while (indexchar < Output_TB.Length)
                {
                    while (Output_TB[indexchar] != ';' && indexchar < Output_TB.Length-1)
                    {
                        if(Output_TB[indexchar] == 'D')
                        {
                            if(Output_TB[indexchar+1] == 'O')
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
