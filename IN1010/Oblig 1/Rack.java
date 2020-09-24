/*
Klassen Rack skal lagre Node-objektene
som hører til et rack i en liste.
Vi skal kunne legge til noder i racket
hvis det er færre enn maks antall noder der fra før.
For enkelhets skyld skal vi anta at
hvert rack i regneklyngen har plass til like mange noder.
Opprett andre instansvariable og metoder etter behov.
 */

import java.util.ArrayList;

public class Rack {
    private ArrayList<Node> rack = new ArrayList<>() ;


    public void settInn(Node node){ //Setter inn Noder i Rackene
        rack.add(node);

    }


    public int getAnttallNoder(){
        return this.rack.size();
    }

    public int antProsessorer(){
        int teller = 0;
        for(Node i : this.rack) {
            teller = teller + i.antProsessorer();
        }
        return teller;
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int teller=0;
        for(int i=0; i<rack.size(); i++){
            Node x = rack.get(i);

            if(x.nokMinne(paakrevdMinne)){
                teller++;
            }
        }
        return teller;
    }

}
