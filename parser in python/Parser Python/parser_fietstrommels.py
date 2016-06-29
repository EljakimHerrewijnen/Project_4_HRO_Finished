import xlrd     #package for excell
import datetime
from parser import *

def fietstrommels_sheet(x2, cursor, db):

    book = xlrd.open_workbook("Fietstrommels-maart-2013.xls")   #get excel file
    sheet0 = book.sheet_by_index(0)         #Take first sheet from excel file

    x = x2       #row coordinate
    y = -1       #column coordinate
    k = 0
    
    for i in range(sheet0.nrows + 1):       #for each row        -sheet januari
        for j in range(35):                 #for each column
            y += 1
            k += 1

            value = sheet0.cell_value(x, y)      #take value from position x, y

            if k == 1:
                invnr = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 10:
                straat = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 11:
                thv = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 19:
                xc = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 20:
                yc = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 29:
                deelgem = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 33:
                mutatiedatum = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
            elif k == 34:
                user = str(value)
                print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))

        #insert values in table locatie    
        cursor.execute('''INSERT INTO fietstrommels(inventarisnr, straat, thv, x_coordinaat, y_coordinaat, deelgemeente, mutatiedatum, door_user)
                        VALUES(?,?,?,?,?,?,?,?)''', (invnr, straat, thv, xc, yc, deelgem, mutatiedatum, user)) 
        print('invnr inserted')
        db.commit()

        x += 1
        y = -1
        k = 0