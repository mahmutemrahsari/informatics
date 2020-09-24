
public class Aapning extends HvitRute {

    public Aapning(int x, int y, Labyrint labyrint){
        super(x, y,labyrint);
    }

    @Override
    public void gaa(String vei){
        vei += toString();
        labyrint.utveier.add(vei);
    }

    @Override
    public char tilTegn() {
        return 'A';
    }
}
