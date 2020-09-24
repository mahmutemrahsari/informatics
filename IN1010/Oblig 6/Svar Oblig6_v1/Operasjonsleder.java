/*
Operasjonslederen henter dekrypterte meldinger fra den andre monitoren.
Han samler alle meldingene og sorterer dem basert på kanal og sekvensnummer.
Når han vet at det ikke kan komme nye meldinger på denne monitoren
(kryptografene sier fra på samme måte som telegrafistene ovenfor),
så skriver han ut meldingene for hver kanal i sortert rekkefølge.

new​ ​PrintWriter​(​utfil​,​ ​"utf-8"​);

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class Operasjonsleder implements Runnable {
    private Monitor monitor;
    private HashMap<Integer, ArrayList<Melding>>  meldingList = new HashMap<Integer, ArrayList<Melding>>();
    Thread t;

    public Operasjonsleder(Monitor monitor){
        this.monitor = monitor;
    }

    public void leseMeldinger(){ //Leser meldinger fra monitoren

        Melding temp = monitor.getMelding();
         while(temp!=null || monitor.getOnlineAntall()>0){
                while (temp==null){
                    try {
                        Thread.currentThread().sleep(100);
                        temp= monitor.getMelding();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            if(!meldingList.containsKey(temp.returnID())){
                ArrayList<Melding> tempMeldingList = new ArrayList<>();
                tempMeldingList.add(temp);
                meldingList.put(temp.returnID(), tempMeldingList);
            }else {
                meldingList.get(temp.returnID()).add(temp);
            }
            temp = monitor.getMelding(); // Sjekker monitoren
        }
        try {
            skrivTilFil();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void skrivTilFil() throws UnsupportedEncodingException {

        try {
            ArrayList<Integer> KanalIdList = new ArrayList(meldingList.keySet());
            Collections.sort(KanalIdList);

            for(Integer id: KanalIdList) {
                File f = new File("src/Kanal_" + id.toString()+".txt");
                PrintWriter pw = new PrintWriter(f, "utf-8");
                ArrayList<Melding> tempList = meldingList.get(id);
                Collections.sort(tempList);

                for (Melding tempLs : tempList) {
                    pw.append(tempLs.toString() + "\n");
                }
                pw.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        leseMeldinger();
    }

    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}
