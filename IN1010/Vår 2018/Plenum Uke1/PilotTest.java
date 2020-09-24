class PilotTest {
	public static void main(String[]args) {
		Pilot sasPilot = new Pilot("Arne");
		sasPilot.leggTilFlyvning(400);
		sasPilot.leggTilFlyvning(300);
		int tot = sasPilot.hentTotalDist();
		System.out.println(sasPilot.hentNavn() + " har flydd " + tot + " km." );
	}



}