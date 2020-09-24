/*
I tillegg til String-objektet som utgjør innholdet i meldingen,
må hver melding ha et sekvensnummer og ID-en til kanalen meldingen kom fra.
Denne informasjonen er nødvendig for å kunne skille meldingene etter kanal
og sortere dem i riktig rekkefølge slik at meldingene fra hver kanal kan skrives ut sammen.
 */


public class Melding implements Comparable<Melding> {
    private int sekvensnummer;
    private int id; //ID-en til kanalen meldingen kom fra
    private String melding;
    //Constructer
    public Melding(int sekvensnummer, int id, String melding){
        this.sekvensnummer=sekvensnummer;
        this.id=id;
        this.melding = melding;
    }

    public String melding(){ //GetMeldig
        return this.melding;
    }

    //Update
    public void setMelding(String melding) {
        this.melding = melding;
    }

    //Get id
    public int returnID(){
        return this.id;
    }

    public int returnSekvensnummer(){
        return this.sekvensnummer;
    }
    public int compareTo(Melding melding){
        return Integer.valueOf(this.sekvensnummer).compareTo(melding.sekvensnummer);

    }

    public String toString(){
        return this.melding;
    }
}
