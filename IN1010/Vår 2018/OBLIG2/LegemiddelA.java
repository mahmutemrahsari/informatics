class LegemiddelA extends Legemiddel{//narkotisk legemiddel
	//Type A  har et heltall som sier hvor sterkt narkotisk det er.
	private int styrke; //hvorSterkNarkotisk;
	
	public LegemiddelA(String navn, Double pris, Double virkestoff, int styrke){
		super(navn,pris,virkestoff);
		this.styrke = styrke;
	}

	public int hentNarkotiskStyrke(){
	 	return this.styrke;
	}


}