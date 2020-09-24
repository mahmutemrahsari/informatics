import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class HunderPersoner {
  public static void main(String[] args) {

    File f = new File("navn.txt");

    //Proever aa hente inn "navn.txt"
    Scanner filleser = null;
    try {
      filleser = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("Fant ikke filen!");
    }

    ArrayList<Hund> hunder = new ArrayList<>();
    ArrayList<Person> personer = new ArrayList<>();

    String linje = "";
    while (filleser.hasNextLine()) {
      linje = filleser.nextLine();

      //Deler opp linjen paa mellomrom
      String[] delt = linje.split(" ");

      //Fordeler objekter basert paa foerste bokstav
      if (delt[0].equals("P")) {
        Person p = new Person(delt[1]);

        /*Alternativt, hvis vi oensker aa ta hoeyde for lengre navn:
        String navn = "";
        for (int i = 1; i < delt.length; i++) {
          navn += delt[i] + " ";
        }
        Person p = new Person(navn);*/

        personer.add(p);

      } else if (delt[0].equals("H")){
        Hund h = new Hund(delt[1]);
        hunder.add(h);
      } else {
        System.out.println("Feil format!");
      }
    }

    System.out.println("Personer:");
    for (Person p : personer) {
      System.out.println(p.hentNavn());
    }

    System.out.println("Hunder:");
    for (Hund h : hunder) {
      System.out.println(h.hentNavn());
    }
  }
}