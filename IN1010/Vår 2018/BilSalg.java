public class BilSalg{
   public static void main (String [ ] args) {
     int antallStein;
     Bil steinsT  = new Bil ("Stein");
     Bil sirisO   = new Bil ("Siri") ;
     steinsT.foresporsel ( ); 
     sirisO.foresporsel ( );
     steinsT.foresporsel ( ); 
     antallStein = steinsT.finnAntForesp();
     System.out.println("Antall forespørsler  på" +
              " Steins Toyota er " + antallStein);
     System.out.println("Antall forespørsler  totalt" +
              " er nå " + Bil.finnTotal( ) );
   } 
}

class Bil {
   private static int total = 0;
   private String eier; 
   private int antForesporsler = 0;
   
   public Bil (String  navn) {
      eier = navn;
   }
   public static int finnTotal ( ) {
      return total;
   }    		        
   public void foresporsel ( ) { 
      antForesporsler ++;
      total ++; 
   }
   public int finnAntForesp ( ) { 
      return  antForesporsler; 
   }  
}
