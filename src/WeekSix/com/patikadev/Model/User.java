package WeekSix.com.patikadev.Model;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.DBConnector;
import WeekSix.com.patikadev.Helper.Helper;

import java.sql.*;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String typee;

    private String title;
    private String department;
    private int wages;
    private String statement;
    private String address;
    private String priorities;
    public User(){}
    public User(int id, String name, String userName, String password, String typee) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.typee = typee;

     }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypee() {
        return typee;
    }

    public void setTypee(String typee) {
        this.typee = typee;
    }
    public static ArrayList<User> getUserList()  {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        String preparedQuery = "INSERT INTO users (name, user_name, user_password, user_typee) VALUES (?, ?, ?, ?)";
        Connection dbConnect = null;

        try {
            Class.forName(Config.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        User obj;

        try {
            dbConnect = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
            //Statement st = DBConnector.getInstance().createStatement();
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(preparedQuery);
            ResultSet rs = pr.executeQuery(query);


            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));
                userList.add(obj);
            }
            dbConnect.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return userList;
    }
    public static ArrayList<User> getOnlyEducator()  {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users WHERE user_typee = 'educator'";
        String preparedQuery = "INSERT INTO users (name, user_name, user_password, user_typee) VALUES (?, ?, ?, ?)";
        Connection dbConnect = null;

        try {
            Class.forName(Config.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        User obj;

        try {
            dbConnect = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
            //Statement st = DBConnector.getInstance().createStatement();
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(preparedQuery);
            ResultSet rs = pr.executeQuery(query);


            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));
                userList.add(obj);
            }
            dbConnect.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return userList;
    }
    public static boolean add(String name, String userName, String password, String typee){
        String query = "INSERT INTO users (name, user_name, user_password, user_typee) VALUES (?, ?, ?, ?)";
        User findUser = Controller.getFetch(userName);
        if (findUser != null){
            Helper.showMsg("This user already exist! Please try another user for add!");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,userName);
            pr.setString(3,password);
            pr.setString(4,typee);
            int response = pr.executeUpdate();
            if (response == -1){
                Helper.showMsg("error");
            }
            return response != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return true;
    }

    public static User getFetch(String userName){
        User obj = null;
        String query = "SELECT * FROM users WHERE user_name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,userName);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static User getFetch(String userName, String password){
        User obj = null;
        String query = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,userName);
            pr.setString(2,password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                switch (rs.getString("user_typee")){
                    case "operator":
                        obj = new Operator();
                        break;
                    default:
                        obj = new User();
                }
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static User getFetch(int id){
        User obj = null;
        String query = "SELECT * FROM users WHERE user_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static boolean deleteUser(int id){
        String query = "DELETE FROM users WHERE user_id = ?";
        ArrayList<Course> courseList = Course.getCourseListByUser(id);
        for (Course c : courseList){
            Course.deleteCourse(c.getId());
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() == -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean update(int id, String name, String userName, String password, String typee){
        String query = "UPDATE users SET name = ?, user_name = ?, user_password = ?, user_typee = ? WHERE user_id = ?";
        User findUser = User.getFetch(userName);

        if (findUser != null && findUser.getId() != id){
            Helper.showMsg("The user name already exist! try another!");
            return false;
        }
        if (typee != null && !typee.isEmpty()){
            Helper.showMsg("You cannot chance type!");
            return false;
        }
        try {

            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,userName);
            pr.setString(3,password);
            pr.setString(4,typee);
            pr.setInt(5,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
