using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Excel = Microsoft.Office.Interop.Excel;
using Word = Microsoft.Office.Interop.Word;

namespace Parser_Project_4
{
    class Fietsendiefstal
    {
        public static void OpenFile()
        {
            Excel.Application excelApp = new Excel.Application();
            excelApp.Visible = true;
            string Filepath = Form1._Form1.Filepath;
            Excel.Workbook excelWorkbook = excelApp.Workbooks.Open(Filepath,
                    0, false, 5, "", "", false, Excel.XlPlatform.xlWindows, "",
                    true, false, 0, true, false, false);
        }

    }
}
