import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
public class LegesystemMain {

    Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
    Lenkeliste<Legemiddel> legemiddler = new Lenkeliste<Legemiddel>();
    SortertLenkeliste<Lege> Legelist = new SortertLenkeliste<Lege>();
    Lenkeliste<Resept> ReseptList = new Lenkeliste<Resept>();


        //Hjelpe metoder
        public  Lege hentLege(String legeNavn) {
            for (Iterator<Lege> Legex = Legelist.iterator(); Legex.hasNext();){
                Lege legen = Legex.next();
                if(legen.hentNavn().equals(legeNavn)) return legen;
            }
            return null;
        }
        //Hjelpe metoder
        public  Pasient hentPasient(int pasientid) {
            for (Iterator<Pasient> pasientX = pasienter.iterator(); pasientX.hasNext();){
                Pasient pasient = pasientX.next();
                if(pasient.hentId()==pasientid)
                    return pasient;
            }
            return null;
        }
        //Hjelpe metoder
        public Legemiddel hentLegemiddel(int legemiddelid) {
            for (Iterator<Legemiddel> legemiddelX = legemiddler.iterator(); legemiddelX.hasNext();){
                Legemiddel legemiddel = legemiddelX.next();
                if(legemiddel.hentId()==legemiddelid)
                    return legemiddel;
            }
            return null;
        }

        //Hjelpe metoder
        public Resept hentResept(int reseptID) {
            for (Iterator<Resept> reseptx = ReseptList.iterator(); reseptx.hasNext();){
                Resept reseptn = reseptx.next();
                if(reseptn.hentReseptId()==reseptID)
                    return reseptn;
            }
            return null;
        }

