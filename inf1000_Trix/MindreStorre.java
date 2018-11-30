import java.util.Scanner;

class MindreStorre{
	public static void main(String[] args) {
		int tall;
		Scanner tastatur = new Scanner(System.in);

		System.out.println("Tast inn et tall:");
		tall = Integer.parseInt(tastatur.nextLine());

		if(tall < 10) {
			System.out.println("Tallet er under 10");
		} else if(tall > 10 && tall < 20) {
			System.out.println("Tallet er mellom 10 og 20");
		} else {
			System.out.println("Tallet er over 20");
		}
	}
}