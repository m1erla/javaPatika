package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.Helper;

import javax.swing.*;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
public EducatorGUI(){
    add(wrapper);
    setSize(400,400);
    setLocation(Helper.screenSize("x", getSize()), Helper.screenSize("y", getSize()));
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle(Config.PROJECT_TITLE);
    setResizable(false);
    setVisible(true);
}

}
