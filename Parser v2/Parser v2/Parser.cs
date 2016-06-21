using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Parser_v2
{
    class Parser
    {
        public string datafile;
        public int datafilesize;
        public string deelgemeente;

        public Parser(string Datafile)
        {
            datafile = Datafile + ";;";
            datafilesize = datafile.Length;
            deelgemeente = "";
        }


        //Function to call, which returns the entire SQL Querry to put the data in the database.
        public string dataToSql()
        {
            string Query = "";
            List<List<string>> Table;
            List<List<string>> currentTable;

            int currentrow = 0;

            Table = toTable();
            for(int x = 1; x<Table.Count; x++)
            {
                Table[x][0] = "";
            }

          //  deelgemeente = Table[0][0]; //Reads the name of the deelgemeente, is used later in the "getQuery()" function

            //Adds the "wijk" Table in case is does not exist
            string createTableString = "create table if not exists " + (char)34 + "Fietsen diefstal Rotterdam" + (char)34 + @"(
Voorvalnummer char(255),
Deelgemeente char(255),
Unique(wijk),
Primary key(wijk, Deelgemeente)
);";
            Query += createTableString + "\n\n";

            while (currentrow < Table.Count)
            {
                currentrow = findNextTableStart(currentrow, Table);
                if (currentrow < Table.Count)
                {
                    currentTable = cutTable(Table, currentrow);
                    Query += getQuery(currentTable);
                    //System.Console.WriteLine(currentrow);
                    currentrow++;
                }
            }

            //System.Console.Write(Query);
            return Query;
        }

        //Takes a subtable and create queries for all the data (only genormaliseerde data).
        private string getQuery(List<List<string>> Table)
        {
            bool rowsdone = false;

            string tablenameold = Table[0][2];
            string tablename = "";
            string wijknaam = "";


            string data2006;
            string data2007;
            string data2008;
            string data2009;
            string data2011;

            List<string> SQLQueries = new List<string>();
            string finalQuery;
            string sqlQuery;
            string addwijken;

            int genormaliseerdoffset = 0;
            if (Table[1][8] == "genormaliseerd")
            {
                genormaliseerdoffset = 5;
            }


            for (int i = 0; i < tablenameold.Length; i++)
            {
                switch (tablenameold[i])
                {
                    case ' ':
                    case '/':
                    case ',':
                    case '-':
                        tablename += '_';
                        break;

                    case '0':   //if the character is a number or a point or a slash or else, it goes to the next break (which does nothing)
                    case '9':
                    case '8':
                    case '7':
                    case '6':
                    case '5':
                    case '4':
                    case '3':
                    case '2':
                    case '1':
                    case '.':
                    case '(':
                    case ')':
                        break;

                    default:
                        tablename += tablenameold[i];
                        break;
                }
            }
            for (int i = Table.Count-1; i > 0 && !rowsdone; i--)//counts from bottom to top
            {
                if (Table[i][2] == "")  //if cell is empty, means end of wijken is reached
                {
                    rowsdone = true;
                }
                else {
                    if (Table[i][2][0] == '%')  //if cells first character is '%', means end of wijken is reached
                    {
                        rowsdone = true;
                    }
                    else
                    {
                        wijknaam = Table[i][2];
                        if(wijknaam != "Rotterdam")
                        {
                            if (i != Table.Count - 2 && deelgemeente == wijknaam) //second last row is the avarage of the deelgemeente.
                            {
                                wijknaam += "wijk";
                            }
                            addwijken = @"DO
$do$
Begin
If Not Exists(select * from wijk where wijk='" + wijknaam + @"') Then
insert into wijk values('" + wijknaam + "', '" + deelgemeente + @"');
End If;
End
$do$;";
                            SQLQueries.Add(addwijken);



                            data2006 = Table[i][3 + genormaliseerdoffset];
                            data2007 = Table[i][4 + genormaliseerdoffset];
                            data2008 = Table[i][5 + genormaliseerdoffset];
                            data2009 = Table[i][6 + genormaliseerdoffset];
                            data2011 = Table[i][7 + genormaliseerdoffset];


                            sqlQuery = "INSERT INTO " + tablename + " VALUES ('" + wijknaam + "', '2006', '" + data2006 + "');";
                            SQLQueries.Add(sqlQuery);
                            sqlQuery = "INSERT INTO " + tablename + " VALUES ('" + wijknaam + "', '2007', '" + data2007 + "');";
                            SQLQueries.Add(sqlQuery);
                            sqlQuery = "INSERT INTO " + tablename + " VALUES ('" + wijknaam + "', '2008', '" + data2008 + "');";
                            SQLQueries.Add(sqlQuery);
                            sqlQuery = "INSERT INTO " + tablename + " VALUES ('" + wijknaam + "', '2009', '" + data2009 + "');";
                            SQLQueries.Add(sqlQuery);
                            sqlQuery = "INSERT INTO " + tablename + " VALUES ('" + wijknaam + "', '2011', '" + data2011 + "');";
                            SQLQueries.Add(sqlQuery);

                            

                        }
                    }
                }
            }



            string createTableString = "create table if not exists " + (char)34 + tablename + (char)34 + @"(
wijk char(255),
Year char(10),
Data char(10),
Primary key(Year, wijk),
Foreign Key(wijk) references wijk(wijk)
);"
;

            finalQuery = createTableString;
            finalQuery += "\n";
            foreach (var subQuery in SQLQueries)
            {
                finalQuery += subQuery;
                finalQuery += "\n";
            }
            finalQuery += "\n";

            return finalQuery;
        }
        
        //Turns a string from data into a table
        private List<List<string>> toTable()
        {
            List<List<string>> table = new List<List<string>>();
            List<string> row = new List<string>();
            string celdata = "";
            for (int index = 0; index + 1 < datafilesize; index++)
            {
                switch (datafile[index])
                {
                    case ';':
                        row.Add(celdata);
                        celdata = "";
                        break;

                    case '\n':
                        row.Add(celdata);
                        celdata = "";

                        for (int i = row.Count; i < 13; i++)
                        {
                            row.Add("");
                        }

                        table.Add(row);
                        row = new List<string>();
                        break;

                    case '\r':
                        break;
                    default:
                        celdata += datafile[index];
                        break;
                }
            }
            return table;
        }
        
        //Finds the  starts of the next table, given A starting point (current row) and a table.
        private int findNextTableStart(int currentrow, List<List<string>> Table)
        {
            bool elementfound = false;

            while (currentrow < Table.Count)
            {
                if (Table[currentrow][2] != "") //element of discriptions table is not blank
                {
                    for(int i = 0; i<13; i++)   //check all cells in row
                    {
                        if (i != 2) //do is this is not the element of discription
                        {
                            if(Table[currentrow][i] != "")  //is element in row is not blank, turn element found true
                            {
                                elementfound = true;
                            }
                        }
                    }

                    if (elementfound == false)   //no element found other than cel 2, meaning this is the starts of a table
                    {
                        return currentrow;
                    }
                    elementfound = false;
                }
                currentrow++;
            }
            return Table.Count;
        }

        //Cuts an individual table from the larger table.
        private List<List<String>> cutTable(List<List<string>> Table, int CurrentRow)
        {

            bool isempty = true;

            List<List<string>> tempTable = new List<List<string>>();
            List<List<string>> finalTable = new List<List<string>>();

            int endTable = findNextTableStart(CurrentRow+1, Table);

            if(endTable > datafilesize)
            {
                endTable = datafilesize;
            }

            for(int i = CurrentRow; i<endTable; i++)
            {
                tempTable.Add(Table[i]);
            }

            foreach(var row in tempTable)
            {
                for(int i = 0; i <= 12; i++)
                {
                    if(row[i] != "")
                    {
                        isempty = false;
                    }
                }
                if (!isempty)
                {
                    finalTable.Add(row);
                    isempty = true;
                }

            }

            return finalTable;
        }
    }
}
