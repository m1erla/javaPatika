package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.DBConnector;
import WeekSix.com.patikadev.Helper.Helper;
import WeekSix.com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentGUI extends JFrame{
    private JPanel wrapper;
    private JTable tbl_student;
    private JPanel jpanel_1;
    private JPanel jpanel_2;
    private JTextField txt_patika_add;
    private JTextField txt_course_add;
    private JTextField txt_lang_add;
    private JTextField txt_educator_add;
    private JTextField txt_patika_id;
    private JButton btn_registration;
    private JTabbedPane tabbedPane1;
    private JTextField txt_youtube_area;
    private JTextArea txt_description_area;
    private JTextArea txt_quiz_area;
    private JTextField txt_assessment;
    private JButton btn_send;
    private JTable tbl_course_list;
    private JButton btn_logout;
    private DefaultTableModel mdl_list;
    private DefaultTableModel mdl_course;
    private Object[] row_course;
    private Object[] row_patika_list;
    private Student student;
    private User user;
    private int patikaId;
    private int userId;


    public StudentGUI(){
        add(wrapper);
        setSize(1000,1000);
        setLocation(Helper.screenSize("x", getSize()), Helper.screenSize("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        mdl_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                if (column == 0)
                    return false;

                return super.isCellEditable(row , column);
            }
        };
        Object[] col_patika_list = {"ID", "Patika Name", "Course Name", "Programming Language", "Educator"};
        mdl_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        loadCourseModel();
        tbl_student.setModel(mdl_list);
        tbl_student.getTableHeader().setReorderingAllowed(false);
        tbl_student.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_student.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_student.rowAtPoint(point);
                int selected_col = tbl_student.columnAtPoint(point);
                tbl_course_list.setRowSelectionInterval(selected_row,selected_col);
                int isJoin = checkPatika(userId,patikaId);
                if (isJoin != 0){
                    Patika.getPatikaList();
                    dispose();
                }else {
                    Helper.showMsg("If you want to see that your content then you should have regestration a patika");
                }
            }
        });

        mdl_course = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_course = {"ID", "Patika Name", "Course Name", "Programming Language", "Educator"};
        mdl_course.setColumnIdentifiers(col_course);
        row_course = new Object[col_course.length];
        tbl_course_list.setModel(mdl_course);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(100);

        tbl_course_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_course_list.rowAtPoint(point);
                tbl_course_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });
       // Object[] col_content = {"ID", "Content Name" , "Content Description", "Content Quiz"};
        loadStudentModel();
        loadCourseModel();
        loadPatikaModel();


        tbl_student.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_id = tbl_student.getValueAt(tbl_student.getSelectedRow(), 0).toString();
                String select_patika = tbl_student.getValueAt(tbl_student.getSelectedRow(), 1).toString();
                String select_course = tbl_student.getValueAt(tbl_student.getSelectedRow(), 2).toString();
                String select_lang = tbl_student.getValueAt(tbl_student.getSelectedRow(), 3).toString();
                String select_educator = tbl_student.getValueAt(tbl_student.getSelectedRow(), 4).toString();
                txt_patika_id.setText(select_id);
                txt_patika_add.setText(select_patika);
                txt_course_add.setText(select_course);
                txt_lang_add.setText(select_lang);
                txt_educator_add.setText(select_educator);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        });
        btn_registration.addActionListener(e -> {
          if (ContentStudent.addLesson(txt_patika_add.getText() , txt_course_add.getText() , txt_lang_add.getText(), txt_description_area.getText(),txt_youtube_area.getText(),txt_quiz_area.getText())){
              Helper.showMsg("success");

              txt_patika_add.setText(null);
              txt_course_add.setText(null);
              txt_lang_add.setText(null);
              txt_description_area.setText(null);
              txt_youtube_area.setText(null);
              txt_quiz_area.setText(null);
              txt_educator_add.setText(null);
              txt_patika_id.setText(null);

          }else
              Helper.showMsg("error");
        });
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI log = new LoginGUI();
        });
        btn_send.addActionListener(e -> {
        if (Helper.isFieldEmpty(txt_assessment) || Helper.isAreaEmpty(txt_description_area) || Helper.isAreaEmpty(txt_quiz_area)){
            Helper.showMsg("Your answers and assessment have been send to the educator!");
            txt_assessment.setText(null);
            txt_description_area.setText(null);
            txt_quiz_area.setText(null);
        }
    });
        loadCourseModel();
    }
    public void loadStudentModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Course obj : Course.getCourseList()){
            i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getPatika().getName();
            row_patika_list[i++] = obj.getName();
            row_patika_list[i++] = obj.getLanguage();
            row_patika_list[i++] = obj.getEducator().getName();

            mdl_list.addRow(row_patika_list);
        }
    }

    public void loadCourseModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Course obj : Course.getCourseList()){
            if (obj.getPatika_id() == patikaId){
                i = 0;
                row_course[i++] = obj.getName();
                mdl_course.addRow(row_course);
        }
    }
        int isJoin = checkPatika(userId,patikaId);
        if (isJoin != 0){
            btn_registration.setText("You join to patika");
        }
    }
    private void loadPatikaModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Patika obj : Patika.getPatikaList()){
            i = 0;
            row_patika_list[i++] = obj.getName();
            mdl_list.addRow(row_patika_list);
        }
    }

    private boolean registerPatika(int userId , int patikaId){
        String query = "INSERT INTO course (user_id, patika_id) VALUES (?, ?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,userId);
            pr.setInt(2,patikaId);
            return pr.executeUpdate() != -1;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return true;
    }

    private int checkPatika(int userId, int patikaId){
        String query = "SELECT * FROM course WHERE user_id = " + userId + "AND patika_id " + patikaId;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                return rs.getInt("patika_id");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return 1;
    }
}
