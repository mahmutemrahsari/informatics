public class PResepter extends HviteResepter {
    public PResepter(Lege utskrivendeLege, Legemiddel legemiddelNummer, Pasient pasient){
        super(utskrivendeLege, legemiddelNummer, pasient,3);
        reit++;
    }

    //Gir unge en rabatt på prevensjonsmidler
    @Override
    public double prisAaBetale() {
        if (((legemiddel.hentPris()-108) < 0)){
            return 0.0;
        }else{
            return  (legemiddel.pris-108);
        }
    }

    //P-resepter den egenskapen at de alltid utskrives med 3 reit
    @Override
    public boolean bruk(){
        if(this.reit > 3){
            reit = reit - 3;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
