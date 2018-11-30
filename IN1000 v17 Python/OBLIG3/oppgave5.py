#Oppgave 5.

"""
Lag en tom liste. Be deretter brukeren om a oppgi 5 tall 
og legg disse inn i listen. Skriv deretter ut listen. 
Etterpå sorter den listen fra minst til storst 
og skriv ut sortert liste.
"""

def oppdateListe(): #Prosedyren som ber brukeren om a oppgi tall
	liste.append(int(input("Oppgi tall: ")))

liste = []*5 # Lager en tom liste.

oppdateListe() #Kaller prosedyren for ber brukeren om a oppgi tall
oppdateListe()
oppdateListe()
oppdateListe()
oppdateListe()

""" 
Her er alternativ losning av a kalle prosedyren fem ganger

i = 0
while (i < 5):
	oppdateListe()
	i=i+1
"""

print(liste) #Skriver ut listen som har 5 tallene

liste.sort() #Sorter tallene i listen
print(liste) #Skriver ut sortert liste