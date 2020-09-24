//Interface
interface Godkjenningsfritak{
    public int hentKontrollID();
}


public class SpesialistLege extends Lege {
    protected int kontrollID;

    SpesialistLege(String utskrivendeLege, int kontrollID){
        super(utskrivendeLege);
        this.kontrollID = kontrollID;
    }

    @Override
    public int hentKontrollID(){
        return this.kontrollID;
    }

    //Sjekker legen om spesialist eller ikke
    @Override
    public boolean sjekkSpesialist(){
        if(kontrollID !=0 ) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit)throws UlovligUtskrift{
        SpesialistLege spesialist = new SpesialistLege(this.utskrivendeLege,this.kontrollID);
        if(!sjekkSpesialist()){
            throw new UlovligUtskrift(spesialist, legemiddel);
        }else {
            return new PResepter(spesialist, legemiddel, pasientID, reit);
        }
    }


    @Override
    public String toString(){
        return super.toString()+ " KontrollID:" + this.kontrollID;
    }
}
