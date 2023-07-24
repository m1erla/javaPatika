package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.Helper;
import WeekSix.com.patikadev.Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txt_user_login;
    private JPanel wtop;
    private JPanel wbottom;
    private JPasswordField txt_password_login;
    private JButton btn_login;
    private JButton signInButton;

    public LoginGUI(){
        add(wrapper);
        setSize(600,600);
        setLocation(Helper.screenSize("x", getSize()), Helper.screenSize("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(txt_user_login) || Helper.isFieldEmpty(txt_password_login)){
                Helper.showMsg("fill");
            }else {
                User user =User.getFetch(txt_user_login.getText(), txt_password_login.getText());
                if (user == null){
                    Helper.showMsg("User Has Not Been Found");
                }else {
                switch (user.getTypee()){
                    case "operator":
                        OperatorGUI op = new OperatorGUI((Operator) user);
                        break;
                    case "educator":
                        EducatorGUI ed = new EducatorGUI();
                        break;
                    case "student":
                        StudentGUI st = new StudentGUI();
                        break;
                }
                dispose();
                }
            }
        });
        signInButton.addActionListener(e -> {
            SignGUI sign = new SignGUI();

        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI log = new LoginGUI();

    }
}
