import java.util.Scanner;
class Tallarray{
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		int[] tall = new int[5];
		int teller = 0;
		int summen = 0;
		// a
		while(teller<tall.length){
			tall[teller] = Integer.parseInt(tastatur.nextLine());
		// b
			summen =+ tall[teller];
			System.out.println("Summen av tallene er " + summen);
			if (tall[teller] < 10){
				System.out.println("Verdiene som er mindre enn 10 " + tall[teller]);
			}
			teller++;
		}

        
	}
}