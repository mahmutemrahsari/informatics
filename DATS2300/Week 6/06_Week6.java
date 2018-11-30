package no.oslomet.cs.algdat;

import org.codehaus.groovy.util.ArrayIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Week6 {

    public static void main(String[] args) {
        System.out.println("Hei Algdat uke 6");

        //Min arrayliste - en slags container / beholder
        MyArrayList min_liste = new MyArrayList(32);

        // Loop over listen og sett verdier
        for (int i=0; i<32; ++i) {
            min_liste.set(i, 17+i);
        }

        // Skriv ut verdiene i listen
        for (int i=0; i<32; ++i) {
            System.out.print(min_liste.get(i) + ", ");
        }
        System.out.println();



        //Lag en array basert på Java sin implementasjon ArrayList
        ArrayList<String> min_arrayliste = new ArrayList<String>(6);

        //Legg merke til at arraylisten har null elementer (har kun allokert data)
        System.out.println("Min størrelse er: " + min_arrayliste.size());

        //Legg til elementer
        for (int i=0; i<6; ++i) {
            min_arrayliste.add("Verdi 17-"+i);
        }

        //Skriv ut arrayet
        System.out.println("Mitt array er: " + min_arrayliste);

        //Vanlig iterering med forløkke
        System.out.println("Array med forløkke: ");
        for (int i=0; i<min_arrayliste.size(); ++i) {
            System.out.print(min_arrayliste.get(i) + ", ");
        }
        System.out.println();

        //Iterere med for each
        System.out.println("Array med for each: ");
        for (String elem : min_arrayliste) {
            System.out.print(elem + ", ");
        }
        System.out.println();

        //Iterer med eksplisitt iterator
        System.out.println("Array med forward iterator: ");
        for (Iterator<String> iter = min_arrayliste.iterator();
                iter.hasNext();) {
            String value = iter.next();
            System.out.print(value + ", ");
        }
        System.out.println();

        //Baklengs forløkke
        System.out.println("Array med list iterator forlengs: ");
        for (ListIterator<String> iter = min_arrayliste.listIterator();
             iter.hasNext();) {
            String value = iter.next();
            System.out.print(value + ", ");
        }
        System.out.println();

        System.out.println("Array med list iterator baklengs (ofte veldig ineffektivt): ");
        for (ListIterator<String> iter = min_arrayliste.listIterator(6);
             iter.hasPrevious();) {
            String value = iter.previous();
            System.out.print(value + ", ");
        }
        System.out.println();


        // Lag en lenket liste "manuelt" => legg merke til den klønete
        // very_last_node-variabelen for å få lagt til et nytt element
        class Node {
            Node next_node;
            String value;
            public Node(String value, Node next_node) {
                this.value = value;
                this.next_node = next_node;
            }
        }

        Node very_last_node = new Node("C", null);
        Node last_node = new Node("B", very_last_node);
        Node first_node = new Node("A", last_node);

        //Looper gjennom den lenkede listen
        System.out.println("Lenket liste laget manuelt:");
        for (Node current_node = first_node;
             current_node != null;
             current_node = current_node.next_node) {
            System.out.print("[" + current_node.value + "]");
        }
        System.out.println();

        //Lager en bedre lenket liste
        LinkedList my_linked_list = new LinkedList();
        my_linked_list.add("A");
        my_linked_list.add("B");
        my_linked_list.add("C");
        my_linked_list.add("D");
        System.out.println("Lenket liste: ");
        System.out.println(my_linked_list.toString());


        my_linked_list.insert("E", 1);
        System.out.println("Lenket liste etter å ha lagt inn E på plass 1");
        System.out.println(my_linked_list.toString());

        my_linked_list.insert("F", 0);
        System.out.println("Lenket liste etter å ha lagt inn F på plass 0");
        System.out.println(my_linked_list.toString());
        System.out.println("Hvorfor gikk dette feil? Hva må håndteres annerledes?");
        System.out.println("Hint: innlegging først og sist feiler og må håndteres spesielt");
    }


    static class LinkedList {
        Node head;

        public LinkedList() {
            head = null;
        }

        public void add(String value) {
            Node new_node = new Node(value, head);
            head = new_node;
        }

        public void insert(String value, int index) {
            Node current_node = head;
            for (int i=0; i<index - 1; ++i) {
                current_node = current_node.getNext();
            }
            Node new_node = new Node(value, current_node.getNext());
            current_node.next_node = new_node;
        }

        public String toString() {
            String retval = "";
            for (Node current_node = head;
                 current_node != null;
                 current_node = current_node.getNext()) {
                retval = retval + "[" + current_node.value + "]";
            }
            return retval;
        }

        static class Node {
            Node next_node;
            String value;

            public Node(String value, Node next_node) {
                this.value = value;
                this.next_node = next_node;
            }

            Node getNext() {
                return next_node;
            }
        }
    }




    static class MyArrayList {
        int [] data;

        MyArrayList(int size) {
            data = new int[size];
        }

        int get(int i) {
            if (i < 0 || i > data.length) {
                throw new IndexOutOfBoundsException("Feil index");
            }
            return data[i];
        }

        void set(int i, int value) {
            if (i < 0 || i > data.length) {
                throw new IndexOutOfBoundsException("Feil index");
            }
            data[i] = value;
        }
    }
}
