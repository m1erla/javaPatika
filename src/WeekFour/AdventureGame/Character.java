package WeekFour.AdventureGame;

public class Character {
    private String name;
    private int damage;
    private int health;
    private int money;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Character(int id , String name, int damage, int health, int money){
        this.id = id;
        this.name = name;
        this.damage=  damage;
        this.health = health;
        this.money = money;
    }

    public static Character[] characters(){
        Character[] characterList = new Character[6];
        characterList[0] = new Character(1,"Samurai",5 ,21, 45);
        characterList[1] = new Character(2,"Archer", 7, 18, 40);
        characterList[2] = new Character(3,"Knight " , 8, 24, 75);
        characterList[3] = new Character(4,"Killer", 12, 45, 55);
        characterList[4] = new Character(5,"Soldier", 8, 17,40);
        characterList[5] = new Character(6,"Warrior",22,40,80);
        return characterList;
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
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
