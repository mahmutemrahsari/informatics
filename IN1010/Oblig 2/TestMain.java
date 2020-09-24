
//Her denne klassen tester jeg for alt som oenskes.
//Opprettes hvert av objektene og skrives ut 
public class TestMain {
    public static void main(String[] args) {
        PreparatA prepA = new PreparatA("PrepA","a", 32.00,0.12,12);
        PreparatB prepB = new PreparatB("PrepB", "b", 42.00,0.14,24);
        PreparatC prepC = new PreparatC("PrepC","c",52.00,0.16);

        prepA.setNyPris(200);

        try{
            Lege Emrah = new Lege("Emrah ");
            System.out.println(Emrah.skrivResept(prepA, 61, 4));
        }
        catch(UlovligUtskrift e){
            System.out.println(e);
        }

        try{
            Lege Emrah = new Lege("Emrah ");
            System.out.println(Emrah.skrivResept(prepA, 61, 4));
        }
        catch(UlovligUtskrift e){
            System.out.println(e);
        }

        try{
            Lege Emrah = new Lege("Emrah ");
            System.out.println(Emrah.skrivResept(prepB, 72, 41));
        }
        catch(UlovligUtskrift e){
            System.out.println(e);
        }

        try{
            Lege Emrah = new Lege("Emrah ");
            System.out.println(Emrah.skrivResept(prepC, 61, 4));
        }
        catch(UlovligUtskrift e){
            System.out.println(e);
        }

        try{
            SpesialistLege Fatih = new SpesialistLege("Fatih ", 6161);
            System.out.println(Fatih.skrivResept(prepA, 343, 12));
        }
        catch(UlovligUtskrift e){
            System.out.println(e);
        }

    }
}
