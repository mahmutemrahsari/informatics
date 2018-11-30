def minFunksjon():
	for x in range(2):
		c = 2
		print(c)
		c +=1
		b = 10
		b += a
		print(b)
	return(b)

def hovedprogram():
	a = 42
	b = 0
	print(b)
	b = a
	a = minFunksjon()
	print(b)
	print(a)

hovedprogram()

"""
Først defineres funksjonen minFunksjon(), 
som ikke tar inn noen paremetere. 
Så defineres prosedyren hovedprogram(), 
den tar heller ikke inn noen paremetere.
I hvedprogram defineres variablen a med verdien 42 og b med verdien 0.
Så blir variablen b printet ut. 
Så blir verdien til a lagret i b, slik at b blir lik a, 
altså b blir 42. Deretter kalles minFunksjon og retur verdien blir lagret i a.
Det som skjer i minFunksjon er at det kjøres en for løkke (to iterasjoner),
i løkka blir variablen c med verdien 2 deklarert, så blir den printet ut, 
også økes verdien til c med 1, så den blir 3. 
Etter det blir variablen b sat til verdien 10, 
verdien til b blir så økt med a, den blir altså 10+42=52, også blir b printet ut. 
Tilslutt blir verdien til b returnert og 
programmet blir ferdig med å kjøre minFunskjon funksjonen. 
Siden verdien som returneres er lik 52, blir a=52. 
tilslutt blir variablen a printet ut etterfulgt av variablen(b).
så det som blir printet ut tilstutt blir b=42 og a=42.

"""