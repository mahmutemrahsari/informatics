
class BlaaResepter extends Resepter{
	public BlaaResepter(Legemiddel Legemiddel, Lege utskrivendeLege, int pasientID, int reit) {
		super(Legemiddel, utskrivendeLege, pasientID, reit);	
	}

	// Gir resept fargen
	@Override
	public String farge(){ 
		return "blaa";
	}

	//pasienten maa betale 25% av prisen paa legemidlet
	@Override
	public double prisAaBetale(){
		return Legemiddel.getPris()*0.25;
	} 



}
