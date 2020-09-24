

public class Lege {

    protected String utskrivendeLege;
    protected static int kontrollID = 0; // Vanlig lege

    Lege(String utskrivendeLege) {
        this.utskrivendeLege = utskrivendeLege;
    }

    public int hentKontrollID(){
        return kontrollID;
    }

    public String hentNavn(){
        return this.utskrivendeLege;
    }

    //Sjekker legen om spesialist eller ikke
    public boolean sjekkSpesialist(){
        if(kontrollID !=0 ) {
            return true;
        }else {
            return false;
        }
    }

  //  public boolean harIkkeLovAaSkrivResept(){if()}

    public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit) throws UlovligUtskrift {
        Lege lege = new Lege(this.utskrivendeLege);
        if (!sjekkSpesialist()) {
            throw new UlovligUtskrift(lege, legemiddel);
        } else {
            return new BlaaResepter(lege, legemiddel, pasientID, reit);
        }
    }

    public String toString(){
        return " Lege navn:" + this.utskrivendeLege;
    }
}
