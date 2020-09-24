public class BlaaResepter extends Resept {
    public BlaaResepter(Lege utskrivendeLege, Legemiddel legemiddelNummer, Pasient pasient, int reit) {
     super(utskrivendeLege, legemiddelNummer, pasient, reit);
     }
        public String farge () {
            return "blaa ";
        }

        //pasienten må betale 25% av prisen på legemidlet.
        @Override
        public double prisAaBetale(){
            double nyPris = legemiddel.hentPris()*0.25;
            return nyPris;
        }

        @Override
        public String toString(){
            return "Farge: " + farge()+ super.toString();
        }
}
