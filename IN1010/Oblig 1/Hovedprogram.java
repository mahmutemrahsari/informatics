public class Hovedprogram {
    public static void main(String[] args) {

        /*
        //Foerste generasjon av oppgaven

        Regneklynge abel = new Regneklynge(12);

        for(int teller = 0; teller < 650; teller ++){
            abel.settInn(new Node(64,1));
        }
        for(int teller = 0; teller < 16; teller ++){
            abel.settInn(new Node(1024,2));
        }

        */


        // Andre generasjon av oppgaven
        // Leser filen fra source
        // Jeg skriver på Intellij IDEA da trengte jeg sa "src/..."

        Regneklynge abel = new Regneklynge("src/regneklynge2.txt");

        System.out.println("\n");
        System.out.println("Noder med minst 32 GB: " + (abel.noderMedNokMinne(32)));
        System.out.println("Noder med minst 64 GB: " + (abel.noderMedNokMinne(64)));
        System.out.println("Noder med minst 128 GB: " + (abel.noderMedNokMinne(128)));
        System.out.println("Antall  prossessorer: " + (abel.antProsessorer()));
        System.out.println("Antall rack: "+ (abel.antRacks()));
        System.out.println("\n");

    }

}
