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
            int Counter = 0;
            int TempCounter = 1;
            string Tempstring ="";
            string Tempstring2 = "";
            string Query = "CREATE TABLE IF NOT EXISTS FietsenDiefstal_CSV(Voorval_nummer varchar(256), Kennisname varchar(256), MK varchar(256), MK_omschrijving varchar(256), Poging varchar(256), District varchar(256), Werkgebied varchar(256), Plaats varchar(256), Buurt varchar(256), Straat varchar(256), Begin_dagsoort varchar(256), Begindatum varchar(256), Begintijd varchar(256), Eind_dagsoort varchar(256),Einddatum varchar(256), Eindtijd varchar(256), Gemiddelde_jaar varchar(256), Gemiddelde_maand varchar(256), Gemiddelde_dagsoort varchar(256), Gemiddelde_dagdeel_6_uren varchar(256), Trefwoord varchar(256), object varchar(256), merk varchar(256), type varchar(256), kleur varchar(256)) \n";
            
            foreach (char c in ExcelFile)
            {
                string Character = c.ToString();
                if(Character == ",")
                {
                    if(Counter == 0) { Query += "INSERT INTO FietsenDiefstal_CSV(\n Voorval_nummer, Kennisname, MK, MK_omschrijving, Poging, District, Werkgebied, Plaats, Buurt, Straat, Begin_dagsoort, Begindatum, Begintijd, Eind_dagsoort, Einddatum, Eindtijd, Gemiddelde_jaar, Gemiddelde_maand, Gemiddelde_dagsoort, Gemiddelde_dagdeel_6_uren, Trefwoord, object, merk, type, kleur) VALUES("; }
                    
                    TempCounter++;
                    Tempstring2 += Tempstring + " ,";
                    Tempstring = "";

                    if (TempCounter == 26)
                    {
                        Counter = 0;
                        Tempstring2 = Tempstring2.Remove(Tempstring2.Length - 13);
                        Query += Tempstring2;
                        Query += ")\n";
                    }
                }
                else { Tempstring += (char)34 + Character + (char)34; }
            }
            Console.WriteLine(Query);
        }
    }
}
