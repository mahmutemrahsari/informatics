#Oppgave 4

def prisSjekk(): #Oppgave 4.1  Proseydren er lagret
	
	alder = int(input("Skriv inn alderen din: ")) #Oppgave 4.2
	billetpris = 0 #Oppgave 4.2
	
	if alder <= 17:
		billetpris = 30
	elif alder > 17:  
		billetpris = 50
	elif alder >= 63:
		billetpris = 35
	
	print(billetpris)

"""
Her er problemmet i linje 10 ("elif alder > 17:")
Det er et logikk problem. Koden fungerer normalt.
Men det (alder>17) betyr at alder > 17 og paa samme tid alder >=63.
Vi kan fikse det med (alder>17 and alder<63)
Derfor annen betingelsen som er (alder >=63:) fungerer ikke.  
Bortsett fra det fungerer helt fint.
"""

prisSjekk()
prisSjekk()
prisSjekk()
prisSjekk()

		

