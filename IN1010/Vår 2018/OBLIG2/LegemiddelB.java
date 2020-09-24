class LegemiddelB extends Legemiddel{ // vanedanne legemiddel
	//Type B  har et heltall som sier hvor vanedannende det er.
	private int styrke;
	
	public LegemiddelB(String navn, double pris, double virkestoff, int styrke){
		super(navn,pris, virkestoff);
		this.styrke = styrke;
	}

	public int hentVanedannendeStyrke(){
		return this.styrke;
	}

}
