/*
Hver telegrafist lytter til sin kanal som det kommer krypterte meldinger på.
Når han mottar en melding, gir han den til monitoren.
Han gjør dette til det ikke kommer flere meldinger (f.eks. når han mottar en melding som signaliserer SLUTT).
Meldingene i monitoren er krypterte og må dekrypteres av kryptografene.
 *

/*
Hver telegrafist(-tråd) har sin egen kanal. Telegrafistens oppgave er å lytte etter beskjeder
(husk at ​.lytt()​ returnerer en ​String​) på kanalen sin.
Når en telegrafist får en beskjed skal den opprette en ​Melding​
og så sende meldingen videre til monitoren for krypterte meldinger,
for deretter å gå tilbake til å lytte etter nye meldinger.
Når det ikke er flere meldinger å hente, returnerer ​.lytt()​-metoden “​null​”.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Telegrafist implements Runnable {
    private Thread t;
    private Monitor monitor1;
    private Monitor monitor2;
    private Kanal kanal;
    private int sekvensnummer = 1;
    private int kanalId;
    private int teller;
    Lock laas = new ReentrantLock();


    public Telegrafist(Monitor monitor1,Monitor monitor2, Kanal kanal){
        this.monitor1 = monitor1;
        monitor1.getOnline();
        this.monitor2 = monitor2;
        this.kanal = kanal;
        this.kanalId = kanal.hentId();


    }

    public void lyttKanal(){
        String message =kanal.lytt(); // Telegrafistene kan lytte på sin kanal ved å kalle på ​kanal.lytt()​.
        while (message!=null) {
            Melding nyMelding = new Melding(sekvensnummer, kanalId, message);

            laas.lock();
            monitor1.addMelding(nyMelding);
            laas.unlock();

            sekvensnummer++;
            message = kanal.lytt(); // Sjekker kanalen har  fortsett melding
        }
        monitor1.getOffline(); //Teller hvor mange telegrafister tilgjengelige  i systemet akkurat nå
    }

    public int hentSekvensnummer(){
        sekvensnummer = teller++;
        return teller;
    }


    @Override
    public void run() {
        this.lyttKanal();
    }

    public void start () {
        if (t == null) {
            t = new Thread (this,Integer.toString(kanalId));
            t.start ();
        }
    }
}
