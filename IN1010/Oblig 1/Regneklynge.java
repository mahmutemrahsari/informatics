/*
Klassen Regneklynge skal holde rede på en liste med racks,
og må tilby en metode som tar imot et nodeobjekt
og plasserer det i et rack med ledig plass.

Hvis alle rackene er fulle, skal det lages et nytt Rack-objekt
som legges inn i listen, og noden plasseres i det nye racket.
Tips:​ Det kan være lurt å ta inn antall noder per rack
i konstruktøren til Regneklynge.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Regneklynge {

    private int noderPerRack;
    private ArrayList<Rack> regneklynge = new ArrayList<>();

    public Regneklynge(int noderPerRack){ //Regneklynge Constructor
        this.noderPerRack = noderPerRack;
    }

    public Regneklynge(String filnavn){ //Andre konstruktoer for aa lese fra fil
        Scanner fil = null;
        try {
            fil = new Scanner(new File(filnavn));
        }

        catch (Exception e) {
            System.out.println("Filen "+filnavn+" finnes ikke!");
            System.exit(1);
        }

        this.noderPerRack = fil.nextInt();

        while(fil.hasNext()){
            String linje = fil.nextLine().trim();

            if(linje.split(" ").length!=3) continue; // Sjekker linjer hvis stoerrelsen av kolonnen er mer eller liten enn 3
            //leser info fra filen
            for(int teller = 0; teller < (Integer.parseInt(linje.split(" ")[0])); teller ++){
                this.settInn(new Node(Integer.parseInt(linje.split(" ")[1]), Integer.parseInt(linje.split(" ")[2])));
            }
        }
        fil.close();
    }

    public void settInn(Node node){//Setter inn Racks  i regneklyngen

        boolean sattInn = false;
        for(Rack i:this.regneklynge){
            if(i.getAnttallNoder() < this.noderPerRack) {
                i.settInn(node);
                sattInn = true;
            }
        }

        if(!sattInn){
            Rack newRack = new Rack();
            newRack.settInn(node);
            this.regneklynge.add(newRack);
        }
    }

    //Returnerer det totale antall prosessorer i regneklyngen
    public int antProsessorer(){
        int teller = 0;
        for(Rack i : this.regneklynge){
            teller = teller + i.antProsessorer();
        }
        return teller;
    }

    //Returnerer antall noder med minst ​paakrevdMinne ​GB minne.
    public int noderMedNokMinne(int paakrevdMinne){
        int teller = 0;
        for(Rack i : this.regneklynge){
            teller = teller + i.noderMedNokMinne(paakrevdMinne);
        }
        return teller;
    }

    public int antRacks(){
        return this.regneklynge.size();
    }

}
