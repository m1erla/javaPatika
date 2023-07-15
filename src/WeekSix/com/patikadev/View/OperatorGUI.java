package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.*;
import WeekSix.com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class OperatorGUI extends JFrame {
//    // Defined Attributes

    private JPanel wrapper;
    private JTabbedPane tab_patika;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private final Operator operator;
    private  DefaultTableModel mdl_user_list;
    private DefaultTableModel mdl_patika_list;

    private Object[] row_patika_list;
    private static Object[] row_user_list;
    private  JTable tbl_user_list;
    private JPanel pnl_user;
    private JLabel lbl_name;
    private JTextField txt_name;
    private JTextField txt_user_name;
    private JPasswordField password;
    private JComboBox cbx_type;
    private JLabel lbl_user_name;
    private JLabel lbl_password;
    private JLabel lbl_type;
    private JButton btn_user_add;
    private JTextField txt_password;
    private JTextField txt_user_id;
    private JButton btn_delete;
    private JTextField txt_search_name;
    private JTextField txt_search_user_name;
    private JButton btn_search;
    private JLabel lbl_search_user_full_name;
    private JLabel lbl_search_user_name;
    private JLabel lbl_search_type;
    private JComboBox cbx_search_type;
    private JScrollPane scroll_patika;
    private JTable tbl_patika_list;
    private JTextField txt_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_course_list;
    private JPanel pnl_patika_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField txt_course_name;
    private JLabel lbl_course_name;
    private JTextField txt_course_lang;
    private JLabel lbl_course_lang;
    private JComboBox cbx_course_patika;
    private JComboBox cbx_course_educator;
    private JButton btn_course_add;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    // Created Constructor
    public OperatorGUI(Operator operator){
        this.operator = operator;
        add(wrapper);
        setSize(1000,1000);
        setLocation(Helper.screenSize("x", getSize()), Helper.screenSize("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Welcome " + operator.getName());
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;

                return super.isCellEditable(row, column);
            }
        };
        // Model User List
        Object[] col_user_list = {"ID"," Name ", "User Name ", "Password", "Membership Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];

        loadUserModel();

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
        tbl_user_list.getColumnModel().getColumn(0).setMaxWidth(100);

        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                txt_user_id.setText(select_id);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }

        });
        tbl_user_list.getModel().addTableModelListener(e ->{
            if (e.getType() == TableModelEvent.UPDATE){
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),1).toString();
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),2).toString();
                String user_password = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),4).toString();
                if (Controller.update(user_id, name, user_name, user_password , user_type)){
                    Helper.showMsg("success");
                    loadUserModel();
//                    loadEducatorCombo();
//                    loadCourseModel();
//                    loadPatikaCombo();
//                    loadPatikaModel();
                }


            }
        });
        // ##
        // Model Patika List
        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Update");
        JMenuItem deleteMenu = new JMenuItem("Delete");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);
        updateMenu.addActionListener(e -> {
            int select_row_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(),0).toString());
            UpdatePatikaGUI updateGUI = new UpdatePatikaGUI(Patika.getId(select_row_id));
            updateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadCourseModel();

                }
            });
        });
        deleteMenu.addActionListener(e -> {
            if (Helper.confrim("sure")) {
                int select_row_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                if (Patika.deletePatika(select_row_id)){
                    Helper.showMsg("error");
                }else{
                    Helper.showMsg("success");
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadCourseModel();

                }
            }
        });
        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika_list = {"ID", "Patika Name"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        loadPatikaModel();
        loadPatikaCombo();
        loadEducatorCombo();
        // ##
        // Model Course List
        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"ID", "Course Name", "Programming Language", "Patika", "Educator"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadCourseModel();

        // ##
        btn_user_add.addActionListener(e -> {
                if (Helper.isFieldEmpty(txt_name) || Helper.isFieldEmpty(txt_user_name) || Helper.isFieldEmpty(txt_password)){
                 Helper.showMsg("fill");
                }else {
                    String name = txt_name.getText();
                    String userName = txt_user_name.getText();
                    String password = txt_password.getText();
                    String type = cbx_type.getSelectedItem().toString();
                    if (Controller.add(name, userName, password, type)){
                        Helper.showMsg("success");
                        loadUserModel();
                        loadCourseModel();
                        txt_name.setText(null);
                        txt_user_name.setText(null);
                        txt_password.setText(null);
                    }
                }
        });

        btn_delete.addActionListener(a -> {
                if (Helper.isFieldEmpty(txt_user_id)){
                    Helper.showMsg("fill");
                }else {
                   if (Helper.confrim("sure")){
                       int user_id = Integer.parseInt(txt_user_id.getText());
                       if (Controller.deleteUser(user_id)){

                           Helper.showMsg("error");

                       }else {
                           Helper.showMsg("success");
                           loadUserModel();
                           loadEducatorCombo();
                           loadCourseModel();
                           txt_user_id.setText(null);
                       }
                   }
                }
        });
        btn_search.addActionListener(e -> {
            String name = txt_search_name.getText();
            String userName = txt_search_user_name.getText();
            String type = cbx_search_type.getSelectedItem().toString();
            String query = Controller.searchQuery(name, userName, type);
            loadUserModel(Controller.searchUserList(query));

        });
        btn_logout.addActionListener(e -> {
            dispose();
        });

        btn_patika_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(txt_patika_name)){
                Helper.showMsg("fill");
            }else {
                if (Patika.addPatika(txt_patika_name.getText())){
                    Helper.showMsg("success");
                    loadPatikaModel();
                    loadPatikaCombo();
                    txt_patika_name.setText(null);
                }else {
                    Helper.showMsg("error");
                }



            }
        });
        btn_course_add.addActionListener(e -> {
            Item patikaItem = (Item) cbx_course_patika.getSelectedItem();
            Item userItem = (Item) cbx_course_educator.getSelectedItem();
            if (Helper.isFieldEmpty(txt_course_name) || Helper.isFieldEmpty(txt_course_lang)){
                Helper.showMsg("fill");
            }else{
                if (Course.addCourse(userItem.getKey(), patikaItem.getKey(), txt_course_name.getText(), txt_course_lang.getText())){
                    Helper.showMsg("success");
                    loadCourseModel();
                    loadEducatorCombo();
                    txt_course_lang.setText(null);
                    txt_course_name.setText(null);
                }else {
                    Helper.showMsg("error");
                }
            }
        });
    }
    // Created Methods
    private void loadPatikaModel() {
         DefaultTableModel cleanModel = (DefaultTableModel) tbl_patika_list.getModel();
         cleanModel.setRowCount(0);
         int i;
         for (Patika obj : Patika.getPatikaList()){
             i = 0;
             row_patika_list[i++] = obj.getId();
             row_patika_list[i++] = obj.getName();
             mdl_patika_list.addRow(row_patika_list);
         }
    }

    public void loadUserModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : Controller.getUserList()){
            i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUserName();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getTypee();

            mdl_user_list.addRow(row_user_list);
        }
    }

    public void loadUserModel(ArrayList<User> list){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        for (User obj : Controller.getUserList()){
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUserName();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getTypee();

            mdl_user_list.addRow(row_user_list);
        }
    }
    public void loadCourseModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getCourseList()){
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLanguage();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }

    }
    public void loadPatikaCombo(){
        cbx_course_patika.removeAllItems();
        for (Patika obj : Patika.getPatikaList()){
            cbx_course_patika.addItem(new Item(obj.getId(),obj.getName()));
        }

    }
    public void loadEducatorCombo(){
        cbx_course_educator.removeAllItems();
        for (User obj : Controller.getOnlyEducator()){
                cbx_course_educator.addItem(new Item(obj.getId(),obj.getName()));
        }
    }
    public static void main(String[] args) {
        Helper.setLayout();

        Operator op = new Operator();
        DBConnector.getInstance();
        OperatorGUI operatorGUI = new OperatorGUI(op);

    }
}
