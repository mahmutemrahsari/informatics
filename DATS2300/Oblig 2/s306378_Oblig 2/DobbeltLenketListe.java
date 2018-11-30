//Mahmut Emrah Sari
//s306378

/////////// DobbeltLenketListe ////////////////////////////////////
import java.util.*;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> //Generic class

{
    private static final class Node<T>   // en indre nodeklasse
    {
        // instansvariabler
        private T verdi;
        private Node<T> forrige, neste;

        private Node(T verdi, Node<T> forrige, Node<T> neste)  // konstruktoer
        {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        protected Node(T verdi)  // konstruktoer
        {
            this(verdi, null, null);
        }

    } // Node

    // instansvariabler
    private Node<T> hode;          // peker til den foerste i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;   // antall endringer i listen

    // hjelpemetode
    private Node<T> finnNode(int indeks) {
        if (indeks < 0 || indeks > antall - 1) {
            return null;
        }

        if (indeks < antall / 2) {
            Node<T> tmp = hode;
            for (int i = 0; i < indeks; i++) {
                tmp = tmp.neste;
            }
            return tmp;
        } else {
            Node<T> tmp = hale;
            for (int i = 0; i < (antall-1-indeks); i++) {
                tmp = tmp.forrige;
            }
            return tmp;
        }
    }


    // konstruktoer
    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    // konstruktoer
    public DobbeltLenketListe(T[] a) {
        antall = 0;
        endringer = 0;
        Node<T> hode = new Node<>(null);
        Node<T> hale = new Node<>(null);
        if (a == null) {
            throw new NullPointerException("The table a is null!");
        } else {


            for (int i = 0; i < a.length; i++) {


                if (a[i] != null && antall == 0) {
                    hode.verdi = a[i];
                    hode.forrige = null;
                    hode.neste = null;
                    hale = hode;
                    antall++;

                } else if (a[i] != null) {
                    Node<T> tmp = new Node<>(a[i]);
                    tmp.forrige=hale;
                    hale.neste=tmp;
                    hale = tmp;
                    antall++;
                }

            }
        }
        if (antall == 0) {
            hode = hale = null;
        }
        this.hode=hode;
        this.hale=hale;

    }

    //fraTil kontroll
    private void fratilKontroll(int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > this.antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                   ("til(" + til + ") > antall(" + this.antall + ")");

        if (fra > til)                                // fra er stoerre enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }


    // subliste
    public Liste<T> subliste(int fra, int til) {

        fratilKontroll(fra, til);

        DobbeltLenketListe<T> temp =new DobbeltLenketListe<>();
        for(int i= fra; i<til; i++){
        temp.leggInn(finnNode(i).verdi);
        }
        return temp;

    }

    @Override
    public int antall() {
        return this.antall;

    }

    @Override
    public boolean tom() {
        if (antall == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        if (verdi == null) {
            throw new NullPointerException("Verdi kan ikke ble null.");
        }

        if (hode == null) {
            hode = new Node<T>(verdi);
            hale = hode;
            antall++;
            endringer++;
            return true;
        } else {
            Node<T> tmp = hode;
            while (tmp.neste != null) tmp = tmp.neste;
            tmp.neste = new Node<T>(verdi);
            tmp.neste.forrige=tmp;
            hale = tmp.neste;
            antall++;
            endringer++;

        }

        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        if (indeks<0){
            throw new IndexOutOfBoundsException("Feil indeks");
        }
        if (verdi == null) {
            throw new NullPointerException("Verdien kan ikke bli null!");
        }
        if (indeks > antall) {
            throw new IndexOutOfBoundsException("Indeks kan ikke bli stoerre enn Listelengden!");
        } else if (indeks == antall) {
            leggInn(verdi);
        } else if (indeks == 0) {
            hode.forrige = hode = new Node<T>(verdi, null, hode);
            antall++;
            endringer++;
        }else {


            Node<T> tmp = hode;
            for (int i = 0; i < indeks; i++) {
                tmp = tmp.neste;
            }
            tmp.forrige = tmp.forrige.neste = new Node<T>(verdi, tmp.forrige, tmp);
            antall++;
            endringer++;
        }

    }

    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) > -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        Node<T> tmp = hode;
        for (int i = 0; i < antall; i++) {
            if (tmp.verdi.equals(verdi)) {
                return i;
            } else {
                tmp = tmp.neste;
            }

        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) { // Oppdater paa plass indeks

        Objects.requireNonNull(nyverdi, "Ikke tillatt med null-verdier!");
        indeksKontroll(indeks, false); // Se Liste, false: indeks = antall er ulovlig

        Node<T> tmp = finnNode(indeks);
        T gammelVerdi = tmp.verdi;
        tmp.verdi = nyverdi;
        endringer++;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if(verdi==null) return false;

        if (antall == 0) {
            throw new UnsupportedOperationException("Empty list");
        }


        Node<T> tmp = hode;                     //midlertidig node
        for (int i = 0; i < antall; i++) {

            if (tmp.verdi.equals(verdi)) {
                if(antall==1){hode = hale = null;}
                else if (i == 0) {
                    hode = hode.neste;
                    hode.forrige = null;
                } else if (i == antall - 1) {
                    hale = hale.forrige;
                    hale.neste = null;
                } else {
                    tmp.forrige.neste = tmp.neste;
                    tmp.neste.forrige = tmp.forrige;
                }
                antall--;
                endringer++;
                return true;

            } else {
                tmp = tmp.neste;
            }

        }
        return false;


    }

    @Override
    public T fjern(int indeks) {

        if (indeks>antall-1) {
            throw new IndexOutOfBoundsException();
        }

        indeksKontroll(indeks, false); // Se Liste, false: indeks = antall er ulovlig
        Node<T> tmp= new Node<T>(null);

        if(antall ==1){
            hode=hale=null;
            antall=0;
            endringer++;
        }
        else if (indeks == 0) {
            tmp = hode;
            hode = hode.neste;
            hode.forrige = null;
            antall--;
            endringer++;
            return tmp.verdi;
        } else if (indeks == antall - 1) {
            tmp = hale;
            hale = hale.forrige;
            hale.neste = null;
            antall--;
            endringer++;
            return tmp.verdi;

        } else {
            Node<T> tmp2 = hode;
            for (int i = 0; i < indeks; i++) {
                tmp2 = tmp2.neste;
            }
            tmp = tmp2;

            tmp2.forrige.neste = tmp2.neste;
            tmp2.neste.forrige = tmp2.forrige;
            antall--;
            endringer++;
        }
        return tmp.verdi;
    }

    @Override
    public void nullstill() {
        Node<T> p = hode, q;

        while (p != null)
        {
            q = p.neste;
            p.neste = null;
            p.forrige = null;
            p.verdi = null;
            p = q;
        }

        hode = hale = null;

        endringer++;    // nullstilling er en endring
        antall = 0;           // antall lik 0 i en tom liste
    }


    @Override
    public String toString()
    {

        StringJoiner forwardString = new StringJoiner(", ","[","]");
        Node<T> tmp = hode;
        while(tmp != null){
                forwardString.add(tmp.verdi.toString()); //framover
            tmp = tmp.neste;
        }

        return forwardString.toString();

    }

    public String omvendtString()
    {

        StringJoiner reverseString = new StringJoiner(", ","[","]");
        Node<T> tmp = hale;
        while(tmp != null){

            reverseString.add(tmp.verdi.toString()); //omvendt

            tmp = tmp.forrige;
        }

        return reverseString.toString();
    }

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {

        //Her brukte jeg hent() og oppdater() som hjelpemetodene

        for (int i=1;i<liste.antall();i++) // starter med i = 1
            {
            T verdi = liste.hent(i); // verdi er et tabellelemne
                int j=i-1;

        for (; j >= 0 && c.compare(verdi,liste.hent(j)) < 0 ; j--)
            liste.oppdater(j+1,liste.hent(j));
                liste.oppdater(j+1, verdi); // j + 1 er rett sortert plass
            }


    }


    @Override
    public Iterator<T> iterator()
    {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks)
    {
        indeksKontroll(indeks, false); // Se Liste, false: indeks = antall er ulovlig
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator()
        {
            denne = hode;     // denne starter paa den foerste i listen
            fjernOK = false;  // blir sann naar next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks)
        {
            //Node<T> tmp = finnNode(indeks);
            denne = finnNode(indeks);     // denne starter paa den foerste i listen
            fjernOK = false;  // blir sann naar next() kalles
            iteratorendringer = endringer;  // teller endringer

        }

        @Override
        public boolean hasNext()
        {
            return denne != null;  // denne koden skal ikke endres!
        }

        @Override
        public T next()
        {
            if (endringer != iteratorendringer)
                throw new ConcurrentModificationException("Listen er endret!");

            if (!hasNext()) throw new
                    NoSuchElementException("Tomt eller ingen verdier igjen!");

            fjernOK = true;            // naa kan remove() kalles

            T denneVerdi = denne.verdi;    // tar vare paa verdien i p
            denne = denne.neste;               // flytter p til den neste noden

            return denneVerdi;         // returnerer verdien
        }

        @Override
        public void remove() {
            if (endringer != iteratorendringer)
                throw new ConcurrentModificationException("Listen er endret!");


            if (!fjernOK) throw new IllegalStateException("Ulovlig tilstand!");

            fjernOK = false;               // remove() kan ikke kalles paa nytt
            Node<T> q = hode;              // hjelpepeker

            if (hode.neste == denne)           // skal den foerste fjernes?
            {
                hode.forrige=null;
                hode.verdi=null;
                hode = hode.neste;           // den foerste fjernes
                if(hode != null) hode.forrige=null;

                if (denne  == null) hale = null;  // dette var den eneste noden

            } else


                {
                Node<T> r = hode;            // maa finne forgjengeren
                // til forgjengeren til p
                while (r.neste.neste != denne) {
                    r = r.neste;               // flytter r
                }
                if (denne == null) {
                        hale = r;     // q var den siste
                        hale.neste =null;}
                        else {

                    q = r.neste;                 // det er q som skal fjernes
                    r.neste = denne;                 // "hopper" over q
                    q.neste.forrige=r;
                    q.verdi = null;                // nuller verdien i noden
                    q.neste = null;                // nuller nestepeker
                    q.forrige=null;
                }

            }


            endringer++;             // en endring i listen
            iteratorendringer++;    // en endring av denne iteratoren
            antall--;                      // en node mindre i listen

        }

    } // DobbeltLenketListeIterator

} // DobbeltLenketListe


