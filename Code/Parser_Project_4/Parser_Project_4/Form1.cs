using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using Excel = Microsoft.Office.Interop.Excel;

namespace Parser_Project_4
{
    public partial class Form1 : Form
    {
        public static Form1 _Form1;
        public string Filepath;
        public string query;
        public string Query { set { query = value; } }
        public string filepath { get { return filepath; } set { Filepath = value; } }
        public string excelfile { get { return excelfile;  } set { excelfile = value; } }
        public string TB_Output { get { return textBox1.Text; } }
        
        public void SetTBText(string text)
        {
            textBox1.Text = text;
        }
        public Form1()
        {
            InitializeComponent();
            _Form1 = this;
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        public void newFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog OpenFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "XLS Files (.xls)|*.xls";
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            if (openFileDialog1.ShowDialog() == DialogResult.OK) {
                string ExcelFile = openFileDialog1.FileName;
                string ExcelPath = openFileDialog1.InitialDirectory + openFileDialog1.FileName;
                //    Form1._Form1.excelfile = ExcelFile;
                Form1._Form1.filepath = openFileDialog1.FileName;
                DialogResult messageboxresult = MessageBox.Show("Do you want to parse the selected file immediately?", "Parse File",  MessageBoxButtons.YesNo, MessageBoxIcon.Question); if (messageboxresult == DialogResult.Yes) { ParseAFile(); } }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Console.WriteLine(Filepath);
        }
        public void ParseAFile()
        {
            Fietsendiefstal fietsendiefstal = new Fietsendiefstal();
            Fietsendiefstal.OpenFile();
            textBox1.Text = query;
        }


        public void ParseCSVFile(string ExcelFile)
        {
            FietsenDiefstal_CSV fietsendiefstalcsv = new FietsenDiefstal_CSV();
            FietsenDiefstal_CSV.OpenFile(ExcelFile);

        }

        private void parseFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ParseAFile();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (textBox1.Text != "") { System.Windows.Forms.Clipboard.SetText(textBox1.Text); }
        }

        private void parseCSVFileToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void fietsenDiefstalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog OpenFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "CSV Files (.csv)|*.csv";
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                string ExcelFile = openFileDialog1.FileName;
                string ExcelPath = openFileDialog1.InitialDirectory + openFileDialog1.FileName;
                using (StreamReader sr = new StreamReader(ExcelFile))
                {
                    ExcelFile = sr.ReadToEnd();
                    textBox1.Text = ExcelFile;
                }
                DialogResult messageboxresult = MessageBox.Show("Do you want to parse the selected file immediately?", "Parse File", MessageBoxButtons.YesNo, MessageBoxIcon.Question); if (messageboxresult == DialogResult.Yes) { ParseCSVFile(ExcelFile); }
            }

        }

        public void Btn_TestConnection_Click(object sender, EventArgs e)
        {
            DatabaseConnection.ConnectDatabase(TB_IPaddr.Text, TB_Port.Text, TB_Uname.Text, TB_Pass.Text, TB_Datab.Text);
        }
    }
}
