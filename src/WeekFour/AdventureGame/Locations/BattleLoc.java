package WeekFour.AdventureGame.Locations;

import WeekFour.AdventureGame.Equipments.Helmet;
import WeekFour.AdventureGame.Obstacles.Obstacle;
import WeekFour.AdventureGame.Player.Player;
import WeekFour.AdventureGame.Equipments.Weapons;

import java.util.Random;

public abstract class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private Random random = new Random();
    private int maxObstacle;


    private boolean isAwardTaken;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award , int maxObstacle) {

        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;


    }

    @Override
    public boolean onLocation(){


            int obstacleNumber = this.randomObstacleNumber();
            System.out.println("You are at the " + this.getName() + " right now !!!!");
            System.out.println("Be careful!!! there is a " + obstacleNumber + " " + getObstacle().getName() + " living here");
            System.out.print("<F>ight or <R>un : ");
            System.out.println();
            String selectCase = input.nextLine().toUpperCase();
            if (selectCase.equals("F") && combat(obstacleNumber)) {
                System.out.println(this.getName() + " You beat all monsters!");
                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("Good Game You Are Dead!!");
                    return false;
                } else {
                    if (this.getName().equals("Quarry")) {
                        quarryAward();
                    } else {
                        System.out.println(" You beat all monsters! in " + this.getName());
                        System.out.println("You earned " + this.getAward() + " awards and get " + this.getObstacle().getPrize() + "$");

                        this.getPlayer().getInventory().setAward(this.getAward());

                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getPrize());
                        return true;
                    }
                }
            return true;
            }
        return true;
    }
    public boolean combat(int obstacleNumber){

        for (int i = 1; i <= obstacleNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<H>it or <R>un : ");
                String selectCombat = input.nextLine().toUpperCase();

                if (selectCombat.equals("H")){
                    System.out.println();
                    System.out.println("You Hit The "  + this.getObstacle().getName() + "!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("The " + this.getObstacle().getName() + " Hit You !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getHelmet().getBlock();
                        if (obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("-----------------------------------------------------");
                System.out.println("You Beat The " + this.getObstacle().getName() + "!!");
                System.out.println("-----------------------------------------------------");
                System.out.println("You Get The Money --> " + this.getObstacle().getPrize() + "$ ");
                System.out.println("-----------------------------------------------------");
                System.out.println("Also You Get Award --> " + this.getAward());
                System.out.println("-----------------------------------------------------");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getPrize());
                this.getPlayer().setAward(this.getAward());
                System.out.println("Inventory");
                System.out.println("------------------------------------------");
                System.out.println("< Weapon: " + this.getPlayer().getWeapon().getName() + " -> " +
                        " Armor: " + this.getPlayer().getHelmet().getName() + " -> " +
                        " Money: " + this.getPlayer().getMoney() + "$ " +
                        " Award: " + this.getPlayer().getAward() + " >");
            }
        }
        return false;
    }
    public void afterHit(){
        System.out.println(this.getPlayer().getCharName() + " Health: " + this.getPlayer().getHealth()) ;
        System.out.println(this.getObstacle().getName() + " Health: " + this.getObstacle().getHealth());
        System.out.println();
    }
    public boolean randomHit(){
        int number = (int)(Math.random()*10);
        if (number <= 5){
            return true;
        }
        return false;
    }
    public boolean isFinish(){
        if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
            System.out.println("You Already Beat The " + this.getObstacle().getName());
            return false;
        } else {
            System.out.println("You Are Already Dead!! ");
        }
        return true;
    }
    public void playerStats(){
        System.out.println();
        System.out.println("*************************");
        System.out.println("Player Informations ");
        System.out.println("*************************");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getWeapon().getName());
        System.out.println("Helmet: " + this.getPlayer().getHelmet().getName());
        System.out.println("To Block: " + this.getPlayer().getHelmet().getBlock());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());


    }
    public void obstacleStats(int i){
        System.out.println();
        System.out.println("************************");
        System.out.println(i + ". " + this.getObstacle().getName() + " Informations ");
        System.out.println("************************");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Prize: " + this.getObstacle().getPrize() + "$");
    }


    public void quarryAward(){
        System.out.println("-------------------------------------------------");
        System.out.println("You beat the " + this.getObstacle().getName() + " in " + this.getName());

        int prizeChance = random.nextInt(1,100);
        int weaponChance = random.nextInt(1,100);
        int helmetChance = random.nextInt(1,100);
        int moneyChance = random.nextInt(1,100);

        if (1 <= prizeChance && prizeChance <= 24){
            if (1 <= moneyChance && moneyChance <= 19){
                System.out.println("You have won 10$!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            } else if (20 <= moneyChance && moneyChance <= 49) {
                System.out.println("You have won 5$!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            }else {
                System.out.println("You have won 1$!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            }
        } else if (25 <= prizeChance && prizeChance <= 39) {
            if (1 <= weaponChance && weaponChance <= 19){
                System.out.println("You have won a Rifle!");
                this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(2));
            } else if (20 <= weaponChance && weaponChance <= 39) {
                System.out.println("You have won a Sword!");
                this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(3));
            } else if (40 <= weaponChance && weaponChance <= 59) {
                this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(4));
            } else if (60 <= weaponChance && weaponChance <= 79) {
                this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(5));
            } else {
                System.out.println("You have won a Pistol!");
                this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(1));
            }
        } else if (40 <= prizeChance && prizeChance <= 54) {
            if (1 <= helmetChance && helmetChance <= 19){
                System.out.println("You have won a Heavy-Armor!");
                this.getPlayer().getInventory().setHelmet(Helmet.getHelmetObjById(3));
            } else if (20 <= helmetChance && helmetChance <= 49) {
                System.out.println("You have won a Middle-Armor!");
                this.getPlayer().getInventory().setHelmet(Helmet.getHelmetObjById(2));
            }else {
                System.out.println("You have won a Mild-Armor!");
                this.getPlayer().getInventory().setHelmet(Helmet.getHelmetObjById(1));
            }
        }else {
            System.out.println("Unfortunately You Couldn't Get an any Drop From Quarry ");
        }

    }
    public int randomObstacleNumber(){
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        if (!award.equals("random")){
            this.award = award;
        }else {
      this.award= null;
        }
    }
    public boolean getIsAwardTaken(){
        return isAwardTaken;
    }
    public void setIsAwardTaken(boolean awardTaken){
        this.isAwardTaken = awardTaken;
    }
    public int getMaxObstacle(){
        return maxObstacle;
    }
    public void setMaxObstacle(int maxObstacle){
        this.maxObstacle = maxObstacle;
    }
}