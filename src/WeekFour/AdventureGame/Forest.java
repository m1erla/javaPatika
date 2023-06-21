package WeekFour.AdventureGame;

public class Forest extends BattleLoc{
    public static boolean checkLoc = false;
    public Forest(Player player){
        super(player, "Forest", new Bear(), "Fire Wood",3 );
    }

    public static boolean isCheckLoc(){
        return checkLoc;
    }

    public static void setCheckLoc(boolean checkLoc){
        Forest.checkLoc = checkLoc;
    }

}
