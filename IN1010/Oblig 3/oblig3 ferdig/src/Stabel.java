public class Stabel<T> extends Lenkeliste<T>{

    public void leggPaa(T x){
     leggTil(x);
    }

    public T taAv(){
        if(stoerrelsen==0) {
            throw new UgyldigListeIndeks(super.stoerrelsen);
        }else{
            return fjern(stoerrelsen-1);
        }
    }

}
