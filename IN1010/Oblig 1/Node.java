/*
Klassen skal kunne initiere nye objekter
med ønsket minnestørrelse og prosessorantall,
og for øvrig tilby tjenester (metoder)
som trengs i andre deler av programmet.
 */

public class Node {

    private int minne;
    private int antPros;

    public Node(int minne, int antPros){  // Node constructor
        this.minne = minne;
        this.antPros = antPros;
    }

    public int antProsessorer(){
        return this.antPros;
    }

    public boolean nokMinne(int paakrevdMinne){
        if(paakrevdMinne <= minne){
            return true;
        }else{
            return false;
        }
    }

}
