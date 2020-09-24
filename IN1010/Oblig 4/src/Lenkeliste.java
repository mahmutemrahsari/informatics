import java.util.LinkedList;

public class Lenkeliste<T> implements Liste<T> {

    // Utvid klassen Lenkeliste<T> med metoden ​Iterator iterator​,
    // som returnerer et nytt LenkelisteIterator-objekt.
    public LenkelisteIterator<T> iterator() {
        return new LenkelisteIterator<T>(this);
    }

    protected class Node {

        Node neste = null;
        Node forrige = null;
        T data;

        Node(T x) {
            data = x;
        }
    }

    protected Node start = null;
    protected Node slutt = null;
    protected int stoerrelsen=0;

    // finner stoerrelsen
    @Override
    public int stoerrelse() {
        return this.stoerrelsen;
    }

    //Metoden ​leggTil(int pos, T x)​ skal legge inn et nytt element
    // i listen og skyve neste element ett hakk lenger bak.
    @Override
    public void leggTil(int pos, T x) {
        if(pos<0|| pos >stoerrelsen) {
            throw new UgyldigListeIndeks(pos);
        }else{
            if (pos == stoerrelsen) {
                leggTil(x);
            } else if (pos == 0) {
                Node temp = new Node(x);
                temp.neste=start;
                start.forrige=temp;
                start = temp;
                stoerrelsen++;
            }else{
                Node p = start;
                for (int i = 1; i < pos; i++){
                    p = p.neste;
                }
                Node temp = new Node(x);
                temp.neste = p.neste;
                temp.forrige = p;
                p.neste.forrige=temp;
                p.neste = temp;
                stoerrelsen++;
            }
        }
    }

   // setter element paa slutten av listen
    @Override
    public void leggTil(T x) {
        if(this.stoerrelsen==0){
            start = slutt = new Node(x);
            stoerrelsen++;
        }else{
        Node p = start;
        while (p.neste != null)
            p = p.neste;
        Node temp = new Node(x);
        p.neste = temp;
        temp.forrige = p;
        slutt=temp;
        stoerrelsen++;
        }
    }

    //Metoden ​sett(int pos, T x)​ skal sette inn elementet på en gitt posisjon
    // og overskrive det som var der fra før av.
    @Override
    public void sett(int pos, T x) {
        if(stoerrelsen==0 && pos>0 && pos<stoerrelsen+1)
            throw new UnsupportedOperationException();
        if(pos<0 || pos >=stoerrelsen) {
            throw new UgyldigListeIndeks(pos);
        }else{
            Node p = start;
            for (int i = 0; i < pos; i++) {
                p = p.neste;
            }
            p.data = x;
        }
    }

    //Hentes data fra gitt pos
    @Override
    public T hent(int pos) {
        if(pos<0 || pos >=stoerrelsen){
            throw new UgyldigListeIndeks(pos);
        }else {
            Node p = new Node(null);
            p= start;
            for (int i = 0; i < pos; i++) {
                p = p.neste;
            }
            return p.data;
        }
    }

    //Metoden ​fjern(int pos)​ skal fjerne på gitt indeks i listen.
    @Override
    public T fjern(int pos) {
        if(pos<0 || pos >=stoerrelsen) {
            throw new UgyldigListeIndeks(pos);
        }
        T temp = start.data;
        Node p = start;
        if(pos==0){
            start = start.neste;
            if(start != null)
            start.forrige=null;
            this.stoerrelsen--;
            return temp;
        }else{
        if(pos==this.stoerrelsen-1){
            Node n = slutt;
            slutt=n.forrige;
            slutt.neste=null;
            this.stoerrelsen--;
            return n.data;
        } else{
            for (int i = 1; i < pos; i++)
            p = p.neste;
            Node n = p.neste;
            p.neste = n.neste;
            n.neste.forrige = p;
            this.stoerrelsen--;
            return n.data;
            }
        }
    }

    //fjern​ ​()​ skal fjerne og returnere elementet på starten av listen.
    public T fjern() {
        if(this.stoerrelsen==0){
            throw new UgyldigListeIndeks(this.stoerrelsen);
        }
        T temp = start.data;
        Node p = start;
        start = start.neste;
        if(start != null)
            start.forrige=null;
        this.stoerrelsen--;
        return temp;
    }
}
