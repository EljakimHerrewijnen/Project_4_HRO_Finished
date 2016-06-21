using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using Npgsql;

namespace Parser_v2
{
    public partial class ParserGUI : Form
    {
        public string FileToParse;
        public string Query;
        public ParserGUI()
        {
            InitializeComponent();
            _ParserGUI = this;
        }
        // defining strings. This is also used to get values from an other class.
        public static ParserGUI _ParserGUI;
        public void update_output(string message) {TB_Output.Text = message; }
        public string Get_Input { get { return TB_Input.Text; } }
        public string Get_ServerAddress { get { return TB_ServerAddr.Text; } }
        public string Get_ServerPort { get { return TB_ServerPort.Text; } }
        public string Get_ServerDatabase { get { return TB_DataName.Text; } }
        public string Get_ServerUname { get { return TB_ServerUname.Text; } }
        public string Get_ServerUpass { get { return TB_ServerUpass.Text; } }
        public void update_LB_Server(string message) { LB_ServerConnected.Text = message; }
        public string Get_LB_Server { get { return LB_ServerConnected.Text; } }
        public string Get_Output { get { return TB_Output.Text; } }

        public void button3_Click(object sender, EventArgs e)
        {
            DataBaseConnection Connected = new DataBaseConnection();
            Connected.ConnectDatabase();
        }

        private void newFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // start openfiledialog and set filters.
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "Text Files (.txt)|*.txt|All Files (*.*)|*.*|CSV Files (.csv)|*.csv";
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                //Rembember the path
                string file = openFileDialog1.FileName;
                TB_Input.Text = file;
                using (StreamReader sr = new StreamReader(file)) { TB_Input.Text = sr.ReadToEnd(); }
            }
        }

        private void openFileDialog1_FileOk(object sender, CancelEventArgs e){}

        private void button4_Click(object sender, EventArgs e)
        {
            // send query
            DataBaseConnection Connected = new DataBaseConnection();
            Connected.SendQuery();
            
        }

        private void button6_Click(object sender, EventArgs e)
        {
            // parse from input
            FileToParse = ParserGUI._ParserGUI.Get_Input;
            if (checkBox2.Checked == true)
            {
                Parser parser = new Parser(FileToParse);
                Query = parser.dataToSql();
                TB_Output.Text = Query;
            }
            else
            {
                Parser parser = new Parser(FileToParse);
                Query = parser.dataToSql();
                TB_Output.Text = Query;
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            //Checks if there is something to place in the clipboard, and places it there
            if (TB_Output.Text != "") { System.Windows.Forms.Clipboard.SetText(TB_Output.Text); }
        }

        private void Btn_Copy_Input_Click(object sender, EventArgs e)
        {
            //Checks if there is something to place in the clipboard, and places it there
            if (TB_Output.Text != "") { System.Windows.Forms.Clipboard.SetText(TB_Output.Text); }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Clear Textbox
            TB_Input.Clear();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // Clear Textbox
            TB_Output.Clear();
        }

        private void restartToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //restart application
            Application.Restart();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //Exit application
            Application.Exit();
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            checkBox3.Checked = false;
        }

        private void checkBox3_CheckedChanged(object sender, EventArgs e)
        {
            checkBox2.Checked = false;
        }
    }
}

