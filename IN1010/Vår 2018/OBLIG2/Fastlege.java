interface   Kommuneavtale   {
 public   int  hentAvtalenummer (); 
}


// Fastlege arver fra Lege
class Fastlege extends Lege implements Kommuneavtale{


	private int avtaleNummer;
	public Fastlege(String legeNavn){
		super(legeNavn);
		//tar imot en int avtalenummer.
		this.avtaleNummer = 1221321;
	}

	
	public int hentAvtalenummer(){
		return this.avtaleNummer;	


	}
}