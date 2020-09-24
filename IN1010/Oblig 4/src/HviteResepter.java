public class HviteResepter extends Resept {


//Konstruktoer
    public HviteResepter(Lege utskrivendeLege, Legemiddel legemiddelNummer, Pasient pasient, int reit){
        super(utskrivendeLege, legemiddelNummer, pasient, reit);

    }

    @Override
    public Pasient hentPasient(){
        return this.pasient;
    }

    public String farge(){
        return "hvit ";
    }

    @Override
    public double prisAaBetale() {
        return legemiddel.hentPris();
    }

    @Override
    public Lege hentLege(){
        return this.utskrivendeLege;
    }

    @Override
    public int hentReseptId(){
        return this.reseptId;
    }

    @Override
    public Legemiddel hentLegemiddel(){
        return this.legemiddel;
    }

    @Override
    public int hentReit(){
        return this.reit;
    }

    @Override
    public String toString(){
        return "Farge: " + farge()+ super.toString();
    }
}
