 #Oppgave 1.1

filnavn = {}
def innlesning(filnavn):
	fil = open("salgstall.txt","r")
	for line in fil:
		(key, val) = line.split()
		filnavn[str(key)] = int(val)
	print(filnavn)
	return(filnavn)
#innlesning(filnavn)


#Oppgave 1.2

def maanedensSalgsperson():
	maximum = max(filnavn, key=filnavn.get)
	print("Maanedens ansatte er " + maximum + " med " + str(filnavn[maximum]) + " salg.")

#maanedensSalgsperson()

#Oppgave 1.3

def totaltAntallSalg():
	summenAvSalg = sum(filnavn.values())
	print("Totalt antall salg: "+str(summenAvSalg))
	return(summenAvSalg)

#totaltAntallSalg()

#Oppgave 1.4

def gjennomsnittSalg():
	length = len(filnavn)
	print("Aktive selgere denne maaneden: " + str(length))
	totaltSalg = totaltAntallSalg()
	gjennomsnitt = int(totaltSalg) / int(length)
	print("Gjennomsnittlig antall salg per salgsperson: " + str(gjennomsnitt))
#gjennomsnittSalg()

#Oppgave 1.5
def hovedprogram():
	innlesning(filnavn)
	maanedensSalgsperson()
	#totaltAntallSalg()
	gjennomsnittSalg()

#Oppgave 1.6
hovedprogram()