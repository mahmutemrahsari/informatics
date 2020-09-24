

public class HvitRute extends Rute {
    public HvitRute(int x, int y,Labyrint labyrint){
        super(x, y, labyrint);
    }

    @Override
    public void gaa(String vei){

        vei = vei + this.toString()+ "-->";

        if(!vei.contains(up.toString()) && up instanceof HvitRute ) up.gaa(vei);
        if(!vei.contains(down.toString()) && down instanceof HvitRute) down.gaa(vei);
        if(!vei.contains(left.toString()) && left instanceof HvitRute) left.gaa(vei);
        if(!vei.contains(right.toString()) && right instanceof HvitRute) right.gaa(vei);

    }

    @Override
    public char tilTegn() {
        return '.';
    }
}
