package WeekSix.com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }
    public static int screenSize(String axis, Dimension size){
        int position;
        switch (axis){
            case "x" :
                position = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y" :
                position = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                position = 0;
        }
        return position;
    }

    public static void showMsg(String str){
        String msg;
        String title;

        switch (str){
            case "fill":
                msg = "Please fill up to all spaces";
                title = "Error!";
                break;
            case "success":
                msg = "Process completed successfully";
                title = "Success";
                break;
            case "error":
                msg = "Something went wrong!";
                title = "Error!";
                break;
            default:
                msg = str;
                title = "Message";
        }
   JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confrim(String str){
        String msg;

        switch (str){
            case "sure":
                msg = "Are you sure about this delete action?";
                break;
            default:
                msg = str;
        }
       return JOptionPane.showConfirmDialog(null,msg,"Last choices ?", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
    public static boolean isAreaEmpty(JTextArea area){
        return area.getText().trim().isEmpty();
    }
}
