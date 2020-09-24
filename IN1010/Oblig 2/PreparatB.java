public class PreparatB extends Legemiddel {
   protected int styrke;

   //Konstruktoer
    PreparatB(String navn, String type, double pris, double virkestoff, int styrke){
        super(navn,type, pris,virkestoff);
        this.styrke = styrke;
    }

    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

    public String toString(){
        return super.toString() +" "+ "Styrke: " + this.styrke;
    }
}
