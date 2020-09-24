/*
Kryptograftrådene sin oppgave er å motta meldinger fra monitoren for krypterte meldinger.
Kryptografen skal så dekryptere meldingen og så sende den ferdig dekrypterte meldingen
videre til monitoren for dekrypterte meldinger.
Merk at kryptografene ikke trenger å ta hensyn til sekvensnummer eller kanal-ID når de henter ut meldingene.
 */

public class Kryptograf implements Runnable {
    private int antall;
    private Monitor monitor1;
    private Monitor monitor2;
    Thread t;

    public Kryptograf(Monitor monitor1, Monitor monitor2){
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        monitor2.getOnline();
    }

    //Dekryptering av meldinger

    public void dekrypMelding(){

        Melding temp = monitor1.getMelding();

        while (temp!=null  || monitor1.getOnlineAntall()>0){  //Her sjekkes i monitoren hvorvidt
                                                                // telegrafister fortsett sender melding
            while (temp==null){
                try {
                    Thread.currentThread().sleep(100);
                    temp= monitor1.getMelding();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            if(temp!=null) {
                String dekryptertMelding = Kryptografi.dekrypter(temp.melding());
                temp.setMelding(dekryptertMelding);
                monitor2.addMelding(temp);
                temp = monitor1.getMelding();
            }
        }
        monitor2.getOffline();
    }

    @Override
    public void run() {
        this.dekrypMelding();
    }

    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}
