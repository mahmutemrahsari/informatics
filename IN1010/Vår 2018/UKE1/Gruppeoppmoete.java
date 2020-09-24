import java.util.Scanner;
import java.io.*;


class Gruppeoppmoete{
	private String[] navn = new String[14];
	private boolean[] oppmoete = new boolean[14];
	private int totaltStudenter = 0; //teller for antall unike oppmoeteindivider

	// Fyll inn med metodene nevnt over.

	public void lesInnFil(String filnavn) throws Exception {
		Scanner innfil = new Scanner(new File(filnavn));
		while(innfil.hasNextLine() && totaltStudenter < navn.length){
			// saa lenge det er fil og plass i array, lagre navn 
			navn[totaltStudenter] = innfil.nextLine(); // lagrer navnet
			totaltStudenter++; //oeker antall registrert oppmoette
		}

	}

	// Oppgave 2)
	public void registrerOppmoete(String studentnavn){
		for (int i = 0; i<totaltStudenter; i++){
			if (studentnavn.equals(navn[i])){
				oppmoete[i] = true;
			}
		}
	}

	//Oppgave 3)
	public void skrivUtAlleOppmoette(){
		for (int i = 0; i<totaltStudenter; i++){
			if (oppmoete[i]){
				System.out.println(navn[i] + " har moett.");
			}else{
				System.out.println(navn[i] + " har IKKE moett");
			}
		}
	}

}