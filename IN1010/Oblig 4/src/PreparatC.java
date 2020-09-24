public class PreparatC extends Legemiddel{
    protected static int count=0;

    PreparatC(String navn, String type, double pris, double virkestoff){
        super(navn,type, pris,virkestoff);
        count++;
    }
}
