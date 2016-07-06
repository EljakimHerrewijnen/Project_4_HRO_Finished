using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Parser_Project_4
{
    class FietsenDiefstal_CSV
    {

        public static void OpenFile(string ExcelFile)
        {
          //  int Counter = 0;
            int TempCounter = 0;
            string Tempstring ="";
            string Tempstring2 = "";
            string Tempstring3 = "";
            int ExcelLength = 0;
            
            string Query = "CREATE TABLE IF NOT EXISTS FietsenDiefstal_CSV(Voorval_nummer varchar(256), Kennisname varchar(256), MK varchar(256), MK_omschrijving varchar(256), Poging varchar(256), District varchar(256), Werkgebied varchar(256), Plaats varchar(256), Buurt varchar(256), Straat varchar(256), Begin_dagsoort varchar(256), Begindatum varchar(256), Begintijd varchar(256), Eind_dagsoort varchar(256),Einddatum varchar(256), Eindtijd varchar(256), Gemiddelde_jaar varchar(256), Gemiddelde_maand varchar(256), Gemiddelde_dagsoort varchar(256), Gemiddelde_dagdeel_6_uren varchar(256), Trefwoord varchar(256), object varchar(256), merk varchar(256), type varchar(256), kleur varchar(256));\n ";
            string ColorFilter = "";
            string NumberFilter = "";

            foreach (char c in ExcelFile)
            {
                
                int ExcelCounter = 0;
                ExcelCounter++;
                string Character = c.ToString();
                if(Character == "'") { Character = " "; }
                if(Character == ",")
                {
                    ExcelLength++;
                    if (ExcelLength == 1) { Query += "INSERT INTO FietsenDiefstal_CSV (Voorval_nummer, Kennisname, MK, MK_omschrijving, Poging, District, Werkgebied, Plaats, Buurt, Straat, Begin_dagsoort, Begindatum, Begintijd, Eind_dagsoort, Einddatum, Eindtijd, Gemiddelde_jaar, Gemiddelde_maand, Gemiddelde_dagsoort, Gemiddelde_dagdeel_6_uren, Trefwoord, object, merk, type, kleur)\n VALUES("; }
                    if (TempCounter == 1 && ExcelLength != 1){Query += "INSERT INTO FietsenDiefstal_CSV (Voorval_nummer, Kennisname, MK, MK_omschrijving, Poging, District, Werkgebied, Plaats, Buurt, Straat, Begin_dagsoort, Begindatum, Begintijd, Eind_dagsoort, Einddatum, Eindtijd, Gemiddelde_jaar, Gemiddelde_maand, Gemiddelde_dagsoort, Gemiddelde_dagdeel_6_uren, Trefwoord, object, merk, type, kleur)\n VALUES(" + (char)39 + NumberFilter + (char)39 + ", ";} //(Voorval_nummer, Kennisname, MK, MK_omschrijving, Poging, District, Werkgebied, Plaats, Buurt, Straat, Begin_dagsoort, Begindatum, Begintijd, Eind_dagsoort, Einddatum, Eindtijd, Gemiddelde_jaar, Gemiddelde_maand, Gemiddelde_dagsoort, Gemiddelde_dagdeel_6_uren, Trefwoord, object, merk, type, kleur)\nVALUES("; }

                    TempCounter++;
                    if (Tempstring == "") { Tempstring = " "; }
                    if (TempCounter != 25) { Tempstring2 += (char)39 + Tempstring + (char)39 + " ,"; }
                    Tempstring3 = Tempstring;
                    Console.WriteLine(TempCounter.ToString() + " " + Tempstring3);


                    if (TempCounter == 25)
                    {
                        NumberFilter = "";
                        ColorFilter = ""; 
                        for (int i = 0; i < Tempstring.Length; i++)
                        {
                            if (Char.IsDigit(Tempstring[i]))   
                                NumberFilter += Tempstring[i];   //Filters the numbers from the final string
                            else { ColorFilter += Tempstring[i]; }   //Filters the colors(word) from the final string
                        }
                        Tempstring2 += (char)39 + ColorFilter + (char)39;
                        TempCounter = 1;
                        Tempstring2 += ");";
                        Query += Tempstring2;
                        Tempstring2 = "";
                    }
                    Tempstring = "";

                }
                else { Tempstring += Character; }
            }
           // Console.WriteLine(Query);
            System.Windows.Forms.Clipboard.SetText(Query);
        }
    }
}
