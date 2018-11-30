package no.oslomet.cs.algdat;

import com.sun.xml.internal.bind.v2.WellKnownNamespace;

import static org.junit.jupiter.api.Assertions.*;

class Week1Test {
    @org.junit.jupiter.api.Test
    void randomArray1() {
        // Vi har ikke testet randomArray1:
        // assert false for å teste at metoden kjøres
        assertTrue(false);
    }


    @org.junit.jupiter.api.Test
    void randomArray2() {
        //Test at det fungerer med lengde en:
        int my_array1[] = Week1.randomArray2(1);
        assertEquals(my_array1[0], 1);

        //Test at det fungerer med lengde tre:
        int my_array3[] = Week1.randomArray2(3);
        assertEquals(my_array3.length, 3);

        //Sjekk at vi har tallene en, to og tre
        boolean has_one = (my_array3[0] == 1) || (my_array3[1] == 1) || (my_array3[2] == 1);
        assertTrue(has_one);
        boolean has_two = (my_array3[0] == 2) || (my_array3[1] == 2) || (my_array3[2] == 2);
        assertTrue(has_two);
        boolean has_three = (my_array3[0] == 3) || (my_array3[1] == 3) || (my_array3[2] == 3);
        assertTrue(has_three);

        //Sjekk at vi ikke har fire
        boolean has_four = (my_array3[0] == 4) || (my_array3[1] == 4) || (my_array3[2] == 4);
        assertFalse(has_three);



        //Sjekk et array med lengde ti
        int num_values = 10;
        int my_array[] = Week1.randomArray2(num_values);

        //Sjekk at arrayet får riktig lengde
        assertEquals(my_array.length, num_values);

        //Loop over og finn minimum og maksimum
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for (int i=0; i<num_values; ++i) {
            if (minimum > my_array[i]) {
                minimum = my_array[i];
            }
            if (maximum < my_array[i]) {
                maximum = my_array[i];
            }
        }

        // Sjekk at største og minste verdi stemmer
        assertEquals(minimum, 1);
        assertEquals(maximum, num_values);

        // Sjekk at metoden fungerer med lengde 0
        int values2[] = Week1.randomArray2(0);
        assertEquals(values2.length, 0);

        //Dette feiler (forklar hvorfor!):
        //int values3[] = Week1.randomArray2(-1);
        //assertEquals(values3.length, -1);

        //For å teste forventede feil, bruk assertThrows
        assertThrows(java.lang.NegativeArraySizeException.class,
                () -> {Week1.randomArray2(-1);});

        //Dette fungerer ikke (forklar hvorfor!):
        //assertThrows(java.lang.NoClassDefFoundError.class,
        //        Week1.randomArray2(-3));
    }

}