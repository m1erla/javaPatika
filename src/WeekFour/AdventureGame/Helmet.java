package WeekFour.AdventureGame;

public class Helmet {
    private int id;
    private String name;
    private int block;
    private int price;

    public Helmet(int id, String name, int block, int price){
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Helmet[] helmets(){
        Helmet[] helmetList = new Helmet[3];
        helmetList[0] = new Helmet(1,"Mild-Heavy" , 3 , 15);
        helmetList[1] = new Helmet(2,"Middle-Heavy", 5, 25);
        helmetList[2] = new Helmet(3,"Heavy", 8, 30);
        return helmetList;
    }
  public static Helmet getHelmetObjById(int id){
      for (Helmet armor : Helmet.helmets()) {
          if (armor.getId() == id){
              return armor;
          }
      }
      return null;
  }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
