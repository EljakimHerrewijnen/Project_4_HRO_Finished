import xlrd     #package for excell
from parser import *

def luchtlocatie_sheet(cur, con):

    x = 0       #row coordinate
    y = -1      #column coordinate

    book = xlrd.open_workbook("luchtmeetnetdata.xls")       #get excel file
    sheet1 = book.sheet_by_index(1)                 #Take first sheet from excel file
        
    for i in range(sheet1.nrows - 1):       #for each row        -sheet meta
        x += 1
        for i in range(sheet1.ncols - 1):       #for each column
            y += 1
            value = sheet1.cell_value(x, y)     #take value from position x, y
            if y == 0:
                locatie = value
            elif y == 1:
                loc_x = value
            elif y == 2:
                loc_y = value
            elif y == 4:
                loc_naam = value
            print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
        y = -1

        #insert values in table locatie
        cur.execute("INSERT INTO luchtlocatie (meetlocatie, naam, x, y) VALUES ('%s', '%s', '%d', '%d')" % (locatie, loc_naam, loc_x, loc_y))   
        print("Number of rows updated: %d" % cur.rowcount)

        con.commit()
        