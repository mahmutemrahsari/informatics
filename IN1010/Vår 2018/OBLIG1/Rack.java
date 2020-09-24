

//## Klasse for representasjon av racks i en regneklynge.

import java.util.ArrayList;

public class Rack{

	//## oppretter et rack der det senere kan plasseres noder
	private ArrayList<Node> nodes = new ArrayList<Node>(); 


	/*## Plasserer en ny node inn i racket
	#  @param node noden som skal plasseres inn*/

	public void settInn(Node n){ 
		this.nodes.add(n);
	}


	/*## Henter antall noder i racket
	# @return antall noder*/

	public int getAntNoder(){
		return this.nodes.size();
	}

	/*## Beregner sammenlagt antall prosessorer i nodene i et rack
	# @return antall prosessorer*/

	public int antProsessorer(){
		int counter = 0;
		for (Node i : this.nodes) {
			counter = counter + i.antProsessorer();
		}
		return counter;
	}


	/*## Beregner antall noder i racket med minne over gitt grense
	# @param paakrevdMinne antall GB minne som kreves
	# @return antall noder med tilstrekkelig minne*/

	public int noderMedNokMinne(int paakrevdMinne){
		int counter = 0;
		for (Node i : this.nodes){
			if(i.nokMinne(paakrevdMinne)){
				counter +=1;
			}
		}
		return counter;
	}
}