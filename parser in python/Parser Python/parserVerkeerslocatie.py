import xlrd     #package for excell

def verkeerslocatie_sheet(x, y, cur, con):
        
    book = xlrd.open_workbook("Verkeersdata.xls")       #get excel file
    sheet0 = book.sheet_by_index(0)             #Take first sheet from excel file

    for horizontaal in range(6):            #for each column (hori)
        y += 1
        value = sheet0.cell_value(x, y)         #take value from position x, y
        if y == 0:      #meetlocatie
            meetlocatie = value
        elif y == 2:    #naam
            naam = value
        elif y == 3:    #beschikbaarheid
            beschikbaarheid = float(round(value, 1))
        elif y == 4:    #latitude
            latitude = float(value)
        elif y == 5:    #longitude
            longitude = float(value)
        print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))

    #insert values in table locatie
    cur.execute("INSERT INTO verkeerslocatie (meetlocatie, naam, beschikbaarheid, latitude, longitude) \
                        VALUES ('%s' ,'%s', '%f','%f', '%f')" % \
                        (meetlocatie, naam, beschikbaarheid, latitude, longitude)) 

    con.commit()
    
    #x = 0
    #y = 0
