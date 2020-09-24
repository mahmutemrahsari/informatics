//Klasse for representasjon av noder i en regneklynge
public class Node{
	int minne;
	int antPros;

	/*Oppretter en node med gitt minne-storrelse og antall prosessorer
	@param minne GB minne i den nye noden
	@param antPros antall prosessorer i den nye noden*/
	public Node(int ms, int ap){
		this.minne = ms;
		this.antPros = ap;
	}


	/*
	## Henter antall prosessorer i noden
	#  @return antall prosessorer i noden*/
	public int antProsessorer(){
		return antPros;
	}


	/*
	## Sjekker om noden har tilstrekkelig minne for et program
	#  @param paakrevdMinne GB minne som kreves for programmet
	#  @return True hvis noden har minst saa mye minne */
	public boolean nokMinne(int paakrevdMinne){
		if (paakrevdMinne <= this.minne)
			{
			return true;
			}
		else
			{
				return false;
			}

	}
}