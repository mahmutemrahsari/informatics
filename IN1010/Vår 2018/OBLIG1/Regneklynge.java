// Klasse for representasjon av regneklynge med racks og noder
import java.util.ArrayList;

public class Regneklynge{
	private int noderPerRack;

	// Oppretter tom regneklynge for racks med oppgitt maxtall noder/ rack
	// @param noderPerRack max antall noder som kan plasseres i et rack
	private ArrayList<Rack> racks = new ArrayList<Rack>();

	public Regneklynge(int noderPerRack){
		this.noderPerRack = noderPerRack;
	}

	// Plasserer en node inn i et rack med ledig plass, eller i et nytt
	// @param node referanse til noden som skal settes inn i datastrukturen
	public void settInnNode(Node n){
		boolean nodePlaced;
		nodePlaced = false;
		for (Rack i : this.racks){
			if (i.getAntNoder() < this.noderPerRack){
				i.settInn(n);
				nodePlaced = true;
			}
		}
		if(nodePlaced == false){
			Rack newRack = new Rack();
			newRack.settInn(n);
			this.racks.add(newRack);
		}
	}

	// Beregner totalt antall prosessorer i hele regneklyngen
	// @return totalt antall prosessorer
	public int antProsessorer(){
		int counter = 0;	
		for (Rack i : this.racks){
			counter = counter + i.antProsessorer();
		}
		return counter;
	}

	// Beregner antall noder i regneklyngen med minne over angitt grense
	// @param paakrevdMinne hvor mye minne skal noder som telles med ha
	// @return antall noder med tilstrekkelig minne
	public int noderMedNokMinne(int paakrevdMinne){
		int counter = 0;
		for(Rack i : this.racks){
			counter += i.noderMedNokMinne(paakrevdMinne);
		}
		return counter;
	}

	// Henter antall racks i regneklyngen
	//@return antall racks
	public int antRacks(){
		return this.racks.size();
	}
}