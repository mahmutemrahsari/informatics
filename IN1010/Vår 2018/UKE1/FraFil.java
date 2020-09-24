import java.util.Scanner;
import java.io.*; // Innlesning fra fil (spesielt(especially))
class FraFil{
	public static void main(String[]args)throws Exception{
		
		// oppretter innlesningsobjekt:
		Scanner in = new Scanner(System.in);
		

		// leser inn en setning
		System.out.println("Tast inn navnet dit: ");
		String navn = in.nextLine();
		System.out.println("Navnet dit er " + navn);
		
		// leser inn et heltall:
		System.out.println("Tast inn et heltall: ");
		String linje = in.nextLine();
		int heltall = Integer.parseInt(linje);
		System.out.println("heltall: "+ heltall);

		// leser inn et desimaltall:
		System.out.println("Tast inn et desimaltall: ");
		String desLinje = in.nextLine();
		Double desimaltall = Double.parseDouble(desLinje);
		System.out.println("desimaltall: " + desimaltall);

	}
}