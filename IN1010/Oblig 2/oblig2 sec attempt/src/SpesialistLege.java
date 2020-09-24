//Interface
interface Godkjenningsfritak{
    public int hentKontrollID();
}


public class SpesialistLege extends Lege {
    protected int kontrollID;

    SpesialistLege(String utskrivendeLege, int kontrollID){
        super(utskrivendeLege);
        this.kontrollID=kontrollID;
    }


    @Override
    public int hentKontrollID(){
        return this.kontrollID;
    }


    @Override
    public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit) throws UlovligUtskrift{
        SpesialistLege spesialist = new SpesialistLege(this.utskrivendeLege, this.kontrollID);
            return new PResepter(spesialist, legemiddel, pasientID);
    }


    @Override
    public String toString(){
        return super.toString()+ " KontrollID:" + this.kontrollID;
    }
}
