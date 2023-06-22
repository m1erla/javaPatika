package WeekFour.AdventureGame.Locations;

import WeekFour.AdventureGame.Player.Player;

public abstract class NormalLoc extends Location{

    public NormalLoc(Player playerOne, String name) {
        super(playerOne, name);
    }

    @Override
    public boolean onLocation(){
        return true;
    }
}
