package no.oslomet.cs.algdat;

        import java.util.Arrays;
        import java.util.Objects;
        import java.util.Random;

public class Week5 {
    /**
     * En klasse som holder ifnormasjon om en person. Implmeneterer Comparable!
     */
    public static class Person implements Comparable<Person> {
        private final String fornavn;         // personens fornavn
        private final String etternavn;       // personens etternavn

        public Person(String fornavn, String etternavn) {  // konstruktør
            this.fornavn = fornavn;
            this.etternavn = etternavn;
        }

        public String fornavn() {
            return fornavn;
        }       // aksessor

        public String etternavn() {
            return etternavn;
        }   // aksessor

        public int compareTo(Person p) {   // pga. Comparable<Person>
            int cmp = etternavn.compareTo(p.etternavn);     // etternavn
            if (cmp != 0) {
                return cmp;             // er etternavnene ulike?
            }
            return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
        }

        public boolean equals(Object o) {      // vår versjon av equals
            if (o == this) {
                return true;
            }
            if (!(o instanceof Person)) {
                return false;
            }

            return (compareTo((Person) o) == 0);
        }

        public int hashCode() {
            return Objects.hash(etternavn, fornavn);
        }

        public String toString() {
            return fornavn + " " + etternavn;
        }

    } // class Person


    /**
     * Enumerering av forskjellige typer studier
     */
    public enum Studium {
        Data ("Ingeniørfag - data"),         // enumkonstanten Data
        IT ("Informasjonsteknologi"),        // enumkonstanten IT
        Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
        Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne

        private final String fulltnavn;      // instansvariabel
        private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

        public String toString() { return fulltnavn; }
    }

    /**
     * Subklasse av Person
     */
    public static class Student extends Person {  // Student blir subklasse til Person
        private final Studium studium;      // studentens studium

        public Student(String fornavn, String etternavn, Studium studium) {
            super(fornavn, etternavn);
            this.studium = studium;
        }

        public String toString() {
            return super.toString() + " (" + studium.name() + ")";
        }

        public Studium studium() {
            return studium;
        }

    }  // class Student


    /**
     * Vår definisjon av noe som likner på Comparator-interfacet i Java
     * @param <T>
     */
    @FunctionalInterface                // legges i mappen eksempelklasser
    public static interface Sammenlikner<T> {     // et funksjonsgrensesnitt
        int sammenlikn(T x, T y);            // en abstrakt metode

        /**
         * Denne returnerer en funksjon av typen Sammenlikner
         * @param <T>
         * @return
         */
        public static <T extends Comparable<? super T>> Sammenlikner<T> naturligOrden() {
            //x er Comparable og må derfor implementere compareTo-funksjonen
            return (x, y) -> x.compareTo(y);
        }

        /**
         * Omvendt av naturlig orden
         * @param <T>
         * @return
         */
        public static <T extends Comparable<? super T>> Sammenlikner<T> omvendtOrden()
        {
            return (x, y) -> y.compareTo(x);
        }

        /**
         * Hjelpeklasse som representerer en funksjon som kan kalles med anvend()-metoden
         * @param <T>
         * @param <R>
         */
        @FunctionalInterface
        public interface Funksjon<T,R> {   // T for argumenttype, R for returtype
            R anvend(T t);
        }

        /**
         * Generisk sammenlikner som tar inn typen å sammenlikne på i tillegg til
         * en måte å sammenlikne to objekter. Eksempel: Sammenlikner.orden(x -> x.toString())
         * vil sammenlikne heltall (Integer) ved å kjøre x.toString() på hvert element
         * før sammenlikningen
         * @param velger
         * @param <T>
         * @param <R>
         * @return
         */
        public static
        <T, R extends Comparable<? super R>> Sammenlikner<T>
        orden(Funksjon<? super T, ? extends R> velger)
        {
            return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
        }

