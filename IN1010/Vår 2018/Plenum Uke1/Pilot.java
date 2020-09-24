class Pilot{
	String navn; //= null;
	int antallTurer = 0;
	int distanseTotalt = 0;

	public Pilot(String n){
		navn = n;
	}

	public String hentNavn(){
		return navn;
	}

	//void returnerer til ingenting
	public void leggTilFlyvning(int km) {
		distanseTotalt += km;
		//distanseTotalt = distanseTotalt + km;
		antallTurer +=1;
		//antallTurer++;
	}

	public int hentTotalDist() {
		return distanseTotalt;
	}

	public double hentGjennomsnittligDist(){
		return (double) distanseTotalt / antallTurer;	
	}

}