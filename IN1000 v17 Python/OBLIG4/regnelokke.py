#Oppgave 2.1
i=1
tallene = []
while i !=0: #Naar bruker legg inn 0 lokken stopper
	i=int(input("legg inn:\n"))
	tallene.append(i)
	if i==0:
		print("Funnet")

#Skriver ut taller i listen
for tall in tallene:
	print(tall)

#Skriver ut summen av tallene i listen
minSum=0
for tall in tallene:
	minSum+=tall
print ("Summen er: "+str(minSum))

#Skriver ut minstetallen i listen
minstetall=tallene[0]
for tall in tallene:
	if tall<minstetall:
		minstetall=tall

#Skriver ut storstetallen i listen
storstetall=tallene[0]
for tall in tallene:
	if tall>storstetall:
		storstetall=tall
		
#Printer minstetallen og storstetallen
print("Mistetallet er: "+str(minstetall))
print("Størstetallet er: "+str(storstetall))