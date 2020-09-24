import java.util.Scanner;
import java.io.File;

class FromFile{
	public static void main(String[] args) throws Exception {

//Innlesning av en typisk fil
		Scanner fil = new Scanner(new File("navn.txt"));

		String linje = "";
		while(fil.hasNextLine()){
			linje = fil.nextLine();
			System.out.println(linje);
		}
	}
}