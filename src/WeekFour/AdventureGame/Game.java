package WeekFour.AdventureGame;

import WeekFour.AdventureGame.BattleLocs.Cave;
import WeekFour.AdventureGame.BattleLocs.Forest;
import WeekFour.AdventureGame.BattleLocs.Quarry;
import WeekFour.AdventureGame.BattleLocs.River;
import WeekFour.AdventureGame.Locations.Location;
import WeekFour.AdventureGame.Locations.SafeHouse;
import WeekFour.AdventureGame.Locations.ToolStore;
import WeekFour.AdventureGame.Obstacles.Obstacle;
import WeekFour.AdventureGame.Player.Player;

import java.util.Scanner;

public class Game{
    private Scanner input = new Scanner(System.in);
    private Player player;
    private Obstacle obstacle;

    private Location loc;

    public Game() {

    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public void began(){
        System.out.println("Welcome to the Adventure Game!");
        Player player = new Player("Emily Jean Stone");
        System.out.println("Dear " + player.getName() + " Welcome to the darker and foggy island!");
        System.out.println("Characters: ");
        player.selectChar();

        System.out.println("The game has been started!");
        Location location = null;
        while (true){
            player.playerInfo();
            System.out.println();
            System.out.println("***************' ZONES '***************");
            System.out.println();

            System.out.println("1 - Safe House => Getting health and out of monsters");
            System.out.println("2 - Tool Store => To buy something you need");
            System.out.println("3 - Cave => To get award <Water> -- Be careful!! The Vampire may come out!");
            System.out.println("4 - Forest => To get award <Firewood> -- Be careful!! The Bear may come out!");
            System.out.println("5 - River => To get award <Food> -- Be careful!! The Zombie may come out!");
            System.out.println("6 - Quarry => To get award <Randomly> -- Be careful!! The Viper may come out!");
            System.out.println("7 - Exit The Game => You can exit! don't worry about it!!");
            System.out.print("Please select a location you want to go : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                        location = new Cave(player);
                        break;
                case 4:
                        location = new Forest(player);
                        break;
                case 5:
                        location = new River(player);
                        break;
                case 6:
                    location = new Quarry(player);
                    break;
                case 7:
                    location = null;
                    break;
                default:
                    System.out.println("Please select a correct location!!");
            }
            if (location == null){
                System.out.println("You are quit the game!! see you soon");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!!");
                System.out.println("You exit the game!");
                break;
            }

    }
}
}
