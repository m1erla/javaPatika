package WeekTwo.PractiseAvarage;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] avarageList = { 1, 6, 7, 8, 12, 43, 56, 76, 88};
        double harmonicNumber = 0.0;

        for (int i = 0; i < avarageList.length; i++){
            harmonicNumber  +=  (1.0 / avarageList[i]);
        }
        double harmonicAvarage = avarageList.length / harmonicNumber;

        System.out.println(Arrays.toString(avarageList) + " Of The List");
        System.out.println();
        System.out.println("Harmonic Avarage : " + harmonicAvarage);
        System.out.println("Harmonic Number :  " + harmonicNumber);
    }
}
