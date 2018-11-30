from spillebrett import Spillebrett

def main():


    sp1.tegnBrett()
    print("Generasjon %d - Antall levende celler: %d" %(sp1.generasjon, sp1.finnAntallLevende()))

    x=True
    while x==True:
        tast = input("Press enter for aa fortsette. Skriv q og trykk enter for aa avslutte: \n" )
        if(tast!="q"):
           sp1.oppdatering()
           sp1.tegnBrett()
           print("Generasjon %d - Antall levende celler: %d" %(sp1.generasjon, sp1.finnAntallLevende()))

        else:
            x=False

        

# starte hovedprogrammet

rader = int(input("Rader: "))
kolonner = int(input("Kolonner: "))
sp1 = Spillebrett(rader,kolonner)

main()

