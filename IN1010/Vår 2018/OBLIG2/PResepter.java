
class PResepter extends HviteResepter{
	public PResepter(Legemiddel Legemiddel, Lege utskrivendeLege,int pasientID,int reit) {
		super(Legemiddel, utskrivendeLege, pasientID, reit);
	}


	public double prisAaBetale(){
		// brukeren betaler 116 kroner mindre for legemiddelet.
		double pris = this.Legemiddel.getPris()-116;
		if(pris<0)pris=0;

		return pris;
	}

	//P-resepter den egenskapen at de alltid utskrives med 3 reit	
	public boolean bruk(){
		if (this.reit > 3){
			reit= reit - 3;
			return true;
		}else{
			return false;
		}
	}


}
