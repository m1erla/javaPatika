package WeekFive.PatikaStore;
import WeekFive.PatikaStore.Controller.BrandCheck;
import WeekFive.PatikaStore.Controller.CategoryCheck;
import WeekFive.PatikaStore.Controller.ProductCheck;
import WeekFive.PatikaStore.Path.Categories;
import WeekFive.PatikaStore.Store.HeadQuarter;

import static WeekFive.PatikaStore.ControlPanel.*;
public class Main {
    public static void main(String[] args) {
        CategoryCheck categoryController = new CategoryCheck();
        BrandCheck brandController = new BrandCheck();
        ProductCheck productController = new ProductCheck(categoryController, brandController);
        HeadQuarter patikaStore = new HeadQuarter(categoryController, brandController, productController);
        patikaStore.storeMenu();
    }
}
