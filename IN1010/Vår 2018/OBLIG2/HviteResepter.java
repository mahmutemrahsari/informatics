class HviteResepter extends Resepter{
	public HviteResepter(Legemiddel Legemiddel, Lege utskrivendeLege, int pasientID, int reit) {
	super(Legemiddel, utskrivendeLege, pasientID, reit);
	}
	
	@Override
	public String farge(){
		return "hvit";

	}


	public double prisAaBetale(){
		return this.Legemiddel.getPris();

	} 
}

