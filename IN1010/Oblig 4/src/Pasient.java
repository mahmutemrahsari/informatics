public class Pasient extends Stabel {
    protected String pasient;
    protected String foedselsnummer;
    protected static int teller = 0;
    protected int pasientId;

    protected Lenkeliste<Legemiddel> legemiddellist = new Lenkeliste<Legemiddel>();
    protected Lenkeliste<Resept> reseptlist = new Lenkeliste<Resept>();


    public Pasient(String pasient, String foedselsnummer) {
        this.pasient = pasient;
        this.foedselsnummer = foedselsnummer;
        this.pasientId = teller;
        this.teller++;
    }

    //Holder inn utskrevet resepter
    Stabel<Resept> utskrevetResept = new Stabel<Resept>();

    public void leggTil(Resept resept) {
        utskrevetResept.leggPaa(resept);
    }

    public Resept hentUt() {
        return utskrevetResept.taAv();
    }

    public int hentId() {
        return this.pasientId;
    }

    public void leginLegemiddel(Legemiddel legemiddel){
        legemiddellist.leggTil(legemiddel);
    }

    public void leginResept(Resept reseptx){
        reseptlist.leggTil(reseptx);
    }

    public void listLegemiddel(){
        for (Iterator<Resept> reseptx = reseptlist.iterator(); reseptx.hasNext();){
            Resept reseptn = reseptx.next();
            System.out.println(reseptn.reseptId + reseptn.legemiddel.toString()+" (" + reseptn.reit+")");
            //0​:​ ​Prozac​ ​(​3​ reit)
        }
    }



    public String toString(){
        return pasientId +  ": "+ this.pasient+" (Fnr " + this.foedselsnummer+")";
    }
//1​:​ ​Johnny​ ​(​fnr ​32323232323)
}