        public void lesFraFil(File fil) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(fil);
            } catch (FileNotFoundException e) {
                System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
                return;
            }

            String innlest = scanner.nextLine();

            while (scanner.hasNextLine()) {

                String[] info = innlest.split(" ");

                // Legger til alle pasientene i filen
                if (info[1].compareTo("Pasienter") == 0) {
                    while (scanner.hasNextLine()) {
                        innlest = scanner.nextLine();


                        //Om vi er ferdig med å legge til pasienter, bryt whileløkken,
                        //slik at vi fortsetter til koden for å legge til legemiddler
                        if (innlest.charAt(0) == '#') {
                            break;
                        }

                        //
                        //MERK:  Her må du legge til pasienten i en lenkeliste
                        //

                        Pasient pasient = new Pasient(innlest.split(", ")[0], innlest.split(", ")[1]);
                        pasienter.leggTil(pasient);

                    }

                }
                //Legger inn Legemidlene
                else if (info[1].compareTo("Legemidler") == 0) {
                    while (scanner.hasNextLine()) {
                        innlest = scanner.nextLine();


                        //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
                        //slik at vi fortsetter til koden for å legge til leger
                        if (innlest.charAt(0) == '#') {
                            break;
                        }
                        String[] legemiddel = innlest.split(", ");
                        if (legemiddel[1].compareTo("a") == 0) {
                            //
                            //MERK:  Her må du legge til et PreparatA i en lenkeliste
                            //
                            PreparatA preparatA = new PreparatA(innlest.split(", ")[0],
                                    innlest.split(", ")[1],
                                    Double.parseDouble(innlest.split(", ")[2]),
                                    Double.parseDouble(innlest.split(", ")[3]),
                                    Integer.parseInt(innlest.split(", ")[4]));
                            legemiddler.leggTil(preparatA);
                        } else if (legemiddel[1].compareTo("b") == 0) {
                            //
                            //MERK:  Her må du legge til et PreparatB i en lenkeliste
                            //
                            PreparatB preparatB = new PreparatB(innlest.split(", ")[0],
                                    innlest.split(", ")[1],
                                    Double.parseDouble(innlest.split(", ")[2]),
                                    Double.parseDouble(innlest.split(", ")[3]),
                                    Integer.parseInt(innlest.split(", ")[4]));
                            legemiddler.leggTil(preparatB);

                        } else if (legemiddel[1].compareTo("c") == 0) {
                            //
                            //MERK:  Her må du legge til et PreparatC i en lenkeliste
                            //
                            PreparatC preparatC = new PreparatC(innlest.split(", ")[0],
                                    innlest.split(", ")[1],
                                    Double.parseDouble(innlest.split(", ")[2]),
                                    Double.parseDouble(innlest.split(", ")[3]));
                            legemiddler.leggTil(preparatC);
                        }

                    }
                }
                //Legger inn leger
                else if (info[1].compareTo("Leger") == 0) {
                    while (scanner.hasNextLine()) {
                        innlest = scanner.nextLine();
                        //Om vi er ferdig med å legge til leger, bryt whileløkken,
                        //slik at vi fortsetter til koden for å legge til resepter
                        if (innlest.charAt(0) == '#') {
                            break;
                        }
                        info = innlest.split(", ");
                        int kontrollid = Integer.parseInt(info[1]);
                        if (kontrollid == 0) {
                            //
                            //MERK:  Her må du legge til et lege objekt i en sortert lenkeliste
                            //
                            Lege lege = new Lege(innlest.split(", ")[0],
                                    Integer.parseInt(innlest.split(", ")[1]));
                            Legelist.leggTil(lege);

                        } else {
                            //
                            //MERK:  Her må du legge til et spesialist objekt i en sortert lenkeliste
                            //
                            SpesialistLege spesialistLege = new SpesialistLege(innlest.split(", ")[0],
                                    Integer.parseInt(innlest.split(", ")[1]));
                            Legelist.leggTil(spesialistLege);
                        }

                    }
                }
                //Legger inn Resepter
                else if (info[1].compareTo("Resepter") == 0) {
                    while (scanner.hasNextLine()) {
                        innlest = scanner.nextLine();
                        int legemiddelNummer = Integer.parseInt(innlest.split(", ")[0]);
                        String legeNavn = innlest.split(", ")[1];
                        int pasientID = Integer.parseInt(innlest.split(", ")[2]);
                        int reit = Integer.parseInt(innlest.split(", ")[3]);

                        Legemiddel LegemiddelX = hentLegemiddel(legemiddelNummer);
                        Lege LegeX = hentLege(legeNavn);
                        Pasient PasientX = hentPasient(pasientID);


                        //Skaper resept og leggertil i resept List
                        try {
                            Resept resept = LegeX.skrivResept(LegemiddelX, PasientX, reit);
                            ReseptList.leggTil(resept);
                            PasientX.leginResept(resept);

                        } catch (UlovligUtskrift e) {
                            System.out.println(e);
                        }
                    }
                }
            }
        }

        private void printOverview(){

            System.out.println();

            //Skrives listene av alle legemidler i systemet
            System.out.println("Legemidler i systemet:");
            for (Iterator<Legemiddel> legemiddelX = legemiddler.iterator(); legemiddelX.hasNext();) {

                System.out.println(legemiddelX.next());

            }

            System.out.println("___________________________________________");

            //Skrives listene av alle leger i systemet
            System.out.println("Leger i systemet:");
            for (Iterator<Lege> Legex = Legelist.iterator(); Legex.hasNext();){
                System.out.println(Legex.next());
            }

            System.out.println("___________________________________________");

            //Skrives listene av alle leger i systemet

            System.out.println("Resepter i systemet:");
            for (Iterator<Resept> reseptx = ReseptList.iterator(); reseptx.hasNext();){
                System.out.println(reseptx.next());
            }
            System.out.println("___________________________________________");

            System.out.println("Pasienter i systemet:");
            for (Iterator<Pasient> pasientX = pasienter.iterator(); pasientX.hasNext();) {
                System.out.println(pasientX.next());
            }
            System.out.println("___________________________________________");

            System.out.println("0: Tilbake til Hovedmeny");
            System.out.println("1: Exit");

            Scanner tastinn = new Scanner(System.in);
            int tast = tastinn.nextInt();

            if(tast==0){
                Hovedmeny();
                System.exit(0);
            }else if(tast==1){
                System.exit(0);
            }
        }

        private void createLege(){
            System.out.println();
            System.out.print("Vennligst legg til legesnavnet:");
            Scanner tastInn = new Scanner(System.in);
            String navn = tastInn.nextLine();
            System.out.print("Vennlist legg til lege sin kontrolID:");
            int kontId = tastInn.nextInt();
            Lege nyLegex = new  Lege(navn,kontId);
            Legelist.leggTil(nyLegex);
            System.out.println("Ny lege " +navn +" legget i systemet! ");
            System.out.println();
            Hovedmeny();
            System.exit(0);

        }

    private void createPasient(){
        System.out.println();
        System.out.print("Vennligst legg til pasientsnavnet:");
        Scanner tastInn = new Scanner(System.in);
        String navn = tastInn.nextLine();
        System.out.print("Vennlist legg til lege sin foedselsnummeret:");
        String foedselsnummer = tastInn.nextLine();
        Pasient nyPasientx = new Pasient(navn, foedselsnummer);
        pasienter.leggTil(nyPasientx);
        System.out.println("Ny pasient " +navn +" legget i systemet! ");
        System.out.println();
        Hovedmeny();
        System.exit(0);

    }
    private void createLegemiddel(){
        Scanner tastInn = new Scanner(System.in);
        System.out.println();
        System.out.println("Hvilket type legemiddel vil du ha legge til?");
        System.out.println("a: Type a");
        System.out.println("b: Type b");
        System.out.println("c: Type c");
        String tast = tastInn.nextLine();

        System.out.print("Vennligst legg til legemiddelsnavnet:");
        String navn = tastInn.nextLine();
        System.out.print("Vennlist legg til legemiddelspris:");
        double pris = tastInn.nextDouble();
        System.out.print("Vennlist legg til legemiddelsvirkestoff:");
        double virkestoff = tastInn.nextDouble();

        if(tast.equals("a")){
            System.out.print("Vennligst legg til legemiddelsstyrke:");
            int styrke = tastInn.nextInt();
            PreparatA nyPrepAx = new PreparatA(navn,"a",pris,virkestoff,styrke);
            legemiddler.leggTil(nyPrepAx);
            }else if(tast.equals("b")) {
            System.out.print("Vennligst legg til legemiddelsstyrke:");
            int styrke = tastInn.nextInt();
            PreparatB nyPrepBx = new PreparatB(navn, "b", pris, virkestoff, styrke);
            legemiddler.leggTil(nyPrepBx);
        }else {
            PreparatC nyPrepCx = new PreparatC(navn, "c", pris, virkestoff);
            legemiddler.leggTil(nyPrepCx);
        }
        System.out.println();
        System.out.println("Legemiddel legget til systemet vellykket!");
        System.out.println();
        Hovedmeny();
        System.exit(0);

    }
    private void createResept(){
        Scanner tastInn = new Scanner(System.in);
        System.out.println();

        System.out.println("Vennligst velg legen!");
        int i=0;
        for (Iterator<Lege> Legex = Legelist.iterator(); Legex.hasNext();){
            Lege legen = Legex.next();
            System.out.println(i+": "+ legen.hentNavn());
            i++;
        }
        int legeIndex = tastInn.nextInt();
        System.out.println();

        Pasient pasientx = listAndGetPasient();

        System.out.println();

        System.out.println("Vennligst velg legemiddelet!");
         i=0;
        for (Iterator<Legemiddel> legemiddelX = legemiddler.iterator(); legemiddelX.hasNext();){
            Legemiddel legemiddelN = legemiddelX.next();
            System.out.println(i+": "+ legemiddelN.toString());
            i++;
        }
        int legemiddelIndex = tastInn.nextInt();
        System.out.println();

        System.out.print("Vennligst legg till reit:");
        int reit = tastInn.nextInt();
        try {
            ReseptList.leggTil(Legelist.hent(legeIndex).skrivResept(legemiddler.hent(legemiddelIndex), pasientx, reit));
            System.out.println("Resept skrevet vellykket!");

        }catch (UlovligUtskrift e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        Hovedmeny();
        System.exit(0);

    }

    public Pasient listAndGetPasient(){
        Scanner tastInn= new Scanner(System.in);
        System.out.println("Vennligst velg pasienten!");
        int i=0;
        for (Iterator<Pasient> Pasientx = pasienter.iterator(); Pasientx.hasNext();){
            Pasient pasientn = Pasientx.next();
            System.out.println(i+": "+ pasientn.pasient);
            i++;
        }
        int pasientIndex = tastInn.nextInt();
        return pasienter.hent(pasientIndex);
    }

    public void statistics(){

        System.out.println();
        System.out.println("0: Generelt statistikker");
        System.out.println("1: Statistikk om mulig misbruk av narkotika");
        System.out.println("2: Statistikk om mulig misbruk av vanedannende");
        System.out.println("3: Exit til hovedmenyen");

        Scanner tastInn = new Scanner(System.in);
        int lest = tastInn.nextInt();
        System.out.println();
        if(lest==0){
            System.out.println("______Generelt Statistikker________");
            System.out.println("Antall lege:\t" + Legelist.stoerrelsen);
            System.out.println("  -Antall specialist lege:\t" + SpesialistLege.count);
            System.out.println("  -Antall normal lege:\t" + (Legelist.stoerrelsen - SpesialistLege.count));
            System.out.println();
            System.out.println("Antall pasient:\t" + pasienter.stoerrelsen);
            System.out.println();
            System.out.println("Antall legemiddler:\t"+legemiddler.stoerrelsen);
            System.out.println("  -Preperat A (Narkotistk):\t"+PreparatA.count);
            System.out.println("  -Preperat B (Vanedannende):\t"+PreparatB.count);
            System.out.println("  -Preperat C (Vanlig):\t"+PreparatC.count);
            System.out.println();
            System.out.println("Antall resepter:\t"+ReseptList.stoerrelsen);
        } else if (lest == 1){
//Vi bruker hashMap til å lagre antall resepter for hvert narkotiske legemiddler
            System.out.println("Legenavn\t narkotika\t antall" );
            for (Iterator<Lege> Legex = Legelist.iterator(); Legex.hasNext();){
                Lege legen = Legex.next();
                Map<String,Integer> legemddels = new HashMap<String, Integer>();

                    for (Iterator<Resept> reseptx = ReseptList.iterator(); reseptx.hasNext();) {
                        Resept reseptn = reseptx.next();
                        if (reseptn.utskrivendeLege == legen && reseptn.legemiddel.type.equals("a")) {
                            if (!legemddels.containsKey(reseptn.legemiddel.navn))
                                legemddels.put(reseptn.legemiddel.navn, 1);
                            else {
                                int value = legemddels.get(reseptn.legemiddel.navn);
                                value++;
                                legemddels.replace(reseptn.legemiddel.navn, value);
                            }
                        }
                    }
                    for(Map.Entry<String,Integer> entry:legemddels.entrySet()){
                        System.out.println(legen.utskrivendeLege + "\t" + entry.getKey() + "\t" + entry.getValue() );
                    }
                }
            System.out.println();
            System.out.println();
            System.out.println("Pasientnavn \t AntallNarkotika");
            for (Iterator<Pasient> pasientX = pasienter.iterator(); pasientX.hasNext();) {
                Pasient pasient = pasientX.next();
                int count = 0;

                for (Iterator<Legemiddel> legemiddelx = pasient.legemiddellist.iterator(); legemiddelx.hasNext(); ) {
                    if (legemiddelx.next().type.equals("a")) count++;

                }
                if(count>0) System.out.println(pasient.pasient + "\t" + count);
            }



        } else if (lest == 2){

            System.out.println("Legenavn\t vanedannede\t antall" );
            for (Iterator<Lege> Legex = Legelist.iterator(); Legex.hasNext();){
                Lege legen = Legex.next();
                Map<String,Integer> legemddels = new HashMap<String, Integer>();

                for (Iterator<Resept> reseptx = ReseptList.iterator(); reseptx.hasNext();) {
                    Resept reseptn = reseptx.next();
                    if (reseptn.utskrivendeLege == legen && reseptn.legemiddel.type.equals("b")) {
                        if (!legemddels.containsKey(reseptn.legemiddel.navn))
                            legemddels.put(reseptn.legemiddel.navn, 1);
                        else {
                            int value = legemddels.get(reseptn.legemiddel.navn);
                            value++;
                            legemddels.replace(reseptn.legemiddel.navn, value);
                        }
                    }
                }
                for(Map.Entry<String,Integer> entry:legemddels.entrySet()){
                    System.out.println(legen.utskrivendeLege + "\t" + entry.getKey() + "\t" + entry.getValue() );
                }

            }

            System.out.println();
            System.out.println();
            System.out.println("Pasientnavn \t AntallVanedannede");
            for (Iterator<Pasient> pasientX = pasienter.iterator(); pasientX.hasNext();) {
                Pasient pasient = pasientX.next();
                int count = 0;

                for (Iterator<Legemiddel> legemiddelx = pasient.legemiddellist.iterator(); legemiddelx.hasNext(); ) {
                    if (legemiddelx.next().type.equals("b")) count++;

                }
                if(count>0) System.out.println(pasient.pasient + "\t" + count);
            }

        }else{
            Hovedmeny();
            System.exit(0);

        }


        System.out.println();
        statistics();
        System.exit(0);

    }

    public void brukResept(){
        Scanner tastatur= new Scanner(System.in);
        System.out.println();
        System.out.println("Bruk en resept");
        System.out.println("Hvilken pasient vil du se resepter for?");
        System.out.println();
        Pasient pasientx = listAndGetPasient();
        System.out.println();
        System.out.println("Valgt pasient: " + pasientx.toString().split(": ")[1]);
        System.out.println();
        System.out.println("Hvilken resept vil du bruke?");
        pasientx.listLegemiddel();

        int lest = tastatur.nextInt();

        Resept reseptx = hentResept(lest);

        if(reseptx.bruk())
        {

            System.out.println("Brukte resept paa " + reseptx.legemiddel.navn +
                    ". Antall gjenvaerende reit: " + reseptx.hentReit());
        }
        else
        {
            System.out.println("Kunne​ ikke bruke resept paa " + reseptx.legemiddel.navn +
                    ". (​ingen gjenvaerende reit​).")  ;
        }

        System.out.println();
        Hovedmeny();
        System.exit(0);
    }

        public void Hovedmeny(){
                System.out.println();
                System.out.println("______________Velkommen til Legesystemet______________");
                System.out.println();
                System.out.println("Vennligst velg en valg!");
                System.out.println();
                System.out.println("0: Print overview");
                System.out.println("1: Legg til ny Lege ");
                System.out.println("2: Legg til ny Legemiddel");
                System.out.println("3: Legg til ny Pasient");
                System.out.println("4: Legg til ny Resept");
                System.out.println("5: Bruk en Resept for en Pasient");
                System.out.println("6: Statistikker");
                System.out.println("7: Slutt");

                Scanner tast = new Scanner(System.in);
                int lest = tast.nextInt();
                if(lest==0) printOverview();
                else if(lest==1) createLege();
                else if(lest==2) createLegemiddel();
                else if(lest==3) createPasient();
                else if(lest==4) createResept();
                else if (lest==5) brukResept();
                else if(lest==6) statistics();
                else if(lest==7) System.exit(0);
                else{
                    Hovedmeny();
                    System.exit(0);
                }






        }

    }

