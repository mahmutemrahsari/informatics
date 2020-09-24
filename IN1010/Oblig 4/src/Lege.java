

public class Lege implements Comparable<Lege>  {

    protected String utskrivendeLege;
    protected int kontrollid; // vanlig lege

    Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<>();


    public   Lege(String utskrivendeLege, int kontrollid) {
        this.utskrivendeLege = utskrivendeLege;
        this.kontrollid= kontrollid;
    }

    public int compareTo(Lege lege){
        return this.utskrivendeLege.compareTo(lege.utskrivendeLege);
    }

    public int hentKontrollID(){
        return kontrollid;
    }

    public String hentNavn(){
        return this.utskrivendeLege;
    }

    public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
       // Lege lege = new Lege(utskrivendeLege,kontrollid);
        if (legemiddel.hentType() == "a") {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
          BlaaResepter  nyBlaaResept = new BlaaResepter(this, legemiddel, pasient, reit);
            utskrevedeResepter.leggTil(nyBlaaResept);
            return nyBlaaResept;
        }
    }

    public String toString(){
        return this.utskrivendeLege +" "+ this.kontrollid;
    }
}
