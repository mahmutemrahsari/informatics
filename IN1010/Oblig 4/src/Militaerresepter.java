public class Militaerresepter extends HviteResepter {
    public Militaerresepter(Lege utskrivendeLege, Legemiddel legemiddelNummer, Pasient pasient, int reit) {
        super(utskrivendeLege, legemiddelNummer, pasient, reit);
    }

    //Gir %100 rabatt
    @Override
    public double prisAaBetale(){
        return 0.0;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}