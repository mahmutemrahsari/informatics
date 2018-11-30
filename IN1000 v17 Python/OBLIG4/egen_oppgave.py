"""Lag et program som handler en liste av 5 taller. 
Ber om brukeren for legg inn tall. Skriv ut hele listen
som har lagt inn. Deretter finn utt summen av tallene i listen
og skriv ut summen.
"""


#Ber om tall fra brukeren
taller = []

i=0
while i<5:
	taller.append(int(input("Legg inn tall: ")))
	i+=1

print(taller) #Skriver ut hele tallene

#Gir summen av taller
total =0
for tall in taller:
	total = total+tall
print("Summen er ", total)