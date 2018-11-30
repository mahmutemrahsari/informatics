#Oppgave 4

#Oppgave 4.1
mineOrd = []

#Oppgave 4.2
def slaaSammen(str1, str2):
	sammenslatte = str1 + str2
	print(sammenslatte)
	return(sammenslatte)

#Oppgave 4.3
def skrivUt(liste):
	antall=0
	for element in liste:
		print(liste)
		antall +=1

#Oppgave 4.4.  Fix loop problem not working properly
while input("gir i: ") == "i":
	str1=input("Gir forste ord: ")
	str2=input("Gir annet ord: ")
	mineOrd.append(slaaSammen(str1, str2))
while input("gir u: ") == "u":
	skrivUt(mineOrd)
while input("gir s: ") == "s":
	break
		
