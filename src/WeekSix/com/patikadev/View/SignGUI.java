package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.DBConnector;
import WeekSix.com.patikadev.Helper.Helper;
import WeekSix.com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class SignGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txt_user_name;
    private JTextField txt_password;
    private JTextField txt_full_name;
    private JTextField txt_email;
    private JButton btn_sign;

    public SignGUI(){
        add(wrapper);
        setSize(600,600);
        setLocation(Helper.screenSize("x",getSize()),Helper.screenSize("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_sign.addActionListener(e -> {
           String fullName = txt_full_name.getText();
           String userName = txt_user_name.getText();
           String email = txt_email.getText();
           String password = txt_password.getText();

           if (Helper.isFieldEmpty(txt_full_name) || Helper.isFieldEmpty(txt_user_name) || Helper.isFieldEmpty(txt_email) || Helper.isFieldEmpty(txt_password)){
               Helper.showMsg("fill");
           }else {
               if (isEmail(email) && addStudent(fullName,userName,password)){
                   LoginGUI log = new LoginGUI();
                   dispose();
               }
           }
        });
    }
    private boolean isEmail(String email){
        if (email.contains("@gmail.com") || email.contains("@icloud.com") || email.contains("@hotmail.com") || email.contains("@outlook.com")){
            return true;
        }else {
            Helper.showMsg("Please enter a correct email!");
            return false;
        }
    }


    private boolean addStudent(String fullName, String userName, String password ){
        String query = "INSERT INTO users (name, user_name, user_password, user_typee) VALUES (?, ?, ?, ?)";
        User find = User.getFetch(userName);
        if (find != null){
            Helper.showMsg("This user already taken. Please try another user!");
            return false;
        }else {
            Helper.showMsg("success");
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,fullName);
            pr.setString(2,userName);
            pr.setString(3,password);
            pr.setObject(4,"student");
            return pr.executeUpdate() != -1;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return true;
    }


}
