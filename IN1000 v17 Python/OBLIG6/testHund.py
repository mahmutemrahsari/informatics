from hund import Hund

#Oppgave 4.5

def hovedprogram():
	hunden1 = Hund(2, 3, 10)
	hunden1.spring()
	hunden1.spis(3)
	print(hunden1.vekt())
	hunden1.spis(2)
	print(hunden1.vekt())

hovedprogram()