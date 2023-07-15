package WeekSix.com.patikadev.Model;


import WeekSix.com.patikadev.Helper.DBConnector;



import java.sql.*;
import java.util.ArrayList;


public class Controller extends User{

    public static ArrayList<User> searchUserList(String queryies)  {
        ArrayList<User> userList = new ArrayList<>();
        String prepQuery = "SELECT * FROM users WHERE name LIKE '%{{name}}%' AND user_name LIKE '%{{user_name}}%'";
        User obj;
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(prepQuery);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                obj = new User();
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setTypee(rs.getString("user_typee"));
                userList.add(obj);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return userList;
    }
   public static String searchQuery(String name, String userName, String type){
        String query = "SELECT * FROM users WHERE name LIKE '%{{name}}%' AND user_name LIKE '%{{user_name}}%'";
        query = query.replace("{{name}}",name);
        query = query.replace("{{user_name}}",userName);
        if (!type.isEmpty()){
            query += "AND user_typee = '{{user_typee}}'";
            query = query.replace("{{user_typee}}", type);
        }
        return query;
   }



}
