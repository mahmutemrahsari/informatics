import java.util.Scanner;
class Maaneder{
	public static void main(String[] args) {

		String maaneder [] = {"Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Desember"};
		
		System.out.println("Tast inn maanedsnummer: ");
		Scanner tastatur = new Scanner(System.in);
		String linje = tastatur.nextLine();
		int valg = Integer.parseInt(linje);

		if(valg < 13 && valg > 0) {
			System.out.println(valg + "-" + maaneder[valg - 1]);
		} else{
			System.out.println("Feil: " + valg + " er ugyldig.");
		}
	}
}