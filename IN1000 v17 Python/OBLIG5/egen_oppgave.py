
malene ={}

def tommerTilCm(antallTommer):
	assert antallTommer > 0 
	return antallTommer*2.54

for linje in (open("skredder.csv", "r")):
	biter = linje.split(":")
	del_av_kropps = biter[0]

print(malene)