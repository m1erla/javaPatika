package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.Helper;
import WeekSix.com.patikadev.Model.Controller;
import WeekSix.com.patikadev.Model.Patika;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatikaGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txt_patika_name;
    private JButton btn_update_btn;
    private Patika patika;
    public UpdatePatikaGUI(Patika patika){
        this.patika = patika;
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenSize("x",getSize()), Helper.screenSize("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        txt_patika_name.setText(patika.getName());
        btn_update_btn.addActionListener(e -> {
            if (Helper.isFieldEmpty(txt_patika_name)){
                Helper.showMsg("fill");
            }else{
                if (Patika.addUpdatePatika(patika.getId(), txt_patika_name.getText())){
                    Helper.showMsg("success");

                }
                dispose();
            }
        });
    }
}
