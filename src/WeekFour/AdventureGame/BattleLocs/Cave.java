package WeekFour.AdventureGame.BattleLocs;

import WeekFour.AdventureGame.Player.Player;
import WeekFour.AdventureGame.Obstacles.Vampire;
import WeekFour.AdventureGame.Locations.BattleLoc;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player, "Cave " , new Vampire(), "Water", 3);
    }




}
