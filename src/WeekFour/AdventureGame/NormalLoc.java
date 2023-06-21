package WeekFour.AdventureGame;

public abstract class NormalLoc extends Location{

    public NormalLoc(Player playerOne, String name) {
        super(playerOne, name);
    }

    @Override
    public boolean onLocation(){
        return true;
    }
}
