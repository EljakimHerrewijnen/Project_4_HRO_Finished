import xlrd     #package for excell

def verkeersdata_sheet(x, y, cur, con):

    book = xlrd.open_workbook("Verkeersdata.xls")       #get excel file
    sheet2 = book.sheet_by_index(2)             #Take second sheet from excel file

    for verticaal in range(24):
        x += 1
        for horizontaal in range(7):        #for each column (hori)
            y += 1
            value = sheet2.cell_value(x, y)         #take value from position x, y
            if y == 1:      #meetlocatie
                meetlocatie = value
            elif y == 2:    #tijd
                tijd = str(value)
                tijd = tijd.split()[0]
            elif y == 3:    #intensiteit
                intensiteit = int(value)
            elif y == 4:    #motor_personenauto
                motor_personenauto = float(round(value, 1))
            elif y == 5:    #licht_vrachtverkeer
                licht_vrachtverkeer = float(round(value, 1))
            elif y == 6:    #zwaar_vrachtverkeer
                zwaar_vrachtverkeer = float(round(value, 1))
            elif y == 7:    #onbepaald_verkeer
                onbepaald_verkeer = float(round(value, 1))
            print("value = " + str(value) + " en coordinaten: x = " + str(x) + " y = " + str(y))
        y = 0

        #insert values in table locatie
        cur.execute("INSERT INTO verkeersdata (meetlocatie, tijd, intensiteit, motor_personenauto, licht_vrachtverkeer, zwaar_vrachtverkeer, onbepaald_verkeer) \
                            VALUES ('%s', '%s', '%d', '%f', '%f', '%f', '%f')" % \
                            (meetlocatie, tijd, intensiteit, motor_personenauto, licht_vrachtverkeer, zwaar_vrachtverkeer, onbepaald_verkeer)) 

        con.commit()