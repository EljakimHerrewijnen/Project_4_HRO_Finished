using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Excel = Microsoft.Office.Interop.Excel;

namespace Parser_Project_4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
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

        private void newFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog OpenFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "Text Files (.txt)|*.txt|All Files (*.*)|*.*|XLS Files (.xls)|*.xls";
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            if (openFileDialog1.ShowDialog() == DialogResult.OK) {
                
                DialogResult messageboxresult = MessageBox.Show("Do you want to parse the selected file immediately?", "Parse File",  MessageBoxButtons.YesNo, MessageBoxIcon.Question); if (messageboxresult == DialogResult.Yes) { } }
        }
    }
}
