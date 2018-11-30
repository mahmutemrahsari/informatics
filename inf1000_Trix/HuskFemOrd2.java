import java.util.Scanner;

public class HuskFemOrd2{
	
	public static void main(String[] args) {
		
		Scanner innleser = new Scanner(System.in);
		String[] innlestOrd = new String[5];
		String[] svar = new String[5];

		System.out.println("Skriv inn 5 order");
		
		int i = 0;
		while(i<5){
			svar[i] = innleser.nextLine();
			innlestOrd[i] = innleser.nextLine();
			//System.out.println(innlestOrd[i]);

			if(svar[i].equals(innlestOrd[i])){
				System.out.println("Riktig");
			} else {
				System.out.println("Galt");
			}
			
			i++;

			System.out.println("5. ordet er " + innlestOrd[4]);
			System.out.println("Test no: " + i);

		}

	}
}