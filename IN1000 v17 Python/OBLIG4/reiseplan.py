#Oppgave 4

#Oppgave 4.1 / Oppgave4.2
steder = []
klesplagg = []
avreisedatoer = []

i = 0
for i in range(5):
	steder.append(input("Legg inn reise sted:\n"))
	klesplagg.append(input("Legg inn klesplagg:\n"))
	avreisedatoer.append(input("Legg inn avreisedatoer:\n"))

"""
#Oppgave 4.2
klesplagg = []
avreisedatoer = []
j = 0
for j in range(5):
	klesplagg.append(input("Legg inn klesplagg:\n"))
	avreisedatoer.append(input("Legg inn avreisedatoer:\n"))
"""

reiseplan = [steder, klesplagg, avreisedatoer] #Oppgave 4.3
val = 0

for val in reiseplan: #4.4
	print(val)


i1 = int(input("Hente inn indeks 0-3 for reise: ")) #4.5
if 0<= i1 <= len(reiseplan)-1:
	True
else:
	print("Ugyldig input1!")

i2 = int(input("Sett inn en indeks 0-5: "))	
if 0<= i2 <= len(steder)-1:
	print(reiseplan[i1][i2])
else:
	print("Ugyldig input1!")

 
	

