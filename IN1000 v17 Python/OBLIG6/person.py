class Person:
	"""Klassen reperensentarer en person"""
	
	def __init__(self, navn, alder):
		self._navn = navn
		self._alder = alder
		self._hobbyer = []
	

	#Metoden tar imot en tekststreng og legger den til i hobbyer -listen.

	def leggTilHobby(self): 
		self._hobbyer.append(input("Legg inn Hobby: "))

		# brukeren ved hjelp av en løkke får legge til så mange hobbyer de vil. 
		
		while input("Vil du ha fortsette? (Ja/Nei) ").lower() == "ja":
			self._hobbyer.append(input("Legg inn Hobby: "))

		
	#Denne metoden skriver alle hobbyene etter hverandre på en linje.
	
	def skrivHobbyer(self):
		print(self._hobbyer)


	#Denne metoden skriver ut navn og alder kaller på metoden skrivHobbyer. 

	def skrivUt(self):
		print(self._navn, self._alder, self._hobbyer)
	

def hovedprogram():
	person1 = Person(input("Navn: "),input("Alder: "))
	person1.leggTilHobby()
	person1.skrivUt()
hovedprogram() 