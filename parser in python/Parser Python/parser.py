'''
import psycopg2     #package for postgres
import sys     
from parserLuchtkwaliteit import *
from parserLuchtlocatie import *
from parserVerkeerslocatie import *
from parserVerkeersdata import *

con = None    

try:
    con = psycopg2.connect(database='Luchtkwaliteit', user='postgres', password='Joost')    
    cur = con.cursor()

    #verkeerslocatie
    n = 9
    for i in range(0, 12):
        verkeerslocatie_sheet(n, -1, cur, con)
        n += 1

    #verkeersdata
    n = 4
    for i in range(0, 12):
        verkeersdata_sheet(n, 0, cur, con)
        n += 27

    #luchtlocatie
    luchtlocatie_sheet(cur, con)

    #luchtdata
    y2 = 0
    for i in range(0, 12):
        luchtkwaliteit_sheet(y2, cur, con)
        y2 += 15  

finally:
    if con:
        con.close()
        '''