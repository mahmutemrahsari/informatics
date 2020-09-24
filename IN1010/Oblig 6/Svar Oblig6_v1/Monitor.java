/*
Vi skal ha to monitorer i dette systemet, én monitor som mottar krypterte meldinger
og sender meldingene videre til kryptografer, og én monitor som tar i mot dekrypterte meldinger
og sender meldingene videre til operasjonsleder når alle meldinger er ferdig dekryptert.

For å holde på meldingene i monitoren bør du bruke en passende beholder, for eksempel ArrayList eller LinkedList.
Alternativt kan du benytte en beholder fra oblig 3 (vi vil oppfordre til å benytte ArrayList eller LinkedList,
da det kan være nyttig å bli bedre kjent med Java-biblioteket).

Pass på at ingen meldinger blir liggende for lenge i monitoren før de blir hentet av en kryptograf.
Husk å synkronisere trådene dine, med andre ord: når en tråd har fått tilgang til en monitor,
må alle andre trådene vente til den første tråden er ferdig.
 */

import java.util.*;

public class Monitor {
    private Queue<Melding> meldingList = new LinkedList<>();
    private int onlineTelegrafist=0;


    public void addMelding(Melding melding){
        synchronized (this){
            meldingList.add(melding);
        }
    }

    public void getOnline(){
        synchronized (this){
            onlineTelegrafist++;
        }
    }

    public void getOffline(){
        synchronized (this){
            onlineTelegrafist--;
        }
    }

    public Melding getMelding() {
        synchronized (this){
        if (meldingList.size()!=0){
           Melding temp = meldingList.peek();
           meldingList.remove();
          return temp;
        }
        return null;
        }
    }

    public int getOnlineAntall(){
        synchronized (this){
            return this.onlineTelegrafist;
        }
    }

}
