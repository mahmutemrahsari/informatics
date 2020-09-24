public class PreparatA extends Legemiddel {
    protected int styrke;

   //Konstruktoer
    PreparatA(String navn, String type, double pris, double virkestoff, int styrke) {
        super(navn,type, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke(){
        return this.styrke;
    }

    public String toString(){
        return  super.toString() +" "+ "Styrke: " + this.styrke;
    }
}
