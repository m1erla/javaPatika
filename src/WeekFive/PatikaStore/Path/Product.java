package WeekFive.PatikaStore.Path;

public class Product {
    private int productId;
    private String productName;
    private Brands productBrand;
    private Categories productCategory;
    private double price;
    private double discountRate;
    private int stockQuantity;
    private String internalStorage;
    private String screenSize;
    private String ramCapacity;
    private String color;
    private String batteryCapacity;

    public Product(int productId, String productName, Categories productCategory, double price, double discountRate, int stockQuantity, Brands productBrand, String internalStorage, String screenSize, String ramCapacity, String color, String batteryCapacity) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.discountRate = discountRate;
        this.stockQuantity = stockQuantity;
        this.productBrand = productBrand;
        this.internalStorage = internalStorage;
        this.screenSize = screenSize;
        this.ramCapacity = ramCapacity;
        this.color = color;
        this.batteryCapacity = batteryCapacity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Brands getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(Brands productBrand) {
        this.productBrand = productBrand;
    }

    public Categories getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Categories productCategory) {
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(String ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
