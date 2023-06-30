package WeekFive.FixtureGenerator;
import java.util.ArrayList;
import java.util.Random;

public class Fixture {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> competition = new ArrayList<>();

        System.out.println("-_-".repeat(10) + "Welcome To The Patika League" + "-_-".repeat(10));
        System.out.println("-".repeat(45));

        competition.add("Real Madrid");
        competition.add("Barcelona");
        competition.add("Juventus");
        competition.add("Bayern Munich");
        competition.add("Manchester United");
        competition.add("Galatasaray");
        competition.add("Inter");

        ArrayList<String> home = new ArrayList<>();
        ArrayList<String> away = new ArrayList<>();

        for (int i = 0; i < competition.size(); i++){
            home.add((String) competition.toArray()[i]);
        }
        for (int i = 0; i < (competition.size()/2); i++){
            int rand = random.nextInt(0, home.size());
            away.add((String) home.toArray()[rand]);
            home.remove((String) home.toArray()[rand]);
        }
        away.add(null);
        for (int i = 0; i < home.size(); i++){
            if (away.toArray()[i] != null){
                System.out.println(home.toArray()[i] + " vs " + away.toArray()[i]);
                System.out.println("-".repeat(45));
            }else {
                System.out.println(home.toArray()[i] + " vs " + " BAY ");
                System.out.println("-".repeat(45));
            }
        }
    }
    }

