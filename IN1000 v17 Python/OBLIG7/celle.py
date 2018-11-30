class Celle:


    #Constructor
    def __init__(self):
        self._status = 0 #Cellen tar en variabel som besikriver status(levende/doed)


    #Endre status
    def settDoed(self):
        self._status = 0 #Setter statusen til cellen til doed 


    def settLevende(self):
        self._status = 1 #Setter statusen til cellen til levende
    
    #Hente status
    def erLevende(self):
        if self._status == 1: 
            return(True) 
        else:
            return(False)

    #Metoden returnerer en tegnrepresenntasjon av cellens status til bruk i tegning av brettet.
    def henteStatusTegn(self):
        if self._status == 1:
            return("o")
        else:
            return(".")

    #print metode
    def __str__(self):
        return self.henteStatusTegn()