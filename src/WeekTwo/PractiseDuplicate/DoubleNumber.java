package WeekTwo.PractiseDuplicate;

import java.util.Arrays;

public class DoubleNumber {
    public static void main(String[] args) {
        int[] numbers = {4, 24, 51, 65, 22, 4, 55, 32, 14, 22, 12, 10, 9, 6, 5, 77, 63};
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++){
            if (numbers[i] == numbers[i+1]){
                int doubleNumber = numbers[i];
                if (doubleNumber % 2 == 0){
                    count++;
                    System.out.println(doubleNumber + " ");
                }
            }
        }
        if (count == 0){
            System.out.println("There are no double number convenient the rule");
        }
    }


}
