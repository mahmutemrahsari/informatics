
    public abstract class Resept {
        protected static int teller=0;
        protected int reseptId;
        protected Lege utskrivendeLege;
        protected Legemiddel legemiddelNummer;
        protected int pasientId;
        protected int reit;


        //Konstruktoer
        public Resept(Lege utskrivendeLege, Legemiddel legemiddelNummer, int pasientId, int reit){
            this.reit=reit;
            this.reseptId=++teller;
            this.utskrivendeLege = utskrivendeLege;
            this.legemiddelNummer = legemiddelNummer;
            this.pasientId = pasientId;

        }

        public int hentPasientId(){
            return this.pasientId;
        }


        public Lege hentLege(){
            return this.utskrivendeLege;
        }

        public int hentReseptId(){
            return this.reseptId;
        }

        public Legemiddel hentLegemiddel(){
            return this.legemiddelNummer;
        }

        public int hentReit(){
            return this.reit;
        }

        //Kontroller reit
        public boolean bruk(){
            if (this.reit > 0){
                this.reit--;
                return true;
            }else{
                return false;
            }
        }



        abstract public String farge();

        abstract public double prisAaBetale();

        public String toString(){
            return "Resept ID:" + this.reseptId +
                    " Lege:" + this.utskrivendeLege +
                    " Legemiddel:" + this.legemiddelNummer +
                    " Pasient ID:" + this.pasientId +
                    " Reit:" + this.reit + " Pris aa betale:" + prisAaBetale();
        }

    }
