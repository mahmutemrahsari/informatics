
class Militaereresepter extends HviteResepter {
	public Militaereresepter(Legemiddel Legemiddel, Lege utskrivendeLege,int pasientID,int reit) {
	super(Legemiddel, utskrivendeLege, pasientID, reit);
	}


	// alltid gir en 100% rabatt paa prisen til et legemiddel.
	
	public double prisAaBetale(){
		return this.Legemiddel.getPris()-this.Legemiddel.getPris()*1;
	}

}
