
public class SortRute extends Rute {
    public SortRute(int x, int y, Labyrint labyrint){
        super(x, y, labyrint);
    }

    @Override
    public char tilTegn() {
        return '#';
    }
}
