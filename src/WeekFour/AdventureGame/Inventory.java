package WeekFour.AdventureGame;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorBlock;
    private Weapons weapon;
    private Helmet helmet;
    private String award;
    private int awardModules = 0;
    private ArrayList awards = new ArrayList();

    public Inventory(){
        this.weapon = new Weapons(-1,"Punch", 0,0);
        this.helmet = new Helmet(-1,"Body",0,0);
    }

    public boolean isAwardTaken(String awardLoc){
        for (Object award : awards){
            if (award.equals(awardLoc)){
                return true;
            }
        }return false;
    }
    public ArrayList getAwards(){
        return awards;
    }
    public void setAwards(String award){
        this.award = award;
    }
    public boolean isWater(){
        return water;
    }
    public void setWater(boolean water){
        this.water = water;
    }

    public boolean isFood(){
        return food;

    }
    public int onAwardModules(int awr){
        this.awardModules += awr;
        return awardModules;
    }

    public int getAwardModules() {
        return awardModules;
    }

    public void setAwardModules(int awardModules) {
        this.awardModules = awardModules;
    }

    public String getAward(){
        return award;
    }
    public void setAward(String award){
        this.award = award;
    }
    public void setFood(boolean food){
        this.food = food;
    }

    public boolean isFireWood(){
        return firewood;

    }
    public void setFirewood(boolean firewood){
        this.firewood = firewood;
    }

    public String getWeaponName(){
        return weaponName;
    }
    public void setWeaponName(String weaponName){
        this.weaponName = weaponName;
    }
    public String getArmorName(){
        return armorName;
    }
    public void setArmorName(String armorName){
        this.armorName = armorName;
    }
    public int getWeaponDamage(){
        return  weaponDamage;
    }
    public void setWeaponDamage(int weaponDamage){
        this.weaponName = weaponName;
    }
    public int getArmorBlock(){
        return armorBlock;
    }
    public void setArmorBlock(int armorBlock){
        this.armorName = armorName;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }
}
