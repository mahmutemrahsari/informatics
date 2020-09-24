
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


class Oblig5 {
    public static void main(String[] args) {
        String filnavn = null;
        String[] ord = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk av programmet: "
                    +"java Oblig5 <labyrintfil>");
            return;
        }
        File fil = new File("src/" + filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }

        // les start-koordinater fra standard input
        Scanner inn = new Scanner(System.in);
        boolean fortsett=true;
        boolean run = true;
        System.out.println("Skriv inn koordinater <kolonne> <rad> ('a' for aa avslutte)");
        ord = inn.nextLine().split(" ");

        while (fortsett && !ord[0].equals("a")) {

        try {

            if (ord.length != 2 && !ord[0].equals("a")) {
                System.out.println("Feil input!");
                run = false;
            } else if (Integer.parseInt(ord[0]) > l.bredde - 1 || Integer.parseInt(ord[1]) > l.hoyde - 1) {
                System.out.println("Feil koordinater input! X koordinaten maa vaere mindre enn " + l.bredde +
                        " og Y koordinaten maa vaere mindre enn " + l.hoyde + "\n");
                run = false;
            } else if (ord[0].equals("a")) fortsett = false;
            else run = true;
        }catch (Exception e){
            System.out.println("Feil input!");
            run=false;
        }
                    if(run) {

                try {
                    int startKol = Integer.parseInt(ord[0]);
                    int startRad = Integer.parseInt(ord[1]);

                    List<String> utveier = l.finnUtveiFra(startKol, startRad);
                    if (utveier.size() != 0) {
                        System.out.println("Number of potential solutions: " + utveier.size() + "\n\n");
                        int i = 1;
                        for (String s : utveier) {
                            System.out.println("Solution #" + i + " (" + s.split(">").length + " steps) :\n");
                            System.out.println(s);
                            System.out.println("\n");
                            i++;

                        }
                    } else {
                        System.out.println("Ingen utveier.");
                    }
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("Ugyldig input!");
                }
            }
            System.out.println("Skriv inn nye koordinater ('a' for aa avslutte)");
            ord = inn.nextLine().split(" ");
        }
    }
}