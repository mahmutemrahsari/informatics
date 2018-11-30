#Oppgave 2
#Oppgave 2.1
temp=[]

for line in open('temperatur.txt','r'):
    temp.append(int(line.strip()))
print(temp)



#Oppgave 2.2
def gjennomsnitt(liste):
	summen = 0
	antall = 0
	for verdi1 in liste:
		antall += 1
	for element in liste:
		summen += element
	print("Antall av verdiene i liste: " + str(antall))	
	print("Summen av verdiene i liste: " + str(summen))
	gjennomsnitt = summen / antall
	print("gjennomsnittet av verdiene i liste: " + str(gjennomsnitt))
	return(gjennomsnitt)

gjennomsnitt(temp)
