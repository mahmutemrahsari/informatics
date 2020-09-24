

public class Lege {

    protected String utskrivendeLege;
    protected static int kontrollID=0; // vanlig lege

    public   Lege(String utskrivendeLege) {
        this.utskrivendeLege = utskrivendeLege;
    }

    public int hentKontrollID(){
        return kontrollID;
    }

    public String hentNavn(){
        return this.utskrivendeLege;
    }



    public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit) throws UlovligUtskrift {
        Lege lege = new Lege(utskrivendeLege);
        if (legemiddel.hentNavn()=="PrepA") {
            throw new UlovligUtskrift(lege, legemiddel);
        } else {
            return new BlaaResepter(lege, legemiddel, pasientID, reit);
        }
    }

    public String toString(){
        return " Lege navn:" + this.utskrivendeLege;
    }
}
