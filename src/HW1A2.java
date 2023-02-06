import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a class designed to operate as specified in the
 * Github Assignment 2 section of <a href="https://docs.google.com/document/d/13vvs3OA0rPBhGPJAFB2V8SVXIBuswMsqTi13ueEshJo">this</a>
 * document
 */

public class HW1A2 {

    //Constants
    private static final int RANGE_MIN = 0; //Inclusive
    private static final int RANGE_MAX = 100; //Inclusive

    //Variables
    private final Random random;
    private final Scanner consoleIn;
    private int[] integers;
    private int evenIndexSum;
    private int oddIndexSum;
    private boolean running = true;

    public HW1A2() {
        //Initialize variables
        random = new Random();
        consoleIn = new Scanner(System.in);
    }

    private void initArray(int size) {
        integers = new int[size];

        //region Fill the integers array
        //Fill even indexes and add the numbers
        for(int i = 0; i < size; i+= 2) {
            int number = random.nextInt(RANGE_MIN, RANGE_MAX + 1);
            evenIndexSum += number;
            integers[i] = number;
        }
        //Fill odd indexes and add the numbers
        for(int i = 1; i < size; i+= 2) {
            int number = random.nextInt(RANGE_MIN, RANGE_MAX + 1);
            oddIndexSum += number;
            integers[i] = number;
        }
        //endregion
    }

    public void start() {
        while(running) {
            //TODO: Implement the menu
            System.out.println("Not implemented yet.");
            running = false;
        }
    }
    
    public void averageArray() {
        double[] result = new double[integers.length];

        double sum = evenIndexSum + oddIndexSum;

        //find the average of array elements
        double arrayAverage = sum / integers.length;

        //fill the result array with differences between array elements and average
        for (int k = 0; k < integers.length; k++) {
            result[k] = integers[k] - arrayAverage;
        }

        //display the result array
        System.out.println(Arrays.toString(result));
    }

    private int nextValidInteger() {
        int ret = Integer.MIN_VALUE;
        boolean found = false;

        //region Loop until a valid integer is entered
        while(!found) {
            //
            if(consoleIn.hasNextInt()) {
                found = true;
                ret = consoleIn.nextInt();
                consoleIn.nextLine();
            }
            else {
                System.out.println("Please enter a valid integer.");
                consoleIn.nextLine();
            }
        }
        //endregion
        return ret;
    }

}
