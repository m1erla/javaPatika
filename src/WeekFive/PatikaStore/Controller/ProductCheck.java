package WeekFive.PatikaStore.Controller;

import WeekFive.PatikaStore.Path.Brands;
import WeekFive.PatikaStore.Path.Categories;
import WeekFive.PatikaStore.Path.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCheck {
    private static List<Product> products = new ArrayList<>();
    private static int lastProductId;
    private CategoryCheck categoryController;
    private BrandCheck brandController;

    public ProductCheck(CategoryCheck categoryController, BrandCheck brandController) {
        this.categoryController = categoryController;
        this.brandController = brandController;
        defaultProducts();
    }

    private void defaultProducts(){
        Categories phone = categoryController.getCategoryByName("Phone");
        Categories notebook = categoryController.getCategoryByName("Notebook");

        // Default Cellphones
        products.add(
                new Product(++lastProductId, "SAMSUNG GALAXY A51", phone,
                        3199, 0,10,brandController.getBrandByName("Samsung"),
                        "128 GB","6.5 inc","6 GB","Black", "4000 mAh")
        );
        products.add(
                new Product(++lastProductId, "iPhone 11", phone,
                        7379, 0,5,brandController.getBrandByName("Apple"),
                        "64 GB","6.1 inc","6 GB","Blue", "3046 mAh")
        );

        products.add(
                new Product(++lastProductId, "Redmi Note 10 Pro", phone,
                        4012, 0,15,brandController.getBrandByName("Xiaomi"),
                        "128 GB","6.5 inc","12 GB","White", "4000 mAh")
        );

        // Default notebooks
        products.add(
                new Product(++lastProductId, "HUAWEI Matebook 14", notebook,
                        7000, 0,4,brandController.getBrandByName("Huawei"),
                        "512 GB","14 inc","16 GB", "---", "---")
        );

        products.add(
                new Product(++lastProductId, "LENOVO V14 IGL", notebook,
                        3699, 0,4,brandController.getBrandByName("Lenovo"),
                        "1 TB","14 inc","8 GB", "---", "---")
        );

        products.add(
                new Product(++lastProductId, "ASUS Tuf Gaming", notebook,
                        8199, 0,4,brandController.getBrandByName("Asus"),
                        "2 TB","15.6 inc","2x16 GB", "---", "---")
        );
    }

    public List<Product> getProducts() {
        return products;
    }

    public void deleteUncategorizedProducts(){
        for (Product p : products)
        {
            if(p.getProductCategory() == null){
                products.remove(p);
                deleteUncategorizedProducts();
                break;
            }
        }
    }

    public void deleteUnbrandedProducts(){
        for (Product p : products)
        {
            if(p.getProductBrand() == null){
                products.remove(p);
                deleteUnbrandedProducts();
                break;
            }
        }
    }

    public int getLastProductId() {
        return lastProductId;
    }

    public void addNewProduct(String productName, Categories productCategory, double price, double discountRate, int stockQuantity, Brands productBrand, String internalStorage, String screenSize, String ramCapacity, String color, String batteryCapacity){

        products.add(
                new Product(++lastProductId, productName, productCategory,
                        price, discountRate,stockQuantity,productBrand,
                        internalStorage,screenSize,ramCapacity,color, batteryCapacity)
        );

        System.out.println("New Product Added.");



    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

}
