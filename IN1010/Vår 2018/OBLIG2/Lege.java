class Lege{
		// teller for aa skape ID for Lege
		private static int teller = 0;
		protected String legeNavn;
		protected int legeID;
		
	public Lege(String legeNavn){
		this.legeNavn = legeNavn;
		this.legeID = ++teller;
	}

	public String henteUtNavn(){
		return this.legeNavn;
	}


}