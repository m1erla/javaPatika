package WeekTwo.PractiseBoxing;

public class Main {
    public static void main(String[] args) {
        Fighter tyler = new Fighter("Tyler" , 22 , 100, 90, 0);
        Fighter jack = new Fighter("Jack", 35, 95, 105, 0);
        Ring match = new Ring(tyler,jack, 105, 90);
        match.run();
    }
}
