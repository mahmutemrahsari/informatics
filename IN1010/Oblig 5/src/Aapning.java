
public class Aapning extends HvitRute {

    public Aapning(int x, int y, Labyrint labyrint){
        super(x, y,labyrint);
    }

    @Override
    public void gaa(String vei){
        vei += toString();

        if(up != null && !vei.contains(up.toString()) && up instanceof HvitRute ) up.gaa(vei);
        if(down != null && !vei.contains(down.toString()) && down instanceof HvitRute) down.gaa(vei);
        if(left != null && !vei.contains(left.toString()) && left instanceof HvitRute) left.gaa(vei);
        if(right != null && !vei.contains(right.toString()) && right instanceof HvitRute) right.gaa(vei);

        labyrint.utveier.add(vei);
    }

    @Override
    public char tilTegn() {
        return 'A';
    }
}
