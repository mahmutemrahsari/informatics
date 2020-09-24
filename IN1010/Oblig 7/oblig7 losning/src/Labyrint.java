import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Labyrint {
    private final Rute[][] ruter;
    final int hoyde;
    final int bredde;
    List<String> utveier;

    private Labyrint(Rute[][] ruter, int hoyde, int bredde){
        this.ruter = ruter;
        this.hoyde = hoyde;
        this.bredde = bredde;
    }

    public int giRad(){
        return hoyde;
    }

    public int giKol(){
        return bredde;
    }

     static Labyrint lesFraFil(File fil) throws FileNotFoundException {

        Scanner lesFil = new Scanner(fil);
        String dim = lesFil.nextLine();

        //dimensjonene

        int antallRader = Integer.parseInt( dim.split(" ")[0]);
        int antallKolonner = Integer.parseInt(dim.split(" ")[1]);

        Rute[][] nyRute = new Rute[antallRader][antallKolonner];
        Labyrint nyLab = new Labyrint(nyRute,antallRader,antallKolonner);

        //Fill array with Rute objects according to the maze
        for (int rad = 0; rad< antallRader; rad++){
            char[] tegn = lesFil.nextLine().toCharArray();
            for (int kol = 0; kol < antallKolonner; kol++){
                try {
                    nyRute[rad][kol] = Rute.lagRute(tegn[kol], rad, kol, nyLab);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
         return nyLab;
    }

    //Lag til slutt metoden ​Liste<String> finnUtveiFra(int kol, int rad)​ i Labyrint
    // som finner utveiene fra en rute på plass (kol, rad).
    public List<String> finnUtveiFra(int kol, int rad) throws NullPointerException{
        utveier = new ArrayList<String>();
        ruter[rad][kol].finnUtvei();
        return utveier;
    }

    String toStrig(){
     String retur = "";
     for(Rute[] rad : ruter){
         for (Rute rute : rad){
             retur += rute.tilTegn();
         }
         retur +="\n";
     }
     return retur;
    }


    public Rute getRute(int x, int y){
        if(x<0 || y<0 || x>=bredde || y>= hoyde) return null;

        return ruter[y][x];
    }

}
