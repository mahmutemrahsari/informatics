import java.util.Arrays;

class ArrayValue{
    public static void main(String[] args) {
    
        int[] values = {3,5,2,88,32,65,23,12,43,56,23,54,5};
    //  int[] values = new int[100];
    
    /*
    //  Filling the array with square of values from i to values.length 
        for (int i = 0; i < values.length; i++)
    //  for (int i = 0; i < 50; i++)
        {
            values[i] = i*i;
            System.out.println(values[i]);
        }
            System.out.println("*******************");
            System.out.println(values[99]);
    */

    //  Sum and average value    
        double sum = 0;
        for(int element:values)
        {
            sum = sum + element;
            System.out.println("Summing: "+sum);
        }

        System.out.println("total: "+sum);
        
        if(values.length>0)
        {
            System.out.println("Average: " +sum/values.length);
        }

    //  Largest value
        double largest = values[0];
    //  Note that the loop starts at 1 because we initialize largest with values[0].    
        for(int i = 1; i < values.length; i++)
        {
            if(values[i]>largest)
            {
                largest = values[i];
            }
        }
        System.out.println("Largest value is: " + largest);

    //  Smallest value
        double smallest = values[0];
        for(int i = 1; i < values.length; i++)
        {
            if(values[i] < smallest)
            {
                smallest = values[i];
            }   
        }
        System.out.println("Smallest value is: " + smallest);
        System.out.println("\n");

    //  Element separators
        System.out.println("Values with element separators:"); 
        for(int i = 0; i < values.length; i++)
        {
            if(i>0)
            {
                System.out.print(" | ");
            }
            System.out.print(values[i]);
        }
        System.out.println("\n*****************************");
        
    // Comma separator
        System.out.println("Values with comma separator:\n" + Arrays.toString(values));

    }
}



