package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JPanel wrapper;
    private JButton btn_operator;
    private JButton btn_educator;
    private JButton btn_student;

    public GUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenSize("x",getSize()),Helper.screenSize("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        btn_operator.addActionListener(e -> {
            LoginGUI log = new LoginGUI();
            dispose();
        });
        btn_educator.addActionListener(e -> {
            LoginGUI log = new LoginGUI();
            dispose();
        });
        btn_student.addActionListener(e -> {
            LoginGUI log = new LoginGUI();
            dispose();
        });

    }

    public static void main(String[] args) {
        Helper.setLayout();
        GUI gui = new GUI();
    }
}
