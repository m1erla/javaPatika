package WeekFive.PatikaStore;

import java.util.ArrayList;

public class NoteBook {
    private int id;
    private double price;
    private double discount;
    private int stock;
    private String laptopName;
    private String brandName;
    private int ram;
    private int storage;
    private double inc;
    public NoteBook(){

    }
    public NoteBook(int id, String name, double price, String brandName, int storage, double inc , int ram) {
        this.id = id;
        this.price = price;
        this.laptopName = name;
        this.brandName = brandName;
        this.ram = ram;
        this.storage = storage;
        this.inc = inc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String  getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String  laptopName) {
        this.laptopName = laptopName;
    }

    public String  getBrands() {
        return brandName;
    }

    public void setBrands(String  brandName) {
        this.brandName = brandName;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getInc() {
        return inc;
    }

    public void setInc(double inc) {
        this.inc = inc;
    }
    static void defaultLaptops(){
        ArrayList<NoteBook> defaultLaptops = new ArrayList<>();
        defaultLaptops.add(new NoteBook(1, "HUAWEI Matebook 14",7000.0, "Huawei", 512, 14.0, 16 ));
        defaultLaptops.add(new NoteBook(2, "LENOVO V14 IGL",3699.0, "Lenovo", 1024, 14.0, 8 ));
        defaultLaptops.add(new NoteBook(3, "ASUS Tuf Gaming",8199.0, "Asus", 2048, 15.6, 32 ));
        for (NoteBook list : defaultLaptops) {
            System.out.println(list);
        }
    }
    @Override
    public String toString(){
        return "Notebook " + "-".repeat(140) +
                "\n < ID -> " + id +
                " -- Name -> " + laptopName +
                " -- Price -> " + price + "$ "+
                " -- Brand -> " + brandName +
                " -- Storage -> " + storage + " GB" +
                " -- Screen -> " + inc  + " inc"+
                " -- RAM -> " + ram + "GB > ";
    }
}