        /**
         * Muliggjør syntaks slik at vi har c1.deretter(c2).deretter(c3) som
         * først sorterer ved hjelp av c1, så c2 (hvis like), så c3 (hvis fortsatt like)
         * @param c
         * @return
         */
        default <R extends Comparable<? super R>>  // tilhører grensesnittet Komparator
        Sammenlikner<T> deretter(Funksjon<? super T, ? extends R> velger)
        {
            return (x, y) ->
            {
                int k = sammenlikn(x, y);
                return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
            };
        }
    }

    /**
     * Implementering av sammenlikner-interfacet som ser på fornavn av person
     */
    public static class FornavnSammenlikner implements Sammenlikner<Person> {
        public int sammenlikn(Person p1, Person p2) {        // to personer
            return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
        }
    }





    public static void main(String[] args) {

        /**
         * Finn maksimum
         */
        {
            System.out.println("=============================");
            int[] a = {5, 2, 7, 3, 9, 1, 8, 4, 6};
            int k = maks(a);     // posisjonen til den største i a
            System.out.println(Arrays.toString(a));
            System.out.println("Maks int: " + a[k]);

            double[] d = {5.7, 3.14, 7.12, 3.9, 6.5, 7.1, 7.11};
            int l = maks(d);     // posisjonen til den største i d
            System.out.println(Arrays.toString(d));
            System.out.println("Maks double: " + d[l]);

            String[] s = {"Sohil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
            int m = maks(s);     // posisjonen til den største i s
            System.out.println(Arrays.toString(s));
            System.out.println("Maks string:" + s[m]);
        }


        /**
         * Finn maksimum med generisk metode
         */
        {
            System.out.println("=============================");
            Float[] f = {5.7f, 3.14f, 7.12f, 3.9f, 6.5f, 7.1f, 7.11f};
            int n = maks(f);     // posisjonen til den største i s
            System.out.println(Arrays.toString(f));
            System.out.println("Maks Float: " + f[n]);
        }




        /**
         * Generisk sortering
         */
        {
            System.out.println("=============================");
            String[] s = {"Sohil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
            System.out.println("Før sortering: " + Arrays.toString(s));
            innsettingsSortering(s);
            System.out.println("Etter sortering: " + Arrays.toString(s));

            Float[] f = {5.7f, 3.14f, 7.12f, 3.9f, 6.5f, 7.1f, 7.11f};
            System.out.println("Før sortering: " + Arrays.toString(f));
            innsettingsSortering(f);
            System.out.println("Etter sortering: " + Arrays.toString(f));
        }


        /**
         * Generisk grensesnitt
         */
        {
            System.out.println("=============================");
            Person[] p = new Person[5];                   // en persontabell

            p[0] = new Person("Kari", "Svendsen");         // Kari Svendsen
            p[1] = new Person("Boris", "Zukanovic");       // Boris Zukanovic
            p[2] = new Person("Ali", "Kahn");              // Ali Kahn
            p[3] = new Person("Azra", "Zukanovic");        // Azra Zukanovic
            p[4] = new Person("Kari", "Pettersen");        // Kari Pettersen

            int o = maks(p);                       // posisjonen til den største
            System.out.println(Arrays.toString(p));
            System.out.println("maks Person: " + p[o]);      // skriver ut den største

            System.out.println("Før sortering: " + Arrays.toString(p));
            innsettingsSortering(p);               // generisk sortering
            System.out.println("Etter sortering: " + Arrays.toString(p));
        }


        /**
         * Subklasser
         */
        {
            System.out.println("=============================");
            System.out.println("Enum Studium:");
            for (Studium s : Studium.values()) {
                System.out.println(s.toString() + " (" + s.name() + ")");
            }


            Student[] s = new Student[5];  // en Studenttabell
            s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen

            System.out.println("Før sortering: " + Arrays.toString(s));
            innsettingsSortering(s);               // generisk sortering
            System.out.println("Etter sortering: " + Arrays.toString(s));
        }


        /**
         * Grensesnitt for sammenlikning av fornavn
         */
        {
            System.out.println("=============================");

            Person[] p = new Person[5];                       // en persontabell
            p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
            p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
            p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
            p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
            p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

            Sammenlikner<Person> c = new FornavnSammenlikner();   // en instans av klassen

            System.out.println("Før sortering: " + Arrays.toString(p));
            innsettingsSortering(p, c);                // se Programkode 1.4.6 b)
            System.out.println("Etter sortering: " + Arrays.toString(p));
        }


        /**
         * Lambda-funksjoner
         */
        {
            System.out.println("=============================");
            /**
             * Sammenlikner studium av studentene
             */
            Sammenlikner<Student> c = (s1,s2) -> {
                int cmp = s1.studium().compareTo(s2.studium());
                return (cmp != 0) ? cmp : s1.compareTo(s2);
            };

            Student[] s = new Student[5];                             // en studenttabell
            s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
            s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
            s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
            s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
            s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen

            System.out.println("Før sortering: " + Arrays.toString(s));
            innsettingsSortering(s, c);                // se Programkode 1.4.6 b)
            System.out.println("Etter sortering: " + Arrays.toString(s));

            /**
             * Sorter på lengde av navn
             */
            String[] t = {"Lars","Anders","Bodil","Kari","Per","Berit"};
            System.out.println("Før sortering: " + Arrays.toString(t));
            innsettingsSortering(t, (s1,s2) -> s1.length() - s2.length());
            System.out.println("Etter sortering: " + Arrays.toString(t));

            /**
             * Sorter på string-verdien av et heltall
             */
            Integer[] a = {13,25,11,3,2,21,10,1,33,100};  // en Integer-tabell
            System.out.println("Før sortering: " + Arrays.toString(a));
            innsettingsSortering(a, (x,y) -> x.toString().compareTo(y.toString()));
            System.out.println("Etter sortering: " + Arrays.toString(a));
        }


        /**
         * Naturlige ordninger av tabeller => mer avansert lambda-uttrykk
         */
        {
            System.out.println("=============================");
            Integer[] a = {13, 25, 11, 3, 2, 21, 10, 1, 33, 100};  // en Integer-tabell
            System.out.println("Før sortering: " + Arrays.toString(a));
            innsettingsSortering(a, Sammenlikner.naturligOrden());
            System.out.println("Etter sortering (naturlig): " + Arrays.toString(a));
            innsettingsSortering(a, Sammenlikner.omvendtOrden());
            System.out.println("Etter sortering (omvendt): " + Arrays.toString(a));

            Student[] s = new Student[5];                             // en studenttabell
            s[0] = new Student("Kari", "Svendsen", Studium.Data);      // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);      // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);        // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);       // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);     // Kari Pettersen
            System.out.println("Før sortering: " + Arrays.toString(s));
            innsettingsSortering(s, Sammenlikner.naturligOrden());
            System.out.println("Etter sortering (naturlig): " + Arrays.toString(s));
            innsettingsSortering(s, Sammenlikner.omvendtOrden());
            System.out.println("Etter sortering (omvendt): " + Arrays.toString(s));
        }

        /**
         * Generisk ordninger av tabeller => enda mer avansert lambda-uttrykk
         */
        {
            System.out.println("=============================");
            Integer[] a = {13,25,11,3,2,21,10,1,33,100};  // en Integer-tabell
            System.out.println("Før sortering: " + Arrays.toString(a));
            innsettingsSortering(a, Sammenlikner.orden(x -> x.toString()));
            System.out.println("Etter sortering: " + Arrays.toString(a));

            Student[] s = new Student[5];                             // en studenttabell
            s[0] = new Student("Kari", "Svendsen", Studium.Data);      // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);      // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);        // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);       // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);     // Kari Pettersen
            System.out.println("Før sortering: " + Arrays.toString(s));
            //Sammenlikn ved å bruke studium()-funksjonen på hver student
            innsettingsSortering(s, Sammenlikner.orden(Student::studium));
            System.out.println("Etter sortering (naturlig): " + Arrays.toString(s));
        }


        /**
         * Leksikografiske sorteringer
         */
        {
            System.out.println("=============================");
            Sammenlikner<Student> c = (s1, s2) -> {
                int k = s1.studium().compareTo(s2.studium());
                if (k != 0) return k;    // forskjellige studier
                k = s1.fornavn().compareTo(s2.fornavn());
                if (k != 0) return k;    // forskjellige fornavn
                return s1.etternavn().compareTo(s2.etternavn());
            };

            Sammenlikner<Student> c2 = Sammenlikner.orden(Student::studium).deretter(Student::fornavn).deretter(Student::etternavn);

            Student[] s = new Student[5];                             // en studenttabell
            s[0] = new Student("Kari", "Svendsen", Studium.Data);      // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);      // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);        // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);       // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);     // Kari Pettersen
            System.out.println("Før sortering: " + Arrays.toString(s));
            innsettingsSortering(s, c2);
            System.out.println("Etter sortering (naturlig): " + Arrays.toString(s));
        }


        /***
         * Case insensitive sortering
         */
        {
            System.out.println("=============================");
            String[] s = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};
            System.out.println("Før sortering: " + Arrays.toString(s));
            innsettingsSortering(s, Sammenlikner.naturligOrden());
            System.out.println("Etter sortering (naturlig): " + Arrays.toString(s));
            innsettingsSortering(s, (x,y) -> x.compareToIgnoreCase(y));
            System.out.println("Etter sortering (ignore case): " + Arrays.toString(s));
        }
    }

    /**
     * Lager en tilfeldig permutasjon av tallene 1 til n
     * @param n
     * @return
     */
    public static Integer[] randPerm(int n) { // en effektiv versjon
        Random r = new Random();         // en randomgenerator
        Integer[] a = new Integer[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--) { // løkke som går n - 1 ganger
            // en tilfeldig tall fra 0 til k
            int i = r.nextInt(k+1);

            // Bytter om rekkefølgen
            int tmp = a[i];
            a[i] = a[k];
            a[k] = tmp;
        }

        return a;                        // permutasjonen returneres
    }

    /**
     * Finner maksimum av et array av heltall
     * @param a
     * @return
     */
    public static int maks(int[] a) {    // legges i class Tabell
        System.out.println("maks(int)");
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }


    /**
     * Finner maksimum av et array av doubles
     * @param a
     * @return
     */
    public static int maks(double[] a) {    // legges i class Tabell
        System.out.println("maks(double)");
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    /**
     * Finner maksimum av et array av strenger
     * @param a
     * @return
     */
    public static int maks(String[] a) {   // legges i class Tabell
        System.out.println("maks(String)");
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) {
            //Bruker leksikografisk sortering her
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        }
        return m;  // returnerer posisjonen til største verdi
    }

    /**
     * Generisk metode som fungerer for alle comparable typer
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> int maks(T[] a) {
        System.out.println("maks(comparable)");
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    /**
     * Generisk metode som fungerer for alle Sammenlikner-typer
     * @param a
     * @param c
     * @param <T>
     */
    public static <T> void innsettingsSortering(T[] a, Sammenlikner<? super T> c) {
        for (int i = 1; i < a.length; i++) { // starter med i = 1
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.sammenlikn(verdi,a[j]) < 0 ; j--) {
                a[j+1] = a[j];
            }

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    /**
     * Generisk versjon av innsettingsSortering
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void innsettingsSortering(T[] a) {
        System.out.println("innsettingsSortering(comparable)");
        for (int i = 1; i < a.length; i++) { // starter med i = 1
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) {
                a[j + 1] = a[j];
            }

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
}
