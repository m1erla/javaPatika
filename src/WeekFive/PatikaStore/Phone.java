package WeekFive.PatikaStore;

import java.util.*;

public class Phone {
    private int id;
    private double price;
    private double discount;
    private int stock;
    private java.lang.String phoneName;
    private String brandName;
    private int storage;
    private double inc;
    private int camera;
    private int battery;
    private int ram;
    private java.lang.String color;
    static Scanner input = new Scanner(System.in);
    static Map<java.lang.String, Phone> phoneList = new HashMap<>();
    static Set<Map.Entry<java.lang.String, Phone>> phoneDetails = phoneList.entrySet();
    static Set<java.lang.String> idNo = phoneList.keySet();
    public Phone(){

    }
    public Phone(int id, double price, String phoneName, String brandName, int storage, double inc, int camera, int battery, int ram, String color) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.phoneName = phoneName;
        this.brandName = brandName;
        this.storage = storage;
        this.inc = inc;
        this.camera = camera;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
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

    public java.lang.String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(java.lang.String phoneName) {
        this.phoneName = phoneName;
    }

    public String getBrands() {
        return brandName;
    }

    public void setBrands(String brands) {
        this.brandName = brands;
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

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public java.lang.String getColor() {
        return color;
    }

    public void setColor(java.lang.String color) {
        this.color = color;
    }
    static void defaultPhones(){
        ArrayList<Phone> defaultPhones = new ArrayList<>();
        defaultPhones.add(new Phone(1,3199.0, "SAMSUNG GALAXY A51", "Samsung", 128, 6.5, 32, 4000, 6, "Black"));
        defaultPhones.add(new Phone(2,7379.0, "IPHONE 11 64 GB", "Apple", 64, 6.1, 5, 3046, 6, "Blue"));
        defaultPhones.add(new Phone(3,4012.0, "REDMI NOTE 10 PRO 8 GB", "Xiaomi", 128, 6.5, 35, 4000, 12, "White"));

        for (Phone list: defaultPhones) {
            System.out.println(list);
        }
    }

    @Override
    public String toString(){
        return "Phone " + "-".repeat(200) +
                "\n < ID -> " + id +
                " -- Name -> " + phoneName +
                " -- Price -> " + price + "$ " +
                " -- Brand -> " + brandName +
                " -- Storage -> " + storage + " GB "+
                " -- Screen -> " + inc + " inc"+
                " -- Camera -> " + camera + " megapx"+
                " -- Battery -> " + battery + " maH"+
                " -- RAM -> " + ram + " GB "+
                " -- Color -> " + color + " >";
    }
}
