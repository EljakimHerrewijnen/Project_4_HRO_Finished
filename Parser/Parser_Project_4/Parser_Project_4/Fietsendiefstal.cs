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
        public static void CreateTable()
        {

        }


        public static void OpenFile()
        {
            Excel.Application excelApp = new Excel.Application();
            excelApp.Visible = true;
            string Filepath = Form1._Form1.Filepath;

            Excel.Workbook workbook = excelApp.Workbooks.Open(Filepath,
     Type.Missing, Type.Missing, Type.Missing, Type.Missing,
     Type.Missing, Type.Missing, Type.Missing, Type.Missing,
     Type.Missing, Type.Missing, Type.Missing, Type.Missing,
     Type.Missing, Type.Missing);

            Excel.Worksheet sheet = workbook.Sheets[1];
            Excel.Range range = sheet.UsedRange;
            int Cell_count = sheet.Cells.Count;
            int rows_count = range.Rows.Count;
            string tables = (char)34 + "Voorval nummer" + (char)34 + " ," 
                +  (char)34 + "Kennisname" + (char)34 + " ," 
                + (char)34 + "MK" + (char)34 + " ," 
                + (char)34 + "MK omschrijving" + (char)34 + " ," 
                + (char)34 + "Poging" + (char)34 + " ," 
                + (char)34 + "District" + (char)34 + " ," 
                + (char)34 + "Werkgebied" + (char)34 + " ," 
                + (char)34 + "Plaats" + (char)34 + " ," 
                + (char)34 + "Buurt" + (char)34 + " ," 
                + (char)34 + "Straat" + (char)34 + " ," 
                + (char)34 + "Begin dagsoort" + (char)34 + " ," 
                + (char)34 + "Begindatum" + (char)34 + " ," 
                + (char)34 + "Begintijd" + (char)34 + " ," 
                + (char)34 + "Eind dagsoort" + (char)34 + " ," 
                + (char)34 + "Einddatum" + (char)34 + " ," 
                + (char)34 + "Eindtijd" + (char)34 + " ," 
                + (char)34 + "Gemiddelde jaar" + (char)34 + " ," 
                + (char)34 + "Gemiddelde maand" + (char)34 + " ," 
                + (char)34 + "Gemiddelde dagsoort" + (char)34 + "," 
                + (char)34 + "Gemiddelde dagdeel (6 uren)" + (char)34 + "," 
                + (char)34 + "Trefwoord" + (char)34 + "," 
                + (char)34 + "object" + (char)34 +  "," 
                + (char)34 + "merk" + (char)34 + "," 
                + (char)34 + "type" + (char)34 +  "," 
                + (char)34 + "kleur" + (char)34 ;

            string query = "Create Table if not exists fietsendiefstal("
                + (char)34 + "Voorval nummer" + (char)34 + "varchar(256) ," 
                + (char)34 + "Kennisname" + (char)34 + "varchar(256) ," 
                + (char)34 + "MK" + (char)34 + "varchar(256) ,"
                + (char)34 + "MK omschrijving" + (char)34 + "varchar(256) ,"
                + (char)34 + "Poging" + (char)34 + "varchar(256) ,"
                + (char)34 + "District" + (char)34 + "varchar(256) ,"
                + (char)34 + "Werkgebied" + (char)34 + "varchar(256) ,"
                + (char)34 + "Plaats" + (char)34 + "varchar(256) ,"
                + (char)34 + "Buurt" + (char)34 + "varchar(256) ,"
                + (char)34 + "Straat" + (char)34 + "varchar(256) ,"
                + (char)34 + "Begin dagsoort" + (char)34 + "varchar(256) ,"
                + (char)34 + "Begindatum" + (char)34 + "varchar(256) ,"
                + (char)34 + "Begintijd" + (char)34 + "varchar(256) ,"
                + (char)34 + "Eind dagsoort" + (char)34 + "varchar(256) ,"
                + (char)34 + "Einddatum" + (char)34 + "varchar(256) ,"
                + (char)34 + "Eindtijd" + (char)34 + "varchar(256) ,"
                + (char)34 + "Gemiddelde jaar" + (char)34 + "varchar(256) ,"
                + (char)34 + "Gemiddelde maand" + (char)34 + "varchar(256) ,"
                + (char)34 + "Gemiddelde dagsoort" + (char)34 + " varchar(256)," 
                + (char)34 + "Gemiddelde dagdeel (6 uren)" + (char)34 + " varchar(256)," 
                + (char)34 + "Trefwoord" + (char)34 + " varchar(256)," 
                + (char)34 + "object" + (char)34 + " varchar(256)," 
                + (char)34 + "merk" + (char)34 + " varchar(256)," 
                + (char)34 + "type" + (char)34 + " varchar(256)," 
                + (char)34 + "kleur" + (char)34 +" varchar(256));";

            for(int i = 1; i < sheet.Rows.Count; i++)
            {
                if (i != 1) { query += "\n INSERT INTO fietsendiefstal(" + tables + ")  VALUES ("; }
                for(int j = 1; j <= 25; j++)
                {
                    var Cellvalues = sheet.Cells[i, j].Value;
                    if (i == 1) { break; }
                    if(j == 13) { query += "\n"; }
                    query += (char)39;
                    query += Cellvalues;
                    query += (char)39 + " ,";  
                    if(j == 25) { query = query.Remove(query.Length - 1); query += "); \n"; }
                }
                Console.WriteLine("Parsed one line..." + i);
            }
            Form1._Form1.Query = query;
            workbook.Close();
            Console.WriteLine(query);
        }

    }
}
