package WeekFour.AdventureGame.BattleLocs;

import WeekFour.AdventureGame.Player.Player;
import WeekFour.AdventureGame.Obstacles.Viper;
import WeekFour.AdventureGame.Locations.BattleLoc;

public class Quarry extends BattleLoc {

    public Quarry(Player player){
        super(player,"Quarry", new Viper(), null,5 );
    }




}
