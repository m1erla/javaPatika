package WeekTwo.Practices.PractiseBoxing;

public class Ring {
    Fighter fighterOne;
    Fighter fighterTwo;
    int maxWeight;
    int minWeight;
    public Ring(Fighter fighterOne, Fighter fighterTwo, int maxWeight, int minWeight){
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }
    public void run(){
        if (checkWeight()){
            while (fighterOne.health > 0 && fighterTwo.health > 0){
                System.out.println("--------- NEW ROUND ---------");
                if (whoAttackFirst() == true){
                    this.fighterTwo.health = this.fighterOne.hit(this.fighterTwo);
                    System.out.println(fighterTwo.name + " Reamining Health \t:" + fighterTwo.health);
                    System.out.println(fighterOne.name + " Reamining Health \t:" + fighterOne.health);
                    if (isWin()){
                        break;
                    }
                }else {
                    this.fighterOne.health = this.fighterTwo.hit(this.fighterOne);
                    System.out.println(fighterOne.name + " Reamining Health \t:" + fighterOne.health);
                    System.out.println(fighterTwo.name + " Reamining Health \t:" + fighterTwo.health);
                    if (isWin()){
                        break;
                    }
                }
            }
        }else {
            System.out.println("Athletes' weights do not match");
        }
    }
    public boolean checkWeight(){
        return (fighterOne.weight >= minWeight && fighterOne.weight <= maxWeight) &&
                (fighterTwo.weight >= minWeight && fighterTwo.weight <= maxWeight);
    }
    public boolean isWin(){
        if (fighterOne.health == 0){
            System.out.println("Winner : " + fighterTwo.name);
            return  true;
        } else if (fighterTwo.health == 0) {
            System.out.println("Winner : " + fighterOne.name);
            return  true;
        }
        return  false;
    }
   public boolean whoAttackFirst(){
        int number = (int)(Math.random()*10);
        if (number <= 5){
            return  true;
        }
        return  false;
    }
}
