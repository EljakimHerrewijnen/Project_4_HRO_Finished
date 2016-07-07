using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Excel = Microsoft.Office.Interop.Excel;

namespace Parser_Project_4
{
    class Fietstrommels_CSV
    {

        public static void OpenFile(string ExcelFile)  //Gives the Excelfile
        {
            string Query = "";
            int StartCounter = 0;
            bool ParsingAllowed = false; //For counting untill the headers are gone.
            string Character = "";
            string Tempstring1 = "";
            foreach (char c in ExcelFile)
            {
                Character = c.ToString();
                if (Character == ";")
                {
                    if(ParsingAllowed == true)
                    {

                    }
                    else
                    {
                        StartCounter++;

                    }
                }
                else { Tempstring1 += Character; }
            }

        }
    }
}
