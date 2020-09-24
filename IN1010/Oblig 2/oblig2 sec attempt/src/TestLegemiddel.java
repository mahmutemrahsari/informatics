public class TestLegemiddel {
    public static void main(String[] args) {
        Legemiddel legemiddelA = new PreparatA("PrepA", "A", 654.0, 4.0,54);
        Legemiddel legemiddelB = new PreparatB("PrepB", "B", 100.0, 1,12);
        Legemiddel legemiddelC = new PreparatC("PrepC", "C", 43.32, 2);

        if(testPreparatPris(legemiddelA, 654.0)) {
            System.out.println("Prisen er som forventet.");
        }
        else {
            System.out.println("Prisen er ikke som forventet.");
        }

        if(testPreparatPris(legemiddelB, 100.0)) {
            System.out.println("Prisen er som forventet.");
        }
        else {
            System.out.println("Prisen er ikke som forventet.");
        }

        if(testPreparatPris(legemiddelC, 43.32)) {
            System.out.println("Prisen er som forventet.");
        }
        else {
            System.out.println("Prisen er ikke som forventet.");
        }
    }
//Enhetstesting
    static boolean testPreparatPris(Legemiddel l, double forventetVerdi) {
        if( l.hentPris()== forventetVerdi) {
            return true;
        }
        else {
            return false;
        }
    }
}
