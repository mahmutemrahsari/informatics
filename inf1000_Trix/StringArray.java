import java.util.Scanner;
class StringArray{
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);
		String[] array = new String[5];
		int teller = 0;
		while (teller<array.length){
			array[teller] = tastatur.nextLine();
			System.out.println("Tastande ord: " + array[teller]);
			teller++;
		}
	}
}