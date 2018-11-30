#Oppgave 1.1
def adder(tall1, tall2):  
	total = tall1 + tall2
	print (total)
	return total

#Oppgave 1.1
tall1 = 10                
tall2 = 33
print("--"*10)
print("10 + 33 =")
adder(tall1, tall2)
print("--"*10)

#Oppgave 1.1
tall1 = 34				  
tall2 = 61
print("--"*10)
print("34 + 61 =")
adder(tall1, tall2)
print("--"*10)

#Oppgave 1.2
minTekst = str(input("Skriv inn en tekststreng: \n"))
minTekst = minTekst.lower()
minBokstav =str(input("Skriv inn en bokstav:\n"))
minBokstav = minBokstav.lower()

#Fonksjonen teller hvor mange ganger en bokstav minBokstav 
#forekommer i teksten minTekst	
def tellForekomst(minTekst, minBokstav): #Oppgave 1.3
	tell = 0
	for c in minTekst:
		if c == minBokstav:
			tell += 1
	print(tell)
	return tell

tellForekomst(minTekst, minBokstav)
