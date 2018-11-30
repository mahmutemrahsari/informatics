class Motorsykkel:
	"""Klasse som reperenseterer en motorsykkel"""
	
	
	#Oppgave 2.1

	def __init__(self, merke, registreringsnummer, kilometerstand):
		self._merke = merke
		self._registreringsnummer = registreringsnummer
		self._kilometerstand = kilometerstand

	
	#Oppgave 2.2

	def kjor(self, km):
		self._kilometerstand += km

	
	#Oppgave 2.3
	def hentKilometerstand(self):
		return (self. _kilometerstand)

	
	#Oppgave 2.4
	def skrivUt(self):
		print(self._merke, self._registreringsnummer, self._kilometerstand)