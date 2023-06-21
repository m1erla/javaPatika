package WeekFour.AdventureGame;

import java.util.Random;

public class Obstacle {
    private int obstacleNumber;
    private int id;
    private String name;
    private int damage;
    private int health;
    private int prize;
    private int defHealth;

    private Random random = new Random();


    public Obstacle(int id, String name, int damage, int health, int prize ) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defHealth = health;
        this.prize = prize;

    }



    public Obstacle(int obstacleNumber){
        this.obstacleNumber= obstacleNumber;
    }

    public int getObstacleNumber(){
        return obstacleNumber;
    }

    public void setObstacleNumber(int obstacleNumber){
        this.obstacleNumber= obstacleNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage == 0){
            damage = random.nextInt(3,7);
        }
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 ){
            health = 0;
        }

        this.health = health;
    }

    public int getPrize() {
        return prize;
    }
    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
