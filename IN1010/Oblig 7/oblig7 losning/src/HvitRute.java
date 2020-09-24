
public class HvitRute extends Rute {
    public HvitRute(int x, int y,Labyrint labyrint){
        super(x, y, labyrint);
    }

    @Override
    public void gaa(String vei){
        if(visited) return;
        visited = true;
        vei = vei + this.toString()+ "-->";
        up.gaa(vei);
        down.gaa(vei);
        left.gaa(vei);
        right.gaa(vei);
        visited = false;
    }

    @Override
    public char tilTegn() {
        return '.';
    }
}
