public abstract class Resepter {
	// teller for aa skape ID for Resepter
	private static int teller = 0;
	protected int reseptID;
	protected Legemiddel Legemiddel;
	protected Lege utskrivendeLege;
	protected int pasientID;
	protected int reit;

	public Resepter(Legemiddel Legemiddel, Lege utskrivendeLege,int pasientID,int reit) {
		this.reseptID= ++teller;
		this.Legemiddel = Legemiddel;
		this.utskrivendeLege = utskrivendeLege;
		this.pasientID = pasientID;
		this.reit = reit;
	}

	public int hentid(){
		return this.reseptID;
	}

	public Legemiddel hentLegemiddel(){
		return this.Legemiddel;
	}

	public Lege hentLege(){
		return this.utskrivendeLege;
	}

	public int hentPasientId(){
		return this.pasientID;
	}

	public int hentReit(){
		return this.reit;
	}
	

	//En resept har et antall ganger som er igjen paa resepten (kalles reit). 
	//Hvis antall ganger igjen er 0, er resepten ugyldig.

	public boolean bruk(){
		if (this.reit > 0){
			reit --;
			return true;
		}else{
			return false;
		}
	}

	abstract public String farge();
	abstract public double prisAaBetale(); 

}

