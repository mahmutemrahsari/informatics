//Interface
interface Godkjenningsfritak{
    public int hentKontrollID();
}


public class SpesialistLege extends Lege {

    protected static int count=0;

    SpesialistLege(String utskrivendeLege, int kontrollid){

        super(utskrivendeLege, kontrollid);
        count++;
    }


    @Override
    public int hentKontrollID(){
        return this.kontrollid;
    }


    @Override
    public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
       // SpesialistLege spesialist = new SpesialistLege(this.utskrivendeLege, this.kontrollid);


        PResepter reseptx = new PResepter(this, legemiddel, pasient);
        super.utskrevedeResepter.leggTil(reseptx);
            return reseptx;
    }


    @Override
    public String toString(){
        return this.utskrivendeLege +" "+ this.kontrollid;
    }
}
