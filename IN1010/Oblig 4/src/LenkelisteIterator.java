public class LenkelisteIterator<T> implements Iterator<T> {
    private Liste<T> minListe;
    private int indeks=0;

    public LenkelisteIterator(Liste<T> lx){
        minListe = lx;
    }

    @Override
    public boolean hasNext(){
        return indeks < minListe.stoerrelse(); //.size();
    }

    @Override
    public T next(){
        return minListe.hent(indeks++);
    }

}