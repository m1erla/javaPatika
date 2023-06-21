package WeekFour.AdventureGame;

public class River extends BattleLoc{
    public static boolean checkLoc = false;
    public River(Player player){
        super(player, "River", new Zombie(), "Food",2);
    }

    public static boolean isCheckLoc(){
        return checkLoc;
    }
    public static void setCheckLoc(boolean checkLoc){
        River.checkLoc = checkLoc;
    }
}
