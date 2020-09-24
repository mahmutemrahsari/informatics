public class PreparatB extends Legemiddel {
   protected int styrke;
    protected static int count=0;

    //Konstruktoer
    PreparatB(String navn, String type, double pris, double virkestoff, int styrke){
        super(navn,type, pris,virkestoff);
        this.styrke = styrke;
        count++;
    }

    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

}
