import java.util.Arrays;

public class Oblig1 {

    // Oppgave 1
    // a er en heltallstabell
    public static int maks(int[] a) {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        if(a.length == 1)
            return a[0];

        int maksimum = 0;
        for (int i = 1; i <a.length; i++) {
                if (a[i - 1] > a[i]) {       // Her sjekkes a[0]> a[1] ....
                    int temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                }
        }
        return a[a.length - 1];

    }

    // Metoden for aa bytte verdier
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int ombyttinger(int[] a) {

        int antall = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {

                bytt(a, i - 1, i); // metoden bytter verdiene
                antall++;
            }
        }
        return antall;
    }


    // Oppgave 2

    public static int antallUlikeSortert(int[] a) {
        if (a.length < 1) {
            return 0; // Hvis tabellen er tom returnerer 0
        }

        for (int i = a.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (a[j - 1] > a[j]) {       // Her sjekkes a[0]> a[1] ....
                    throw new IllegalStateException("Tabellen a er ikke sortert stigende");
                }
            }
        }

        //Her finnes like verdier og teller disse verdiene
        int antall = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) {
                antall++;
            }
        }
        return a.length - antall; // Returneres antallet forskjellige verdier
    }


    // Oppgave 3
    public static int antallUlikeUsortert(int[] a) {
        if (a.length < 2) {
            return a.length; // Hvis tabellen er tom eller har bare 1 verdi returnerer lengen av arrayen
        }

        // Her finnes antallet gjentas verdier
        int antall = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] == a[i]) {
                    antall++;
                    j = i;
                }
            }
        }
        return a.length - antall; // Returneres antallet unik verdier
    }

    // Oppgave 4
    public static void delsortering(int[] a) {

        if (a.length < 2) {
            return; // Hvis tabellen er tom returnerer 0
        }


        // Finnes minimum og maksimum  i arrayen

        int minx= a[0];
        int maksx = a[0];
        for (int i = 0; i < a.length ; i++) {

                if (a[i] > maksx) maksx = a[i];
                if (a[i] < minx) minx = a[i];
        }

        int differense = maksx - minx;

        if(differense %2 == 1) differense++;

        // Kalkylles diffrensen mellom maksimum  og minimum  plus 1
        // Adder denne number to partaller

        if (differense>0) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    a[i] = a[i] + differense;
                }
            }
        }

        //Sorteres arrayen med insertion sort
            int n = a.length;
            for (int i=1; i<n; ++i)
            {
                int noekkel = a[i];
                int j = i-1;

            /* Flytt elementer av en [0..i-1], som er stoerre enn noekkelen,
            til en posisjon foran deres naavaerende posisjon. */
                while (j>=0 && a[j] > noekkel)
                {
                    a[j+1] = a[j];
                    j = j-1;
                }
                a[j+1] = noekkel;
            }

        // Tar ut differensen som har kalkyllert foer fra partallene
        if(differense>0) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    a[i] = a[i] - differense;
                }
            }
        }
    }


    //Oppgave 5

    public static void rotasjon(char[] a){
        int value = 1;
        for (int i = 0; i<value; i++){
            for (int j = a.length-1; j>0; j--){
                char temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }



    //Oppgave 6

    //Her metoden for aa bytte ut karakterene
    public static void bytt(char[] a, int i, int j) {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void rotasjon(char[] a, int k){
        if (a.length !=0){
            if ((k %= a.length)<0){
                k += a.length;
            }
        }

        if (a.length>0 || a.length < 0){

            for (int v = 0, h = a.length-1; v<h; bytt(a,v++, h--));
            for (int v = 0, h = k-1; v<h; bytt(a,v++, h--));
            for (int v = k, h = a.length-1; v<h; bytt(a,v++, h--));

        }else {
            Arrays.toString(a); //hvis lengden av arrayen 0 skrives den som den er
        }
    }
}

