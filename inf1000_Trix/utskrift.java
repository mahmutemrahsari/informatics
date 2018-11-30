import java.util.Scanner;

class utskrift{

	public static void Utskrift(String tekst){
		System.out.println(tekst);
	}

	public static void main(String[] args) {
		
		String enTekst = "Naber";
		String tall1 = "61";
		String tall2 = "34";
		
		int i = Integer.parseInt(tall1);
		int j = Integer.parseInt(tall2);

		String total = Integer.toString(i+j);

		Utskrift(enTekst);
		Utskrift(tall1);
		Utskrift(tall2);
		Utskrift(total);
	}
}