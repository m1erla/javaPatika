package WeekFour.AdventureGame;

import java.util.Random;

public class Viper extends Obstacle {
    public Viper(){
        super(4,"Viper",0,12,0);
        Random damage = new Random();
        int randomDamage = damage.nextInt(4) + 3;
        super.setDamage(randomDamage);
    }

}
