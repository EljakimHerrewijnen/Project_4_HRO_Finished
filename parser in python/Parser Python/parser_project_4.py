import sqlite3      #SQLite3 module
import psycopg2
import sys     
from parser_fietstrommels import *
from Parser_Fietsendiefstal import *

try:
    #Create a database in RAM
    db = psycopg2.connect(database='Project_4_Database', user='postgres', password='password')
    #Creates or opens a file called mydb with a SQLite3 DB

   # db = sqlite3.connect('F:/Github/Project_4/parser in python/mydb')

    
    # Get a cursor object
    cursor = db.cursor()
    #cursor.execute('''DROP TABLE fietstrommels''')
    db.commit()
    

    # Get a cursor object
    cursor = db.cursor()
    #cursor.execute('''
    #    CREATE TABLE fietstrommels(inventarisnr TEXT PRIMARY KEY, straat TEXT, thv TEXT, x_coordinaat TEXT, 
    #                       y_coordinaat TEXT, deelgemeente TEXT, mutatiedatum TEXT, door_user TEXT)''')
    ##''')
    #cursor.execute('''Drop table Fietsendiefstal''')
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS Fietsendiefstal(Voorvalnummer varchar, Kennisname varchar, MK varchar, MKomschrijving varchar, Poging varchar, District varchar, Werkgebied varchar, Plaats varchar, Buurt varchar, Straat varchar, Begindagsoort varchar, Begindatum varchar, Begintijd varchar,
        Einddagsoort varchar, Einddatum varchar, Eindtijd varchar, Gemiddeldejaar varchar, Gemiddeldemaand varchar, Gemiddeldedagsoort varchar, Gemiddeldedagdeel6uren varchar, 
        Trefwoord varchar, Object varchar, Merk varchar, Type varchar, Kleur varchar)''')
    db.commit()

    #fietstrommels_sheet(11, cursor, db)
    FietsDiefstal_sheet(11,cursor,db)

    #cursor = db.cursor()
    #name1 = 'Joost'
    #phone1 = '3366858'
    #email1 = 'joost@example.com'
    #password1 = '12345'
 
    #name2 = 'Eljakim'
    #phone2 = '5557241'
    #email2 = 'eljakim@example.com'
    #password2 = 'abcdef'
    """
    # Insert user 1
    cursor.execute('''INSERT INTO users(name, phone, email, password)
                      VALUES(?,?,?,?)''', (name1,phone1, email1, password1))
    print('First user inserted')
 
    # Insert user 2
    cursor.execute('''INSERT INTO users(name, phone, email, password)
                      VALUES(?,?,?,?)''', (name2,phone2, email2, password2))
    print('Second user inserted')
        """
    """
    users = [(name1,phone1, email1, password1),
             (name2,phone2, email2, password2)]
    cursor.executemany(''' INSERT INTO users(name, phone, email, password) VALUES(?,?,?,?)''', users)

    db.commit()


    #id = cursor.lastrowid
    #print('Last row id: %d' % id)


    
    # Update user with id 1
    newphone = '3113093164'
    userid = 1
    cursor.execute('''UPDATE users SET phone = ? WHERE id = ? ''',
     (newphone, userid))
    db.commit()

    cursor.execute('''SELECT name, email, phone FROM users''')
    #user1 = cursor.fetchone() #retrieve the first row
    #print(user1[0]) #Print the first column retrieved(user's name)
    all_rows = cursor.fetchall()
    for row in all_rows:
        # row[0] returns the first column in the query (name), row[1] returns email column.
        print('{0} : {1}, {2}'.format(row[0], row[1], row[2]))
	    """

#except sqlite3.IntegrityError:
#    print('Record already exists')

finally:
    db.close()