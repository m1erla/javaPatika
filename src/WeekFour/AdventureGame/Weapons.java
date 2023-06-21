package WeekFour.AdventureGame;

public class Weapons {

    private String name;
    private int id;
    private int damage;
    private int price;
    private int block;

    public Weapons(int id, String name, int damage, int price){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons(){
        Weapons[] weaponList = new Weapons[5];
        weaponList[0] = new Weapons(1,"Pistol",  8, 15);
        weaponList[1] = new Weapons(2,"Rifle",  15, 30);
        weaponList[2] = new Weapons(3,"Sword", 20, 60);
        weaponList[3] = new Weapons(4,"Arrow",  12, 20);
        weaponList[4] = new Weapons(5,"Shoutgan",  30, 50);
        return weaponList;
    }
    public static Weapons getWeaponObjById(int id){
        for (Weapons gun : Weapons.weapons()){
            if (gun.getId() == id){
                return gun;
            }
        }
        return null;
    }

    public String getName(){
        return name;

    }
    public void setName(String name){
        this.name = name;

    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

}
