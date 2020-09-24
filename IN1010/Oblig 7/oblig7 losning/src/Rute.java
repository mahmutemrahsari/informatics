
public abstract class Rute {
    final int x;
    final int y;
    final Labyrint labyrint;
    Rute up, down, left, right;
    boolean visited = false;

    Rute(int y, int x, Labyrint labyrint){

        this.x=x;
        this.y = y;
        this.labyrint = labyrint;

        this.up = labyrint.getRute(x,y-1);
        this.down = labyrint.getRute(x, y+1);
        this.right = labyrint.getRute(x+1,y);
        this.left = labyrint.getRute(x-1,y);
        if(this.up !=null) this.up.down = this;
        if(this.left !=null) this.left.right = this;
    }


    public abstract char tilTegn();

    static Rute lagRute(char tegn, int rad, int kol, Labyrint labyrint ) throws Exception{
        if(tegn=='#'){
           return new SortRute(rad,kol,labyrint);
        } else if(tegn=='.' && rad>0 && kol>0 && rad < labyrint.hoyde-1 && kol<labyrint.bredde-1){
            return new HvitRute(rad, kol, labyrint);}
        else if(tegn =='.') {

            return new Aapning(rad,kol,labyrint);

        } else throw new Exception("Unexpected character!"+tegn);
    }


    public void gaa(String vei){
        vei += toString() + "-->";
    }

    //Lag så metoden ​void finnUtvei()​ i Rute som finner alle utveier fra ruten ved hjelp av kall på gaa.
    public void finnUtvei(){
        gaa("");
    }

    @Override
    public String toString(){
        return String.format("(%d, %d)", y+1, x+1);
    }
}
