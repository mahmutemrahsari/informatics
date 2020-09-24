public class TestResept {
    public static void main(String[] args) {
        Legemiddel legemiddelA = new PreparatA("PrepA", "A", 100.00, 5,54);
        Legemiddel legemiddelB = new PreparatB("PrepB", "B",200.00,4.0,32);
        Legemiddel legemiddelC = new PreparatC("PrepC","C",65.00,0.12);

        Pasient pasient1 = new Pasient("Mugulera","23243545");

        SpesialistLege house = new SpesialistLege("House",5454);
        Lege mike = new Lege("Mike",0);

        Resept blaaResept = new BlaaResepter(house, legemiddelA, pasient1, 8);
        Resept pResept = new PResepter(house, legemiddelB,pasient1);
        Resept militaerresept = new Militaerresepter(house,legemiddelC,pasient1,3);
//Enhetstesting
        if(testReseptPrisAaBetale(blaaResept, 25)) {
            System.out.println("Prisen er som forventet.");
        }
        else {
            System.out.println("Prisen er ikke som forventet.");
        }

        if(testReseptPrisAaBetale(militaerresept, 0)) {
            System.out.println("Prisen er som forventet.");
        }
        else {
            System.out.println("Prisen er ikke som forventet.");
        }

        if(testReseptPrisAaBetale(pResept, 92)) {
            System.out.println("Prisen er som forventet.");
        }
        else {
            System.out.println("Prisen er ikke som forventet.");
        }

    }
//Enhetstesting
    static boolean testReseptPrisAaBetale(Resept r, double forventetVerdi) {
        if( r.prisAaBetale()== forventetVerdi) {
            return true;
        }
        else {
            return false;
        }
    }
}
