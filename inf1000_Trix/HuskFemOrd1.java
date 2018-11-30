import java.util.Scanner;

public class HuskFemOrd1{

//  Husker bare 1 ord
	
	public static void main(String[] args) {
		Scanner innleser = new Scanner(System.in);
		String innlestOrd;
		String svar;

		System.out.println("Skriv inn ord!");
		innlestOrd = innleser.nextLine();

		System.out.println("***");

		System.out.println("Hva var ordet?");
		svar = innleser.nextLine();

		if(svar.equals(innlestOrd)){
			System.out.println("Riktig");
		} else {
			System.out.println("Galt");
		}
	}
}