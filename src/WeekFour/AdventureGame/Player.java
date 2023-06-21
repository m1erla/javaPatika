package WeekFour.AdventureGame;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player extends Game{
    private Inventory inventory;
    private int damage;
    private int defHealth;
    private int id;
    private int health;
    private int money;
    private String name;
    private String charName;
    private String award;
    private Obstacle obstacle;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectHelmet(){
        for (Helmet armor: Helmet.helmets()){
            System.out.println("< Id: " + armor.getId() + " -> " +
                    "\t Name: " + armor.getName() + " -> " +
                    "\t Block: " + armor.getBlock() + " -> " +
                    "\t Price: "+ armor.getPrice()+ " >" );
        }
        System.out.print("Please select a helmet! => ");
        int selectArmor = input.nextInt();
        switch (selectArmor){
            case 1:
                initHelmet(Helmet.helmets()[0]);
                break;
            case 2:
                initHelmet(Helmet.helmets()[1]);
                break;
            case 3:
                initHelmet(Helmet.helmets()[2]);
                break;
            default:
                System.out.println("Please select a correct helmet!!");
        }
        System.out.println("< Your helmet -> " + "Id: " + getId() + " -> "
                + " Armor Name: " + getName()  + " ->"
                + " Block: " + getDamage() + " -> "
                + " Price: " + getMoney() + " >");
    }
    public void selectWeapon(){
        for (Weapons weapon: Weapons.weapons()) {
            System.out.println("< Id: " + weapon.getId() + " -> "+
                    "\t Name: " + weapon.getName() + " -> "+
                    "\t Damage: " + weapon.getDamage() + " -> "+
                    "\t Price: " + weapon.getPrice() + " >");
        }
        System.out.print("Please buy a weapon ! => ");
        int selectWeapon = input.nextInt();
        while(selectWeapon < 1 || selectWeapon > Weapons.weapons().length){
            System.out.println("Incorrect value, please enter again : ");
            selectWeapon = input.nextInt();
        }

        switch (selectWeapon){
            case 1 :
                initWeapon(Weapons.weapons()[0]);
                break;
            case 2:
                initWeapon(Weapons.weapons()[1]);
                break;
            case 3:
                initWeapon(Weapons.weapons()[2]);
                break;
            case 4 :
                initWeapon(Weapons.weapons()[3]);
                break;
            case 5:
                initWeapon(Weapons.weapons()[4]);
                break;
            default:
                System.out.println("Please select a correct weapon !");

        }
        System.out.println("< Your Weapon -> " + "Id: " + getId() + " -> "
                + " Gun Name: " + getName()  + " ->"
                + " Damage: " + getDamage() + " -> "
                + " Price: " + getMoney() + " >");
    }
    public void selectChar(){
        System.out.println("-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-");
        for (Character character : Character.characters()) {
            System.out.println("Id: " + character.getId() + " -> " +
                    "\t Character: " + character.getName() + " -> "+
                    "\t Damage: " + character.getDamage() +" ->"+
                    "\t Health: " + character.getHealth() +" ->"+
            "\t Money: " + character.getMoney());
        }

        System.out.print("Please Select a Character ! => ");

        int selectChar = input.nextInt();

        while (selectChar !=0){
            if (selectChar == 1){
                initCharacter(Character.characters()[0]);
            } else if (selectChar ==2) {
                initCharacter(Character.characters()[1]);

            } else if (selectChar ==3) {
                initCharacter(Character.characters()[2]);

            } else if (selectChar ==4) {
                initCharacter(Character.characters()[3]);

            } else if (selectChar == 5) {
                initCharacter(Character.characters()[4]);

            } else if (selectChar == 6) {
                initCharacter(Character.characters()[5]);

            } else if (selectChar > 6) {
                System.out.println("Please select a correct character!!");
                System.out.println("-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-");
                began();
            }

            break;

        }
        System.out.println("Your Character -> " + "Id: " + getId() + " -> " + " Char Name: "
                + getCharName() + " -> " + " Damage: "
                + getDamage() + " ->" + " Health: "
                + getHealth() + " ->" + " Money: "
                + getMoney());


    }
    public void initHelmet(Helmet helmet){
        this.setId(helmet.getId());
        this.setName(helmet.getName());
        this.setDamage(helmet.getBlock());
        this.setMoney(helmet.getPrice());
    }
    public void initWeapon(Weapons weapons){
        this.setId(weapons.getId());
        this.setName(weapons.getName());
        this.setDamage(weapons.getDamage());
        this.setMoney(weapons.getPrice());
    }

    public void initCharacter(Character character){
        this.setId(character.getId());
        this.setCharName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setDefHealth(character.getHealth());
        this.setMoney(character.getMoney());

    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public void playerInfo(){
        System.out.println("------------------------------------------");
        System.out.println("Player Information");
        System.out.println("< Health: " + this.getHealth() + " -> " +
                " Damage: " + this.getTotalDamage() + " -> " +
                " Block: " + this.getInventory().getHelmet().getBlock() + " >");
        System.out.println("------------------------------------------");
        System.out.println("Inventory");
        System.out.println("------------------------------------------");
        System.out.println("< Weapon: " + this.getInventory().getWeapon().getName() + " -> " +
        " Armor: " + this.getInventory().getHelmet().getName() + " -> " +
                " Money: " + this.getMoney() + "$ >");
    }
    public int getId() {
        return id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setId(int id) {
        this.id = id;
    }

  public String getAward(){
        return award;
  }
  public void setAward(String award){
        this.award = award;
  }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getMoney() {
        return money;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Weapons getWeapon() {
        return this.getInventory().getWeapon();
    }
    public Helmet getHelmet(){
        return this.getInventory().getHelmet();
    }


}
