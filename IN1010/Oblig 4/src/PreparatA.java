public class PreparatA extends Legemiddel {
    protected int styrke;
    protected static int count=0;
   //Konstruktoer
    PreparatA(String navn, String type, double pris, double virkestoff, int styrke) {
        super(navn,type, pris, virkestoff);
        this.styrke = styrke;
        count++;
    }

    public int hentNarkotiskStyrke(){
        return this.styrke;
    }


}
