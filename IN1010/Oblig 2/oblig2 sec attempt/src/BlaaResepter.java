public class BlaaResepter extends Resept {
    public BlaaResepter(Lege utskrivendeLege, Legemiddel legemiddelNummer, int pasientId, int reit) {
     super(utskrivendeLege, legemiddelNummer, pasientId, reit);
     }
        public String farge () {
            return "blaa ";
        }

        //pasienten må betale 25% av prisen på legemidlet.
        @Override
        public double prisAaBetale(){
            double nyPris = legemiddelNummer.hentPris()*0.25;
            return nyPris;
        }

        @Override
        public String toString(){
            return "Farge: " + farge()+ super.toString();
        }
}
