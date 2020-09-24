public abstract class Legemiddel {
    protected static int teller = 0;
    protected String navn;
    protected String type;
    protected int id;
    protected double pris;
    protected double virkestoff;

    public Legemiddel(String navn, String type, double pris, double virkestoff) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = ++teller; //Gir unik id
    }

    public int hentId(){
        return this.id;
    }

    public String hentNavn(){
        return this.navn;
    }

    public double hentVirkestoff(){
        return this.virkestoff;
    }

    public String hentType(){
        return type;
    }

    public void setNyPris(double nyPris){
        this.pris = nyPris;
    }

    public double hentPris(){
        return this.pris;
    }

    public String toString(){
        return  " Navn:" + this.navn + " "+
                " Type:" + this.type + " " +
                " Pris:" + this.pris +" " +
                " Virkestoff:" + this.virkestoff;
    }
}
