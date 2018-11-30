#Oppgave 1
	#Oppgave 1.1
def addisjon(a, b): 
	summen = a + b
	return(summen)

print(addisjon(12,43)) #Oppgave 1.1 test setningen skriver ut resultatet

#Oppgave 1.2
def subtraksjon(a, b):
	subtraksjon = a - b
	return(subtraksjon)

def divisjon(a, b):
	divisjon = a / b
	return(divisjon)

assert addisjon(-1, 5) == 4
assert subtraksjon(9, 6) == 3
assert divisjon(14, (-7)) == -2

print(addisjon(12, 43),divisjon(55, 5), subtraksjon(44, 14))

#Oppgave 1.3 
def tommerTilCm(antallTommer):
	assert antallTommer > 0 
	return antallTommer*2.54

#Oppgave 1.4
def skrivBeregninger():
	a = int(input("Skriv inn tall 1: "))
	b = int(input("Skriv inn tall 2: "))
	print("Resultat av summering: " +  str(addisjon(a, b)))
	print("Resultat av subtraksjon: " + str(subtraksjon(a, b)))
	print("Resultat av divisjon:  " + str(divisjon(a, b)))
	print("Konvertering fra tommer til cm:")
	antallTommer = int(input("Skriv inn et tall: "))
	print("Resultat: " + (str(tommerTilCm(antallTommer))))
	
#Oppgave 1.5
skrivBeregninger()

