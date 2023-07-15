package WeekSix.com.patikadev.Model;

import WeekSix.com.patikadev.Helper.DBConnector;
import WeekSix.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;
    public Patika(){

    }
    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

    }
    public int getId(){
        return id;

    }
    public void setId(int id){
        this.id = id;
    }
    public static ArrayList<Patika> getPatikaList(){
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patika");
            while (rs.next()){
                obj = new Patika(rs.getInt("id"), rs.getString("name"));
                patikaList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patikaList;
    }
    public static boolean addPatika(String name){
        String query = "INSERT INTO patika (name) VALUES (?)";
        Patika findPatika = Patika.getName(name);
        if (findPatika != null){
            Helper.showMsg("This patika already exist! Please try another patika for add!");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);

            int response = pr.executeUpdate();
            if (response == -1){
                Helper.showMsg("error");
            }
            return response != -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean addUpdatePatika(int id, String name){
        String query = "UPDATE patika SET name = ? WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setInt(2,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean deletePatika(int id ){
        String query = "DELETE FROM patika WHERE id = ?";
        ArrayList<Course> courseList = new ArrayList<>();
        for (Course obj : courseList){
            if (obj.getPatika().getId() == id){
                Course.deleteCourse(obj.getId());
            }
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() == -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Patika getName(String name){
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static Patika getId(int id){
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }

}
