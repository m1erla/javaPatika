package WeekFive.PatikaStore.Controller;

import WeekFive.PatikaStore.Path.Brands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BrandCheck {
    private static List<Brands> brands = new ArrayList<>();
    private static int lastBrandId;

    public BrandCheck() {
        defaultBrands();
    }

    private void defaultBrands(){
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};

        for (String name : brandNames)
        {
            brands.add(new Brands(++lastBrandId, name));
        }
    }

    public Brands getBrandByName(String name)
    {
        for (Brands brand : brands)
        {
            if(brand.getBrandName().equalsIgnoreCase(name)) return brand;
        }

        return null;
    }

    public List<Brands> getBrands() {
        Collections.sort(brands);
        return brands;
    }

    public int getLastBrandId() {
        return lastBrandId;
    }

    public void addNewBrand(String name){
        brands.add(new Brands(++lastBrandId, name));
    }

    public void deleteBrand(Brands brand){
        brands.remove(brand);
    }

    public Brands  addAndGetBrand(String name){
        Brands brand = new Brands(++lastBrandId, name);
        brands.add(brand);
        return brand;
    }
}
