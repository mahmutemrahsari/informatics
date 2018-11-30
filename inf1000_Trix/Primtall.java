import java.util.Scanner;

class Primtall{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tall = Integer.parseInt(sc.nextLine());
		int teller = tall;

		//TIMER STARTS

		long start = System.currentTimeMillis();

		if( teller%2 == 0){
			teller = teller-1;
		}

		while(teller > 1) {
			printPrimtall(teller);
			teller = teller -2;
		}
		
		//TIMER ENDS

		long time = System.currentTimeMillis() - start;
		System.out.println(time);
	}


	//Optimised code

	public static void printPrimtall(int tall){
		int teller = 2;
		boolean funnet = false;

		int maxTall = (tall+1)/2;
		while(teller < maxTall && !funnet) {
			if(tall % teller == 0) {
				funnet = true;
			}
			teller++;
		}

		if(!funnet){
			System.out.println("Fant primtall " + tall);
		}

	}

}