using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Parser_v2
{
    class Parser_Project_4
    {
        public string datafile;
        public int datafilesize;

        public Parser_Project_4(string Datafile)
        {
            datafile = Datafile;
            datafilesize = datafile.Length;
        }

        public string dataToSql()
        {
            string Query = "";
            string TempString1 = "";
            string TempString2 = "";
            bool CurrentDigit = false;


            foreach (char c in datafile) {
                if (c != (char)44) { TempString1 += c; }
                else if (TempString1.GetType() == typeof(string) && c.GetType() == typeof(int)) {  }
            }










            return Query;
        }


        

        


    }
}
