#Oppgave 1.

#Oppgave 1.1.
#Lista definert
list = [0, 1, 2]

#Lista ble utvidert med enkelt verdi("3")
list.append(3)

#Skriv ut det forste og tredje elementet i lista. 
print(list[0]) #Skriver ut det forste("0") elementet i lista
print(list[2]) #Skriver ut det tredje("2") elementet i lista

#Oppgave 1.2.
navnListe = [0] * 4  #Lagert ny, tom liste.

#Ber deretter brukeren om aa oppgi 4 navn, og legger disse inn i lista.
navnListe[0] = str(input("Skriv inn forste navn\n"))
navnListe[1] = str(input("Skriv inn andre navn\n"))
navnListe[2] = str(input("Skriv inn tredje navn\n"))
navnListe[3] = str(input("Skriv inn fjerde navn\n"))
#print(navnListe)

#Oppgave 1.3.
sjekkNavn = str(input("Oppgi navnet ditt:\n"))

if sjekkNavn in navnListe: #Sjekker om en verdi finnes i liste
	print("Du husket meg!")
else:
	print("Glemte du meg?")

#Oppgave 1.4.
nyNavn = ["Rick", "Morty", "Beth"] # Ny list definert
nyListe = navnListe + nyNavn # Slar sammen de to listene
print(nyListe) # Printer nyListe
del nyListe[6] #fjerner siste elementen
del nyListe[5] #fjerner siste elementen
print(nyListe) # Skriver ut listen paa nytt