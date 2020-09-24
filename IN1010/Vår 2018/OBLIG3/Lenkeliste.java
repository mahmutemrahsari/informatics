/*
interface Liste<T> {
	public int stoerrelse ();
	public void leggTil(int pos, T x); 
	public void leggTil(T x);
	public void sett(int pos, T x ); 
	public T hent (int pos);
	public T fjern (int pos);
	public T fjern (); 
}	
*/

class Lenkeliste<T>{


		private class Node{
			Node neste = null;
			T data;
			Node(T x){
				data = x;
				}
		}
		private Node start = null;

	
	//Setter inn et element paa slutten av listen
	public void leggTil(T x){
		Node ny = new Node(data);
		

	}
	


	//Fjerner og returnere elementet paa starten av listen.
	
	public T fjern(){}



	//Setter inn elementet paa en gitt posisjon og overskrive det som var der fra foer av.
	public void sett(int pos, T x){
		data[pos] = x;

	}


	//Legger inn et nytt element i listen og skyver neste element ett hakk lenger bak.
	//public void leggTil(int pos, T x){}

	
	//Fjerner paa gitt indeks i listen.
	public T fjern(int pos){

	}


	public int stoerrelse(){
		return iBruk;
	}

	//henter ut et element (uten aa fjerne det fra lista) paa oppgitt indeks 
	//(husk aa telle fra indeks 0 og oppover).
	public T hent(int pos){
		return data[pos];

	}

	
}
