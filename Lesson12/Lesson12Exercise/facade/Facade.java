package facade;

import java.util.*;

/**
 * Kodeskelet til VOP eksamen F15, opgave 2.
 * @author erso
 */
public class Facade {
    private int[] intArray;
    private Random random;
    private int sum;

    public Facade(){
        this.random = new Random();
    }

    public int[] getIntArray() {
        return intArray;
    }

    public int[] fillArray(int size,int max){
        this.intArray = new int[size];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(max);
        }
        return intArray;
    }

    public int sumOfDivisors(int divisor){
        for (int i : intArray)
            sum += i;

        System.out.println("The sum is: "+ sum);
        return sum / divisor;
    }

    public int[] fillUniqueArray(int size, int max){
        intArray = new int[size];

        if (size < max) {
            for (int i = 0; i < intArray.length; i++) {
                int newRandom = random.nextInt(max);

                if (!contains(intArray, newRandom)){
                        intArray[i] = newRandom;
                }
            }
        }
        Arrays.sort(intArray);

        return intArray;
    }

    private boolean contains(int[] array, int beforeIndex){
        boolean test = false;

        for (int element : array) {
            if (element == beforeIndex) {
                test = true;
                break;
            }
        } return test;
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        System.out.println("fillArray: " + Arrays.toString(facade.fillArray(20, 10)));

        int divisor = 3;
        System.out.println("\nDivisors of " + divisor + " has Sum: " + facade.sumOfDivisors(divisor));

        System.out.println("\nfillUnique: " + Arrays.toString(facade.fillUniqueArray(10, 20)));
        System.out.println("Error: " + Arrays.toString(facade.fillUniqueArray(10, 20)));
    }
}