package WeekFour.AdventureGame;

public  class SafeHouse extends NormalLoc{

    private int health;

    public SafeHouse(Player player) {
        super(player, "Safe House ");

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean onLocation(){
        System.out.println("--------------------------------------");
        System.out.println("You in the safe house!! be relax!!");
        System.out.println("--------------------------------------");
        System.out.println("You Healed!");
        System.out.println("--------------------------------------");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        return true;
    }
}
