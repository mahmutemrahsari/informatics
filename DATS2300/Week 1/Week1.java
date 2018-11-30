package no.oslomet.cs.algdat;

/**
 * Klasse som går gjennom litt av det vi har snakket om i uke 1 av AlgDat
 */
public class Week1 {

    public static void main(String[] args) {
        System.out.println("Hei AlgDat 2018");

        // Bestem lengden av arrayet vi skal lage
        int num_values = 100;

        // Lag random array med metode 1
        int values1[] = randomArray1(num_values);
        printArray(values1);

        // Lag random array med metode 2
        int values2[] = randomArray2(num_values);
        printArray(values2);

        //Test hvor lang tid det tar med randomArray1
        //Tar det like lang tid hver gang? Hvorfor / hvorfor ikke?
        int num_values_timing = 1000000;
        {
            //"Oppvarming" for å cache funksjonen
            //Merk at den kjører med få verdier - skal ikke ta lang tid
            randomArray1(100);

            //Faktisk test
            long tic = System.currentTimeMillis();
            int values3[] = randomArray1(num_values_timing);
            long toc = System.currentTimeMillis();
            System.out.println("Randomarray1 tok " + (toc - tic) + " milliseconds");
        }

        //Tidtaking av randomArray2
        //Er den raskere / tregere enn randomArray1? Hvorfor/hvorfor ikke?
        {
            long tic = System.currentTimeMillis();
            int values3[] = randomArray2(num_values_timing);
            long toc = System.currentTimeMillis();
            System.out.println("Randomarray2 tok " + (toc - tic) + " milliseconds");
        }

        //Ta tiden på findMaximum
        //Siden det tar så kort tid å finne maksimum med vår
        // metode må vi teste den mange ganger og ta et gjennomsnitt
        int values4[] = randomArray2(num_values_timing);
        long tic = System.currentTimeMillis();
        int maksimum = Integer.MIN_VALUE;
        int num_iterations = 1000;
        for (int i=0; i<num_iterations; ++i) {
            maksimum = findMaximum(values4);
        }
        long toc = System.currentTimeMillis();
        System.out.println("Maksimum er " + maksimum);
        System.out.println("Det tok i gjennomsnitt " + (toc-tic)/(double) num_iterations + " ms");
    }

    public static int findMaximum(int values[]) {
        int maximum = Integer.MIN_VALUE;
        for (int i=0; i<values.length; ++i) {
            if (maximum < values[i]) {
                maximum = values[i];
            }
        }

        return maximum;
    }


    /**
     * Funksjon som lager et array med tilfeldige tall mellom
     * 1 og num_values uten duplikater
     * @param num_values Lengden på arrayet
     * @return Array med lengde num_values
     */
    public static int[] randomArray1(int num_values) {
        System.out.println("randomArray1 lager et array");
        int values[] = new int[num_values];
        int taken[] = new int[num_values];

        // Loop over arrayen og fyll med tall
        for (int i=0; i<num_values; ++i) {
            //values[i] = i+1;
            int random_value = (int) (Math.random()*num_values + 1);
            if (taken[random_value-1] == 1) {
                i = i-1;
            }
            else {
                values[i] = random_value;
                taken[random_value-1] = 1;
            }
        }

        return values;
    }

    /**
     * Funksjon som lager et array med tilfeldige tall mellom
     * 1 og num_values uten duplikater
     * @param num_values Lengden på arrayet
     * @return Array med lengde num_values
     */
    public static int[] randomArray2(int num_values) {
        System.out.println("randomArray2 lager et array");
        int values[] = new int[num_values];

        //Fyll arrayet med tallene 1 til 10
        for (int i=0; i<num_values; ++i) {
            values[i] = i+1;
        }

        //Loop gjennom arrayet, og bytt random
        for (int i=num_values-1; i > 0; --i) {
            // Trekk et tilfeldig tall mellom 0 og i
            int k = (int) (Math.random()*i);

            //bytt tallene k og i
            int temp = values[i];
            values[i] = values[k];
            values[k] = temp;
        }

        return values;
    }


    /**
     * Funksjon som skriver ut et array til skjerm
     * @param a Arrayet å skrive ut
     */
    public static void printArray(int[] a) {
        System.out.print("[");
        if (a.length > 0) {
            System.out.print(a[0]);
        }
        for (int i=1; i<a.length; ++i) {
            System.out.print(", " + a[i]);
        }
        System.out.println("]");
    }
}
