class Legemiddel{
	
	
	// teller for aa skape ID for legemidler
	private static int teller = 0;

	protected String navn;
	protected double pris;
	protected int id;
	protected double virkestoff;

	
	public Legemiddel(String navn, double pris, double virkestoff){
		this.navn = navn;
		this.pris = pris;
		this.virkestoff= virkestoff;
		id = ++teller;
	
	}

	public int hentID(){ //ID maa bli unik og stoerre enn 0 
        	return this.id;
    }

	public String hentNavn(){
		return this.navn;
	}

	public double hentVirkestoff(){
		return this.virkestoff;
	}

	public void settNyPris(double pris){
		this.pris=pris;

	}

	public double getPris(){
		return this.pris;
	}

}