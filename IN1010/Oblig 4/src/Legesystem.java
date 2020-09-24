import java.util.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Legesystem {
    // Opprett lister som lagrer objektene i legesystemet

    //NB! Denne koden skrevet med Intellij
    //filen pathname måtte "src/inndata.txt" i stedet av "inndata.txt"
    public static void main(String[] args) {
        LegesystemMain myLegeSystem = new LegesystemMain();

        File fil = new File("inndata.txt");

    //Her delt opp jeg Legesystem klassen til to
        // som LegesystemMain og Legesystem for å ha mer fleksibilitet

        myLegeSystem.lesFraFil(fil);
        myLegeSystem.Hovedmeny();
    }

}

