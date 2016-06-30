import xlrd     #package for excell
import datetime
from parser import *

def FietsDiefstal_sheet(x2, cursor, db):

    book = xlrd.open_workbook("fietsdiefstal-rotterdam-2011-2013.xls")   #get excel file
    sheet0 = book.sheet_by_index(0)         #Take first sheet from excel file

    x = 1       #row coordinate
    y = -1       #column coordinate
    k = 0
    
    for i in range(19758):       #for each row        -sheet januari
        for j in range(25):                 #for each column
            y += 1
            k += 1

            value = sheet0.cell_value(x, y)      #take value from position x, y

            if k == 1:
                Voorvalnummer = str(value)
            elif k == 2:
                Kennisname = str(value)
            elif k == 3:
                MK = str(value)
            elif k == 4:
                MKomschrijving = str(value)
            elif k == 5:
                Poging = str(value)
            elif k == 6:
                District = str(value)
            elif k == 7:
                Werkgebied = str(value)
            elif k == 8:
                Plaats = str(value)
            elif k == 9:
                Buurt = str(value)
            elif k == 10:
                Straat = str(value)
            elif k == 11:
                Begindagsoort = str(value)
            elif k == 12:
                Begindatum = str(value)
            elif k == 13:
                Begintijd = str(value)
            elif k == 14:
                Einddagsoort = str(value)
            elif k == 15:
                Einddatum = str(value)
            elif k == 16:
                Eindtijd = str(value)
            elif k == 17:
                Gemiddeldejaar = str(value)
            elif k == 18:
                Gemiddeldemaand = str(value)
            elif k == 19:
                Gemiddeldedagsoort = str(value)
            elif k == 20:
                Gemiddeldedagdeel6uren = str(value)
            elif k == 21:
                Trefwoord = str(value)
            elif k == 22:
                Object = str(value)
            elif k == 23:
                Merk = str(value)
            elif k == 24:
                Type = str(value)
            elif k == 25:
                Kleur = str(value)
                print(i)
        #insert values in table locatie    
        cursor.execute('''INSERT INTO Fietsendiefstal(Voorvalnummer, Kennisname, MK, 
        MKomschrijving, Poging, District, Werkgebied, Plaats, Buurt, Straat, Begindagsoort, 
        Begindatum, Begintijd, Einddagsoort, Einddatum, Eindtijd, Gemiddeldejaar, 
        Gemiddeldemaand, Gemiddeldedagsoort, Gemiddeldedagdeel6uren, 
        Trefwoord, Object, Merk, Type, Kleur)
                        VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)''', (Voorvalnummer, Kennisname, MK, MKomschrijving, Poging, District, Werkgebied, Plaats, Buurt, Straat, Begindagsoort, Begindatum, Begintijd, Einddagsoort, Einddatum, Eindtijd, Gemiddeldejaar, Gemiddeldemaand, Gemiddeldedagsoort, Gemiddeldedagdeel6uren, Trefwoord, Object, Merk, Type, Kleur)) 
        print('invnr inserted')
        db.commit()

        


        x += 1
        y = -1
        k = 0