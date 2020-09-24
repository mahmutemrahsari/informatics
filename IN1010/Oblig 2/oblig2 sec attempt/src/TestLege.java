public class TestLege {
    public static void main(String[] args) {
        PreparatA prepA = new PreparatA("PrepA", "a", 32.00, 0.12, 12);
        PreparatB prepB = new PreparatB("PrepB", "b", 42.00, 0.14, 24);
        PreparatC prepC = new PreparatC("PrepC", "c", 52.00, 0.16);

        prepA.setNyPris(200);

        try {
            Lege ola = new Lege("Ola ");
            System.out.println(ola.skrivResept(prepA, 61, 4));
        } catch (UlovligUtskrift e) {
            System.out.println(e);
        }

        try {
            Lege dag = new Lege("Dag ");
            System.out.println(dag.skrivResept(prepA, 61, 4));
        } catch (UlovligUtskrift e) {
            System.out.println(e);
        }

        try {
            Lege john = new Lege("John ");
            System.out.println(john.skrivResept(prepB, 72, 41));
        } catch (UlovligUtskrift e) {
            System.out.println(e);
        }

        try {
            Lege mike = new Lege("Mike ");
            System.out.println(mike.skrivResept(prepC, 61, 4));
        } catch (UlovligUtskrift e) {
            System.out.println(e);
        }

        try {
            SpesialistLege house = new SpesialistLege("House ", 3243);

            if(testLege(house, 3243)) {
                System.out.println("KontrollIDen er som forventet.");
            }
            else {
                System.out.println("KontrollIDen er ikke som forventet.");
            }

            System.out.println(house.skrivResept(prepA, 343, 3));

        } catch (UlovligUtskrift e) {
            System.out.println(e);
        }
    }


//enhetstesting
    static boolean testLege(SpesialistLege l, double forventetVerdi) {
        if( l.hentKontrollID()== forventetVerdi) {
            return true;
        }
        else {
            return false;
        }
    }



}
