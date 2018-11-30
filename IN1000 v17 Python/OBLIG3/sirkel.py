#Oppgave 3

from ezgraphics import GraphicsWindow #Importer ezgraphics.py som er i samme mappe med koden

x = int(input("x posisjon: ")) #koordinat x, brukeren skriver inn koordinater for x og y
y = int(input("y posisjon: ")) #koordinat y, 
R = int(input("R Diameter: ")) #Diameter er den siste verdien brukeren er bedt om å skrive inn
# Etter att brukeren har oppgitt disse verdiene da tegner programmet den røde sirkelen

win = GraphicsWindow(1280,720) # Storrelsen av vindu 
win.setTitle("SIRKEL") #Legger inn tittelen paa grafikk vinduen
canvas = win.canvas()
canvas.setColor("red") #Gir rod farge paa sirkelen
canvas.drawOval(x, y, R, R) #Tegner sirkelen
win.wait() 