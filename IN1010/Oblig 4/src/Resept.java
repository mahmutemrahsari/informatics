
    public abstract class Resept {
        protected static int teller=0;
        protected int reseptId;
        protected Lege utskrivendeLege;
        protected Legemiddel legemiddel;
        protected Pasient pasient;
        protected int reit;


        //Konstruktoer
        public Resept(Lege utskrivendeLege, Legemiddel legemiddel, Pasient pasient, int reit){
            this.reit=reit;
            this.reseptId=++teller;
            this.utskrivendeLege = utskrivendeLege;
            this.legemiddel = legemiddel;
            this.pasient = pasient;
            pasient.leginLegemiddel(legemiddel);


        }

        public Pasient hentPasient() {
            return this.pasient;
        }

        public Lege hentLege(){
            return this.utskrivendeLege;
        }

        public int hentReseptId(){
            return this.reseptId;
        }

        public Legemiddel hentLegemiddel(){
            return this.legemiddel;
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
                    " Legemiddel:" + this.legemiddel +
                    " Pasient ID:" + this.pasient +
                    " Reit:" + this.reit + " Pris aa betale:" + prisAaBetale();
        }

    }
