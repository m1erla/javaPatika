package WeekFive.PatikaStore.Store;

import WeekFive.PatikaStore.Controller.BrandCheck;
import WeekFive.PatikaStore.Controller.CategoryCheck;
import WeekFive.PatikaStore.Controller.ProductCheck;
import WeekFive.PatikaStore.Path.Brands;
import WeekFive.PatikaStore.Path.Categories;
import WeekFive.PatikaStore.Path.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HeadQuarter {
    private static final Scanner scanner = new Scanner(System.in);
    private CategoryCheck categoryController;
    private BrandCheck brandController;
    private ProductCheck productController;

    public HeadQuarter(CategoryCheck categoryController, BrandCheck brandController, ProductCheck productController) {
        this.categoryController = categoryController;
        this.brandController = brandController;
        this.productController = productController;
    }

    public void storeMenu(){
        String str =
                "-".repeat(20) + "Patika Store Product Management Panel"+ "-".repeat(20) + "\n"
                        + "   _____________________     _______________________  \n"
                        + "   | 1-Brand Operations |    | 2-Product Operations |  \n"
                        + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯  \n"
                        + "   _________________________     __________   \n"
                        + "   | 3-Category Operations |     | 0-Exit |   \n"
                        + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯     ¯¯¯¯¯¯¯¯¯¯   \n"
                        +  "-".repeat(75) ;

        System.out.println(str);

        int preference = getIntegerFromMinToMaxFromUser(0,3, "Please select the transaction you want to do : ");

        switch (preference)
        {
            case 1 -> categoryOperationsMenu();
            case 2 -> brandOperationsMenu();
            case 3 -> productOperationsMenu();
            case 0 -> exitTheProgram();
        }
    }

    // CATEGORY OPERATIONS.....................
    private void categoryOperationsMenu(){
        String str =
                "---------------------------------\n" +
                        "Patika Store CATEGORY Transactions!\n" +
                        "1- List All Categories,\n" +
                        "2- List Products By Category,\n" +
                        "3- Add New Category,\n" +
                        "4- Delete Category,\n" +
                        "0- Back To Main Menu!\n" +
                        "---------------------------------";
        System.out.println(str);

        int preference = getIntegerFromMinToMaxFromUser(0,4,"Your Preference: ");

        switch (preference)
        {
            case 1 -> listAllCategories();
            case 2 -> listProductByCategory();
            case 3 -> addNewCategory();
            case 4 -> deleteCategory();
            case 0 -> storeMenu();
        }
    }

    public void listAllCategories(){
        List<Categories> categories = categoryController.getCategories();

        if(categories.size() == 0){
            System.out.println("There is no category!");
            categoryOperationsMenu();
            return;
        }

        System.out.println("----------------------------\nCATEGORIES...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","CATEGORY NAME");

        for (Categories c : categories){
            System.out.printf("| %1$-4d| %2$-20s|%n",c.getCategoryId(),c.getCategoryName());
        }

        System.out.println("----------------------------");

        categoryOperationsMenu();
    }

    public void listProductByCategory(){
        List<Categories> categories = categoryController.getCategories();

        if(categories.size() == 0){
            System.out.println("There is no category!");
            categoryOperationsMenu();
            return;
        }

        System.out.println("----------------------------\nCATEGORIES...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","CATEGORY NAME");

        for (Categories c : categories){
            System.out.printf("| %1$-4d| %2$-20s|%n",c.getCategoryId(),c.getCategoryName());
        }

        System.out.println("----------------------------");

        Categories category = null;
        while (category == null){
            int preference = getIntegerFromMinToMaxFromUser(0, categoryController.getLastCategoryId(),"Enter the category id you want to list the products of: " );

            for (Categories c : categories){
                if(c.getCategoryId() == preference) {
                    category = c;
                    break;
                }
            }
        }

        List<Product> products = productController.getProducts();

        System.out.println("----------------------------------------------\nPRODUCTS...\n----------------------------------------------");

        System.out.printf("| %1$-4s| %2$-20s| %3$-15s|%n","ID","PRODUCT NAME", "CATEGORY");

        for (Product p : products){
            if(p.getProductCategory().equals(category))
                System.out.printf("| %1$-4d| %2$-20s| %3$-15s| %n",p.getProductId(),p.getProductName(), p.getProductCategory().getCategoryName());
        }

        System.out.println("----------------------------------------------");

        categoryOperationsMenu();
    }

    public void addNewCategory(){
        System.out.print("Please enter the new category name : ");
        String name = scanner.nextLine();

        if(categoryController.getCategoryByName(name) != null){
            System.out.println("Category name (" + name + ") is already exist.");
        }
        else {
            categoryController.addNewCategory(name);

            System.out.println("New category \"" + name + "\" added.");
        }

        categoryOperationsMenu();
    }

    public void deleteCategory(){
        List<Categories> categories = categoryController.getCategories();

        if(categories.size() == 0){
            System.out.println("There is no category!");
            categoryOperationsMenu();
            return;
        }

        System.out.println("----------------------------\nCATEGORIES...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","CATEGORY NAME");

        for (Categories c : categories){
            System.out.printf("| %1$-4d| %2$-20s|%n",c.getCategoryId(),c.getCategoryName());
        }

        System.out.println("----------------------------");

        Categories category = null;
        while (category == null){
            int preference = getIntegerFromMinToMaxFromUser(0, categoryController.getLastCategoryId(),"Enter the category id you want to delete: " );

            for (Categories c : categories){
                if(c.getCategoryId() == preference) {
                    category = c;
                    break;
                }
            }
        }

        String repeatingMessage = "Category \"" + category.getCategoryName() + "\" and \"All Related Product\" will be deleted. Are you sure? (1-Yes, 2-No) : ";
        int selected = getIntegerFromMinToMaxFromUser(1,2, repeatingMessage);

        if(selected == 1){

            for (Product p : productController.getProducts()){
                if(p.getProductCategory().equals(category)){
                    p.setProductCategory(null);
                }
            }
            categoryController.deleteCategory(category);

            System.out.println("Category deleted.");

            productController.deleteUncategorizedProducts();
        }
        else {
            System.out.println("Deletion canceled...");
        }

        categoryOperationsMenu();
    }

    // CATEGORY OPERATIONS.....................

    // BRAND OPERATIONS........................
    private void brandOperationsMenu(){
        String str =
                "------------------------------\n" +
                        "Patika Store BRAND Operations!\n" +
                        "1- List All Brands,\n" +
                        "2- List Products By Brand,\n" +
                        "3- Add New Brand,\n" +
                        "4- Delete Brand,\n" +
                        "0- Back To Main Menu!\n" +
                        "------------------------------";
        System.out.println(str);

        int preference = getIntegerFromMinToMaxFromUser(0,4,"Your Preference: ");

        switch (preference)
        {
            case 1 -> listAllBrands();
            case 2 -> listProductsByBrand();
            case 3 -> addNewBrand();
            case 4 -> deleteBrand();
            case 0 -> storeMenu();
        }
    }
    private void listAllBrands(){
        List<Brands> brands = brandController.getBrands();

        if(brands.size() == 0){
            System.out.println("There is no brand!");
            brandOperationsMenu();
            return;
        }

        System.out.println("----------------------------\nBRANDS...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","BRAND NAME");

        for (Brands b : brands){
            System.out.printf("| %1$-4d| %2$-20s|%n",b.getBrandId(), b.getBrandName());
        }

        System.out.println("----------------------------");

        brandOperationsMenu();
    }

    private void listProductsByBrand(){
        List<Brands> brands = brandController.getBrands();

        if(brands.size() == 0){
            System.out.println("There is no brand!");
            brandOperationsMenu();
            return;
        }

        System.out.println("----------------------------\nBRANDS...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","BRAND NAME");

        for (Brands b : brands){
            System.out.printf("| %1$-4d| %2$-20s|%n",b.getBrandId(), b.getBrandName());
        }

        System.out.println("----------------------------");

        Brands brand = null;
        while (brand == null){
            int preference = getIntegerFromMinToMaxFromUser(0, brandController.getLastBrandId(),"Enter the brand id you want to list the products of: " );

            for (Brands b : brands){
                if(b.getBrandId() == preference) {
                    brand = b;
                    break;
                }
            }
        }

        List<Product> products = productController.getProducts();

        System.out.println("----------------------------------------------\nPRODUCTS...\n----------------------------------------------");

        System.out.printf("| %1$-4s| %2$-20s| %3$-15s|%n","ID","PRODUCT NAME", "CATEGORY");

        for (Product p : products){
            if(p.getProductBrand().equals(brand))
                System.out.printf("| %1$-4d| %2$-20s| %3$-15s| %n",p.getProductId(),p.getProductName(), p.getProductCategory().getCategoryName());
        }

        System.out.println("----------------------------------------------");

        brandOperationsMenu();
    }

    private void addNewBrand(){
        System.out.print("Please enter the new brand name : ");
        String name = scanner.nextLine();

        if(brandController.getBrandByName(name) != null){
            System.out.println("Brand name (" + name + ") is already exist.");
        }
        else {
            brandController.addNewBrand(name);

            System.out.println("New brand \"" + name + "\" added.");
        }

        brandOperationsMenu();
    }

    private void deleteBrand(){
        List<Brands> brands = brandController.getBrands();

        if(brands.size() == 0){
            System.out.println("There is no brand!");
            brandOperationsMenu();
            return;
        }

        System.out.println("----------------------------\nBRANDS...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","BRAND NAME");

        for (Brands b : brands){
            System.out.printf("| %1$-4d| %2$-20s|%n",b.getBrandId(), b.getBrandName());
        }

        System.out.println("----------------------------");

        Brands brand = null;
        while (brand == null){
            int preference = getIntegerFromMinToMaxFromUser(0, brandController.getLastBrandId(),"Enter the brand id you want to delete: " );

            for (Brands b : brands){
                if(b.getBrandId() == preference) {
                    brand = b;
                    break;
                }
            }
        }

        String repeatingMessage = "Brand \"" + brand.getBrandName() + "\" and \"All Related Product\" will be deleted. Are you sure? (1-Yes, 2-No) : ";
        int selected = getIntegerFromMinToMaxFromUser(1,2, repeatingMessage);

        if(selected == 1){

            for (Product p : productController.getProducts()){
                if(p.getProductBrand().equals(brand)){
                    p.setProductBrand(null);
                }
            }
            brandController.deleteBrand(brand);

            System.out.println("Brand deleted.");

            productController.deleteUnbrandedProducts();
        }
        else {
            System.out.println("Deletion canceled...");
        }

        brandOperationsMenu();
    }

    // BRAND OPERATIONS........................

    // PRODUCT OPERATIONS......................
    private void productOperationsMenu(){
        String str =
                "--------------------------------\n" +
                        "Patika Store PRODUCT Operations!\n" +
                        "1- List All Products,\n" +
                        "2- Add New Product,\n" +
                        "3- Delete Product,\n" +
                        "0- Back To Main Menu!\n" +
                        "--------------------------------";
        System.out.println(str);

        int preference = getIntegerFromMinToMaxFromUser(0,3,"Your Preference: ");

        switch (preference)
        {
            case 1 -> listAllProducts();
            case 2 -> addNewProduct();
            case 3 -> deleteProduct();
            case 0 -> storeMenu();
        }
    }

    private void listAllProducts(){
        List<Product> products = productController.getProducts();

        System.out.println("----------------------------\nPRODUCTS...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","PRODUCT NAME");

        for (Product p : products){
            System.out.printf("| %1$-4d| %2$-20s|%n",p.getProductId(),p.getProductName(),p.getRamCapacity());
        }

        System.out.println("----------------------------");

        productOperationsMenu();
    }

    private void addNewProduct(){
        //Scanner scanner = new Scanner(System.in);
        double price, discount;
        int stock;
        System.out.println("Enter the properties of the product you want to add.");

        System.out.print("Enter the product name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter the brand name: ");
        String brandName = scanner.nextLine().trim();

        System.out.print("Enter the category name: ");
        String categoryName = scanner.nextLine().trim();

        System.out.print("Enter the screen size : ");
        String screenSize = scanner.nextLine().trim();

        System.out.print("Enter the RAM capacity (GB) : ");
        String ramCapacity = scanner.nextLine().trim();

        System.out.print("Enter the internal storage capacity (GB) : ");
        String internalStorage = scanner.nextLine().trim();

        System.out.print("Enter the color : ");
        String color = scanner.nextLine().trim();

        System.out.print("Enter the battery capacity : ");
        String batteryCapacity = scanner.nextLine().trim();

        price = getDoubleFromMinToMaxFromUser(0,Double.MAX_VALUE,"Enter the sell price (only numeric value) : ");

        discount = getDoubleFromMinToMaxFromUser(0, 100, "Enter the discount (only numeric value between 0-100) : ");

        stock = getIntegerFromMinToMaxFromUser(0, Integer.MAX_VALUE, "Enter the stock quantity (Integer 0 and above only) : ");

        Brands brand = brandController.getBrandByName(brandName);
        if(brand == null){
            brand = brandController.addAndGetBrand(brandName);
        }

        Categories category = categoryController.getCategoryByName(categoryName);
        if(category == null){
            category = categoryController.addAndGetCategory(categoryName);
        }

        productController.addNewProduct(name,category,price,discount,stock,brand,internalStorage,screenSize,ramCapacity,color,batteryCapacity);

        productOperationsMenu();
    }

    private void deleteProduct(){
        List<Product> products = productController.getProducts();

        System.out.println("----------------------------\nPRODUCTS...\n----------------------------");

        System.out.printf("| %1$-4s| %2$-20s|%n","ID","PRODUCT NAME");

        for (Product p : products){
            System.out.printf("| %1$-4d| %2$-20s|%n",p.getProductId(),p.getProductName());
        }

        System.out.println("----------------------------");

        Product product = null;
        while (product == null){
            int preference = getIntegerFromMinToMaxFromUser(0, productController.getLastProductId(),"Enter the product id you want to delete: " );

            for (Product p : products){
                if(p.getProductId() == preference) {
                    product = p;
                    break;
                }
            }
        }

        String repeatingMessage = "Product \"" + product.getProductName() + "\" will be deleted. Are you sure? (1-Yes, 2-No) : ";
        int selected = getIntegerFromMinToMaxFromUser(1,2, repeatingMessage);

        if(selected == 1){

            productController.deleteProduct(product);

            System.out.println("Product deleted.");
        }
        else {
            System.out.println("Deletion canceled...");
        }

        productOperationsMenu();
    }

    // PRODUCT OPERATIONS......................








    private void exitTheProgram(){
        System.out.println("Exiting the program...");
    }

    private int getIntegerFromMinToMaxFromUser(int min, int max, String repeatingMessage){
        int selection;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print(repeatingMessage);
            try {
                selection = scanner.nextInt();
                if (selection >= min && selection <= max)
                    break;
                else System.out.println("Invalid entry!");
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!");
                scanner.next();
            }
        }
        return selection;
    }

    private double getDoubleFromMinToMaxFromUser(double min, double max, String repeatingMessage){
        double selection;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print(repeatingMessage);
            try {
                selection = scanner.nextDouble();
                if (selection >= min && selection <= max)
                    break;
                else System.out.println("Invalid entry!");
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!");
                scanner.next();
            }
        }
        return selection;
    }

}
