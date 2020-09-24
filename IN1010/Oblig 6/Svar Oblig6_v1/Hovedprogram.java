

public class Hovedprogram {
    public static void main(String[] args) {

        int antallTelegrafister =3;
        int antallKryptografer=20;

        Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
        Kanal[] kanaler = ops.hentKanalArray();

        Monitor monitorForKrypterteMeldinger = new Monitor();
        Monitor monitorForDekrypterteMeldinger = new Monitor();
        Operasjonsleder nyOperasjonsleder = new Operasjonsleder(monitorForDekrypterteMeldinger);

        for(Kanal kanal : kanaler){
            Telegrafist newTelegrafist = new Telegrafist(monitorForKrypterteMeldinger,monitorForDekrypterteMeldinger,  kanal);
            newTelegrafist.start();
        }

        for(int i =0; i<antallKryptografer; i++){
            Kryptograf nyKryptografer = new Kryptograf(monitorForKrypterteMeldinger,monitorForDekrypterteMeldinger);
            nyKryptografer.start();
        }


        nyOperasjonsleder.leseMeldinger();
        nyOperasjonsleder.start();

    }






}
