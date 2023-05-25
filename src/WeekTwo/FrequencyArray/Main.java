package WeekTwo.FrequencyArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Defined Array Method
        int[] numbers = {1, 4, -12, 444, 12, 46, -33, 4, 444, 1, -12, 56, 0, 45, -12, 444, 1, -12, 444};
        int counter = 1;

        // Ouput For Information About The Array List
        System.out.println("Array : " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sort : " + Arrays.toString(numbers));

        // Move To Next Step
        System.out.println("***********************");
        System.out.println("Repeat Counts :  ");
        System.out.println("***********************");


        // Use for Loop to get how much repeat number
        for (int i = 0; i < numbers.length; i++) {
            // We remove the first index.
            if (i == 0) {
                for (int j = 0; j < numbers.length; j++) {
                    if ((i != j) && (numbers[i] == numbers[j])) {
                        counter++;
                    }
                }
                System.out.println(numbers[i] + " number " + "repeated " +  counter + " times.");
            }
            // When the sequence is sorted, the repeats come one after the other and we go by matching the previous one.
            else if (numbers[i] != numbers[i-1]) {
                for (int j = 0; j < numbers.length; j++) {
                    if ((i != j) && (numbers[i] == numbers[j])) {
                        counter++;
                    }
                }
                // Final Output
                System.out.println(numbers[i] + " number " + "repeated " + counter + " times.");
            }
            counter = 1;
        }
    }
}
