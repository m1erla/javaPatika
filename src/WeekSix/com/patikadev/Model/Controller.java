package WeekSix.com.patikadev.Model;


import WeekSix.com.patikadev.Helper.DBConnector;
import WeekSix.com.patikadev.Helper.Helper;


import java.sql.*;
import java.util.ArrayList;


public class Controller extends User{

    public static ArrayList<User> searchUserList(String query)  {
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userList;
    }
   public static String searchQuery(String name, String userName, String type){
        String query = "SELECT * FROM users WHERE user_name LIKE '%"+userName+"%' AND name LIKE '%"+name+"%' AND user_typee LIKE '%"+type+"%'";
//
        return query;
   }




}
