package no.oslomet.cs.algdat;

public class Week2 {

    public static void main(String[] args) {
        int a[] = {1, 3, 7, 5, 40, 8, 9, 12};

        int maks_indeks = maks(a, 0, a.length);
        System.out.println("Maks ligger i " + maks_indeks);


        int x = maks(a, 0, a.length);
        int y = maks(a, 0, x);
        int z = maks(a, x+1, a.length);

        if (a[y] > a[z]) {
            System.out.println("Y er størst: " + y);
        }
        else {
            System.out.println("Z er størst: " + z);
        }

        int minetall[]= {15, 27, 23, 13, 31, 8, 9, 18, 14, 3, 7, 5, 21};
        int maksimum = maksBinaryTree(minetall);
        System.out.println("Maksimum av rekken er: " + maksimum);

        System.out.println("Hvorfor spiller 31 med 0? Kan dette gi feil noen gang?");
    }

    public static void printArray(int[] a) {
        for (int element: a) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    public static int maks(int[] a, int fra, int til) {
        //Feilsjekk at fra og til er i intervallet

        int m = fra;
        int maksverdi = a[fra];

        for (int i=fra+1; i < til ; ++i) {
            if (a[i] > maksverdi) {
                m = i;
                maksverdi = a[i];
            }
        }
        return m;
    }


    public static int maksBinaryTree(int[] a) {
        printArray(a);

        int n = a.length;

        int b[] = new int[2*n];
        System.out.println("Tom b:");
        printArray(b);

        //Copy vales from a into the end of b
        System.arraycopy(a, 0, b, n, n);
        System.out.println("Fyllt b:");
        printArray(b);

        //Skriv ut kun de elementene vi kopierte fra a
        System.out.println("Elementer fra b:");
        for (int k=n; k<2*n; k+=1) {
            System.out.print(b[k] + ", ");
        }
        System.out.println();

        //Skriv ut noen potensielle kamper
        System.out.println("Potensielle kamper i b:");
        for (int k=n; k<2*n-1; k+=2) {
            System.out.print(b[k] + "-" + b[k+1] + " ");
        }
        System.out.println();

        //Skriv ut noen potensielle kamper i motsatt rekkefølge
        System.out.println("Potensielle kamper i b (motsatt for-løkke):");
        for (int k=2*n-2; k>=n; k-=2) {
            System.out.print(b[k] + "-" + b[k+1] + " ");
        }
        System.out.println();

        //Snu for-løkken
        System.out.println("Kjører kamper");
        for (int k=2*n-2; k>=0; k-=2) {
            int left = b[k];
            int right = b[k+1];
            //Skriv ut kampene
            System.out.println(left + "+" + right + " ");
            b[k/2] = Math.max(left, right);

            //Skriv ut arrayet som det går
            printArray(b);
        }
        System.out.println();

        //Skriv ut array til slutt
        printArray(b);
        
        return b[0];
    }
}
