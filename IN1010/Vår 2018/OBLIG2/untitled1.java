
    public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit)​ {
        Legemiddel legemiddel = new Legemiddel("Paraset","A", 34.55, 0.65);
        Lege lege = new Lege(this.utskrivendeLege);
        HviteResepter hviteResepter =  new HviteResepter(lege, legemiddel, 123, 6);
    }
