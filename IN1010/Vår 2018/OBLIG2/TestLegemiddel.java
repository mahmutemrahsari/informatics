class TestLegemiddel{

	//Her tester vi Legemiddeler
	public static void main(String[] args) {
		Legemiddel Paraset = new Legemiddel("Paraset", 61.61, 21.1);
		System.out.println("Navn: " + Paraset.hentNavn());
		System.out.println("ID: " + Paraset.hentID());
		System.out.println("Virkestoff: " + Paraset.hentVirkestoff());
		Paraset.settNyPris(11.3);
		System.out.println("ny pris: " + Paraset.getPris());

		System.out.println();

		LegemiddelA Aspirin = new LegemiddelA("Aspirin", 44.1,32.43,7);
		System.out.println("Navn: " +Aspirin.hentNavn());
		System.out.println("ID: " +Aspirin.hentID());
		System.out.println("Virkestoff: " + Aspirin.hentVirkestoff());
		Aspirin.settNyPris(11.3);
		System.out.println("ny pris: " + Aspirin.getPris());
		System.out.println("NarkotiskStyrke: "+Aspirin.hentNarkotiskStyrke());		

		System.out.println();

		LegemiddelB Augmentin = new LegemiddelB("Augmentin", 21.1,42.43,11);
		System.out.println("Navn: " +Augmentin.hentNavn());
		System.out.println("ID: " +Augmentin.hentID());
		System.out.println("Virkestoff: " + Augmentin.hentVirkestoff());
		Augmentin.settNyPris(19.3);
		System.out.println("ny pris: " + Augmentin.getPris());
		System.out.println("VanedannendeStyrke: "+Augmentin.hentVanedannendeStyrke());

		System.out.println();

		LegemiddelC Zanax = new LegemiddelC("Zanax", 33.2,66.2);	

		//Her tester vi resepter og leger

		System.out.println();

		Lege aydin = new Lege("aydin");
		System.out.println("Lege Navn: " + aydin.henteUtNavn());

		BlaaResepter blr = new BlaaResepter(Paraset, aydin, 9887611, 5);
		System.out.println("Blaa Resept Farge: " + blr.farge());
		System.out.println("Blaa Resept ID: " + blr.hentid());
		System.out.println("Blaa Resept Pris: " + blr.prisAaBetale());
		System.out.println("Reit: " + blr.hentReit());


		System.out.println();

		HviteResepter hvit = new HviteResepter(Paraset, aydin, 9887611, 6);
		System.out.println("Hvit Resept Farge: " + hvit.farge());
		System.out.println("Hvite Resept ID: " + hvit.hentid());
		System.out.println("Hvite Resept Pris:" + hvit.prisAaBetale());
		System.out.println("Reit: " + hvit.hentReit());

		System.out.println();

		PResepter prr = new PResepter(Paraset, aydin, 9887611, 8);
		System.out.println("PResept Farge: " + prr.farge());
		System.out.println("PResept ID: " + prr.hentid());
		System.out.println("PResept Pris: " + prr.prisAaBetale());
		System.out.println("Reit: " + prr.hentReit());




	}
}