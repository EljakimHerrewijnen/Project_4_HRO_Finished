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
        public string filepath { get { return filepath; } set { Filepath = value; } }
        public string excelfile { get { return excelfile;  } set { excelfile = value; } }
        public Form1()
        {
            InitializeComponent();
            _Form1 = this;
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void RB_Fietsendiefstal_CheckedChanged(object sender, EventArgs e)
        {
            if (RB_Fietstrommels.Checked == true) { RB_Fietstrommels.Checked = false; }
        }

        private void RB_Fietstrommels_CheckedChanged(object sender, EventArgs e)
        {
            if (RB_Fietsendiefstal.Checked == true) { RB_Fietsendiefstal.Checked = false; }
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
                DialogResult messageboxresult = MessageBox.Show("Do you want to parse the selected file immediately?", "Parse File",  MessageBoxButtons.YesNo, MessageBoxIcon.Question); if (messageboxresult == DialogResult.Yes) { } }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Console.WriteLine(Filepath);
        }

        private void parseFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Fietsendiefstal fietsendiefstal = new Fietsendiefstal();
            Fietsendiefstal.OpenFile();
        }
    }
}
