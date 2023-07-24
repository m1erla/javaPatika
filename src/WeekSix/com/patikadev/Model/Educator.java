package WeekSix.com.patikadev.Model;

import WeekSix.com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Educator extends User{
    public static Educator getFetch(int id){
        Educator obj = null;
        String query = "SELECT * FROM users WHERE user_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Educator();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("user_password"));
                obj.setTypee(rs.getString("user_typee"));

            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return obj;
    }
}
