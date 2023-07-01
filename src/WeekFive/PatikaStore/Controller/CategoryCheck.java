package WeekFive.PatikaStore.Controller;

import WeekFive.PatikaStore.Path.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryCheck {
    private static List<Categories> categories = new ArrayList<>();
    private static int lastCategoryId;

    public CategoryCheck() {
        createDefaultObjects();
    }

    private void createDefaultObjects(){
        Categories cellphone = new Categories(++lastCategoryId, "Cellphone");
        Categories notebook = new Categories(++lastCategoryId, "Notebook");
        categories.add(cellphone);
        categories.add(notebook);
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public Categories getCategoryByName(String name){
        for(Categories category : categories)
        {
            if(category.getCategoryName().equalsIgnoreCase(name)) return category;
        }

        return null;
    }

    public int getLastCategoryId() {
        return lastCategoryId;
    }

    public void addNewCategory(String name){
        categories.add(new Categories(++lastCategoryId, name));
    }

    public Categories addAndGetCategory(String name){
        Categories category = new Categories(++lastCategoryId, name);
        categories.add(category);
        return category;
    }

    public void deleteCategory(Categories category){
        categories.remove(category);
    }
}
