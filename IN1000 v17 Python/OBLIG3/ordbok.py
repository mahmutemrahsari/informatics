#Oppgave 2.

def oppdater(): #Oppgave 2.2 Prosedyren definert for å opdatere ordboken
	var = input("Legg inn en vare: ")
	varPris = input("Legg inn vare pris: ")
	butikk[var] = varPris

#Oppgave 2.1
butikk = {"melk":14.90, "brod":24.90, "yoghurt":12.90,"pizza":39.90}
print(butikk) #Skriver ut ordboken med en enkel print-setning


oppdater() #Oppgave 2.2. Prosedyren kalles to ganger slik at brukeren setter inn to varer  
oppdater() 

print(butikk) #Skriv ut den nye arrayen(dictionary) samme med de to nye elementene
