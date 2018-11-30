// s306378


import java.util.*;
public class ObligSBinTre<T> implements Beholder<T>
{
    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi; // nodens verdi
        private Node<T> venstre, høyre; // venstre og høyre barn
        private Node<T> forelder; // forelder
        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder)
        {
            this.verdi = verdi;
            venstre = v; høyre = h;
            this.forelder = forelder;
        }
        private Node(T verdi, Node<T> forelder) // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString(){ return "" + verdi;}
    } // class Node
    private Node<T> rot; // peker til rotnoden
    private int antall; // antall noder
    private int endringer; // antall endringer
    private final Comparator<? super T> comp; // komparator
    public ObligSBinTre(Comparator<? super T> c) // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    @Override
    public boolean leggInn(T verdi)
    {
        Objects.requireNonNull(verdi, "nullverdier ulovlig!");
        Node<T> p = rot, q = null;
        int cmp = 0;
        while (p != null)
        {
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }
        p = new Node<T>(verdi, q);
        if (q == null) rot = p;
        else if (cmp < 0) q.venstre = p;
        else q.høyre = p;
        antall++;
        endringer++;
        return true;
    }

    @Override
    public boolean inneholder(T verdi)
    {
        if (verdi == null) return false;
        Node<T> p = rot;
        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }
        return false;
    }

    @Override
    public boolean fjern(T verdi)
    {
        if (verdi == null) return false;
        Node<T> p = rot, q = null;
        while (p != null)
        {
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) { q = p; p = p.venstre; }
            else if (cmp > 0) { q = p; p = p.høyre; }
            else break;
        }
        if (p == null) return false;
        if (p.venstre == null || p.høyre == null)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;
            if (p == rot){
                rot = b;
                if (b != null){
                    b.forelder = q;
                }
            }
            else if (p == q.venstre){
                q.venstre = b;
                if (b != null){
                    b.forelder = q;
                }
            }
            else q.høyre = b;
            if (b != null){
                b.forelder = q;
            }
        }
        else
        {
            Node<T> s = p, r = p.høyre;
            while (r.venstre != null)
            {
                s = r;
                r = r.venstre;
            }

            p.verdi = r.verdi;

            if (s != p){
                s.venstre = r.høyre;
                if (r.høyre != null){
                    r.høyre.forelder = s;
                }
            }
        }
        antall--;
        return true;
    }

    public int fjernAlle(T verdi)
    {
        if (antall == 0){
            return 0;
        }
        int ant = antall(verdi);
        for (int i=0; i<ant; i++){
            fjern(verdi);
        }

        return ant;
    }

    @Override
    public int antall()
    {
        return antall;
    }

    public int antall(T verdi)
    {
        if (verdi == null){
            return 0;
        }

        int anta = 0;
        Node<T> p = rot;

        while (p != null){
            int com = comp.compare(verdi, p.verdi); //sammenligner

            if (com == 0){
                anta++;
            } if (com<0){
                p = p.venstre;
            }

            else{
                p = p.høyre;
            }
        }
        return anta;
    }

    @Override
    public boolean tom()
    {
        return antall == 0;
    }

    @Override
    public void nullstill()
    {
        rot = rot.venstre = rot.høyre = null;
        antall = 0;
    }

    private static <T> Node<T> nesteInorden(Node<T> p)
    {
        if (p.høyre != null ){ p = p.høyre;
            while (p.venstre != null){ p = p.venstre;}
            return p;
        }else {
            while (p.forelder != null && p.forelder.høyre == p){
                p = p.forelder;
            }
            return p.forelder;
        }
    }

    @Override
    public String toString()
    {
        if (antall==0){
            return "[]";
        }

        Node<T> p = rot;
        while (p.venstre != null){
            p = p.venstre;
        }

        StringJoiner s = new StringJoiner(", ", "[", "]");

        while (p != null){
            s.add(p.verdi.toString());
            p = nesteInorden(p);
        }
        return s.toString();

    }

    public String omvendtString()
    {
        if (antall ==0){
            return "[]";//  returnerer til tommer treet
        }

        StringJoiner s = new StringJoiner(", ","[","]");

        Stack<Node<T>> stakk = new Stack<>();
        Node<T> p = rot;   //Går til venstre fra roten
        while (p.høyre != null){
            stakk.push(p);
            p = p.høyre;
        }

        s.add(p.verdi.toString());

        while (true)
        {
            if (p.venstre != null)

            {
                p = p.venstre;

                while (p.høyre != null)
                {
                    stakk.push(p);     //pusher stakken
                    p = p.høyre;
                }
            }
            else if (!stakk.empty())
            {
                p = stakk.pop();
            }
            else break;

            s.add(p.verdi.toString());


        }
        return s.toString();
    }

    public String høyreGren()
    {
        if (antall ==0){
            return "[]";// tomt tre
        }

        String str = "[";
        Node<T> p = rot;

        str += p.verdi.toString();

        while (true) {
            if (p.høyre != null)
            {
                p = p.høyre;
                str += "," + p.verdi.toString();
            } else if (p.venstre != null) {
                p = p.venstre;
                str += "," + p.verdi.toString();
            } else {
                break;
            }
        }
        str += "]";
        return str;
    }

    public String lengstGren()
    {
        if (antall ==0){
            return "[]";// tomt tre
        }

        String str = "[";
        Node<T> p = rot;

        str += p.verdi.toString();

        while (true) {
            if (p.høyre != null)
            {
                p = p.høyre;
                str += "," + p.verdi.toString();
            } else if (p.venstre != null) {
                p = p.venstre;
                str += "," + p.verdi.toString();
            } else {
                break;
            }
        }
        str += "]";
        return str;
    }

    public String[] grener()
    {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public String bladnodeverdier()
    {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public String postString()
    {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    @Override
    public Iterator<T> iterator()
    {
        return new BladnodeIterator();
    }

    private class BladnodeIterator implements Iterator<T>
    {
        private Node<T> p = rot, q = null, neste = null, temp = null;
        private boolean removeOK = false;
        private int iteratorendringer = endringer;
        private Stack<Node<T>> stakk = new Stack<>();

        private BladnodeIterator()
        {
            if (antall==0){ return; }
            if (p != null){
                stakk.push(p);
                while (neste == null){
                    temp = stakk.pop();
                    if (temp.venstre == null && temp.høyre == null){
                        neste = temp;
                    }else {
                        if (temp.høyre != null){
                            stakk.push(temp.høyre);
                        }
                        if (temp.venstre != null){
                            stakk.push(temp.venstre);
                        }
                    }
                }
            }
            p = neste;
        }

        @Override
        public boolean hasNext()
        {
            return p != null; // Denne skal ikke endres!
        }
        
        @Override
        public T next()
        {
            if (!hasNext()){
                throw new NoSuchElementException("Ingen bladnoder");
            }
            else {
                removeOK = true;
                q=p;
                neste = null;

                while (!stakk.isEmpty() && neste == null){
                    temp = stakk.pop();
                    if (temp.venstre == null && temp.høyre == null){
                        neste = temp;
                    }else {
                        if (temp.høyre != null){
                            stakk.push(temp.høyre);
                        }
                        if (temp.venstre != null){
                            stakk.push(temp.venstre);
                        }
                    }
                }
            }
            p = neste;
            return q.verdi;
        }

        @Override
        public void remove()
        {
            if (antall ==0){
                throw new IllegalStateException("Treet er tom.");
            }else if (!removeOK){
                throw new IllegalStateException("Ulovlig operasjon");
            }

            removeOK = false;
            antall--;

            if (q != null){
                if (q.forelder != null){
                    if (q.forelder.høyre == q){
                        q.forelder.høyre = null;
                    }else {
                        q.forelder.venstre = null;
                    }
                }
                q=null;
            }
        }
    }
}