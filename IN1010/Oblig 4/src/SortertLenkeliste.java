
public class SortertLenkeliste<T extends Comparable<T> > extends Lenkeliste<T>{

   @Override
   public void leggTil(T x){
       if(stoerrelsen==0){
           start = new Node(x);
       } else if (stoerrelsen ==1){
           int aaa = start.data.compareTo(x);
           if(start.data.compareTo(x)>0){
            super.leggTil(0,x);
            return;
           } else {
               super.leggTil(x);
               return;
           }



       } else{
         Node temp = start;

         while (x.compareTo(temp.data)>0) {
             if (temp.neste != null)
                 temp = temp.neste;
         else {
             super.leggTil(x);
             return;
             }
         }
            Node temp2 = new Node(x);
            if(temp.forrige ==null) {
                   super.leggTil(0,x);
                   return;
            }
            temp.forrige.neste = temp2;
            temp2.neste=temp;
            temp2.forrige = temp.forrige;
            temp.forrige=temp2;
       }
       stoerrelsen++;
    }

    @Override
    public void leggTil(int pos, T x) {
       if(pos>stoerrelsen || pos <0)
           throw new UnsupportedOperationException();
       T next = hent(pos);
       if(pos==0 && x.compareTo(next)>0){
         throw new UnsupportedOperationException();
           
       }else{
         T previous= hent(pos-1);

         if(x.compareTo(previous)<0 || x.compareTo(next)>0)
             throw new UnsupportedOperationException();
          super.leggTil(pos, x);
       }
    }

    @Override
    public void sett(int pos, T x) {
       if((stoerrelsen==0 && pos>-1)|| (pos>stoerrelsen-1 || pos <0))
           throw new UnsupportedOperationException();
            Node p = start;
            for (int i = 0; i < pos; i++) {
                p = p.neste;
            }
            if(stoerrelsen==1){
                p.data =x;
                return;
            }
            if(p.forrige==null&&x.compareTo(p.neste.data)>0)
                throw new UnsupportedOperationException();

            if(p.neste==null&& x.compareTo(p.forrige.data)<0)
                throw new UnsupportedOperationException();

            if(x.compareTo(p.neste.data)>0||x.compareTo(p.forrige.data)<0)
                throw new UnsupportedOperationException();
            else
                p.data = x;


     }

    @Override
    public T fjern(){
       return super.fjern(stoerrelsen-1);
    }
}