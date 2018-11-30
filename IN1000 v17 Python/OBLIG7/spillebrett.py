from random import randint
from celle import Celle

class Spillebrett:

    def __init__(self, rader, kolonner):
        self.generasjon = 0
        self._rader = rader
        self._kolonner = kolonner
        self._rutenett = [[Celle() for i in range(self._rader)] for j in range(self._kolonner)]
        self.generer()

        
#Metoden skriver ut brettet
    def tegnBrett(self):
        for i in range(len(self._rutenett)):
            print()
            for j in range(len(self._rutenett[i])):
                print(self._rutenett[i][j], end=' ')
        print("\n"*3)

#metoden oppdaterer rutenettet basert på reglene
    def oppdatering(self):
        doed = []
        levende =[]

        for i in range(len(self._rutenett)):
            for j in range(len(self._rutenett[i])):
                
                liste = self.finnNabu(i,j)
                antLevende = 0
                for k in range(len(liste)):
                    if(liste[k].erLevende()):
                        antLevende += 1
                if(self._rutenett[i][j].erLevende()):
                    if(antLevende<2):
                     doed.append(self._rutenett[i][j])
                    elif(antLevende>3):
                        doed.append(self._rutenett[i][j])
                    else:
                        levende.append(self._rutenett[i][j])   
                else:
                    if(antLevende==3):
                        levende.append(self._rutenett[i][j])
                

        
        for i in range(len(doed)):
            doed[i].settDoed()
        
        for i in range(len(levende)):
            levende[i].settLevende()
        self.generasjon+=1

    #generer tilfeldig brett
    def generer(self):
        for i in range(self._rader):
            for j in range(self._kolonner):
                rand = randint(0,3)
                if rand == 3:
                   self._rutenett[i][j].settLevende()

    #finner naboene til angitt plass
    def finnNabu(self, rad, kolonne):
        naboliste = []
        for i in range (-1, 2):
            for j in range (-1,2):
                naboRad = rad + i
                naboKolonne = kolonne + j
                if (naboRad == rad and naboKolonne == kolonne) != True :
                    if (naboRad < 0 or naboKolonne < 0 or naboRad > self._rader-1
    or naboKolonne > self._kolonner -1) != True:
                     naboliste.append(self._rutenett[naboRad][naboKolonne])
        return naboliste

    #finner antall levende
    def finnAntallLevende(self):
        teller =0
        for i in range(self._rader):
            for j in range(self._kolonner):
                if(self._rutenett[j][i].erLevende()):
                    teller+=1

        return teller

