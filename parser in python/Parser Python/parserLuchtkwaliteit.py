import xlrd     #package for excell
import datetime
from parser import *

def luchtkwaliteit_sheet(y2, cur, con):

    book = xlrd.open_workbook("luchtmeetnetdata.xls")   #get excel file
    sheet0 = book.sheet_by_index(0)         #Take first sheet from excel file

    x = 2       #row coordinate
    y = y2      #column coordinate
    k = 0
    
    for i in range(sheet0.nrows - 2):       #for each row        -sheet januari
        for i in range(15):                 #for each column
            y += 1

            loc_value = sheet0.cell_value(0, y)
            loc_value = loc_value.split()
            loc_naam = loc_value[0]
            print("loc_naam: " + loc_value[0] + " en " + loc_value[1])

            datum_tijd_value = str(datetime.datetime(*xlrd.xldate_as_tuple(sheet0.cell_value(x, 0), book.datemode)))
            datum_tijd_value = str(datum_tijd_value)
            datum_tijd_value = datum_tijd_value.split()
            datum = datum_tijd_value[0]      
            tijd = datum_tijd_value[1]       
            print("datum: " + datum + " tijd: " + tijd)

            value = sheet0.cell_value(x, y)      #take value from position x, y

            if y > 0:       #weghalen?
                k += 1
            if y == 0:      #weghalen?
                value = str(value)
                value.split()
                datum = value[0]
                tijd = value[1]
            else:
                if k == 1:
                    nox = float(value)
                    print(str(nox) + " " + str(k))
                elif k == 2:
                    no = float(value)
                    print(no)
                elif k == 3:
                    no2 = float(value)
                elif k == 4:
                    co = float(value)
                elif k == 5:
                    so2 = float(value)
                elif k == 6:
                    o3 = float(value)
                elif k == 7:
                    benzeen = float(value)
                elif k == 8:
                    tolueen = float(value)
                elif k == 9:
                    ethylbenzeen = float(value)
                elif k == 10:
                    pmxyleen = float(value)
                elif k == 11:
                    oxyleen = float(value)
                elif k == 12:
                    bam25 = float(value)
                elif k == 13:
                    bam25stab = float(value)
                elif k == 14:
                    bam10 = float(value)
                elif k == 15:
                    blackcarbon = float(value)
            print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))

        #insert values in table locatie    
        cur.execute("INSERT INTO luchtdata (datum, tijd, meetlocatie, nox, no, no2, co, so2, o3, benzeen, tolueen, ethylbenzeen, pmxyleen, oxyleen, bam25, bam25stab, bam10, blackcarbon) \
                        VALUES ('%s' ,'%s', '%s', '%f','%f', '%f', '%f','%f', '%f', '%f','%f', '%f','%f', '%f','%f', '%f','%f', '%f')" % \
                        (datum, tijd, loc_naam, nox, no, no2, co, so2, o3, benzeen, tolueen, ethylbenzeen, pmxyleen, oxyleen, bam25, bam25stab, bam10, blackcarbon)) 

        con.commit()

        x += 1
        y = y2
        k = 0