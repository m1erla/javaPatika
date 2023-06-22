package WeekFour.AdventureGame.Player;

public class AwardModule {
    private String awardName;
    public AwardModule(String awardName){
        this.awardName = awardName;
    }

    public static AwardModule[] awardModules(String awardName){
    AwardModule[] awardModules = new AwardModule[3];
    awardModules[0] = new AwardModule("Food");
    awardModules[1] = new AwardModule("Fire Wood");
    awardModules[2] = new AwardModule("Water");
    return awardModules;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
