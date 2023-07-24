package WeekSix.com.patikadev.View;

import WeekSix.com.patikadev.Helper.Config;
import WeekSix.com.patikadev.Helper.Helper;
import WeekSix.com.patikadev.Helper.Item;
import WeekSix.com.patikadev.Model.Content;
import WeekSix.com.patikadev.Model.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JTable tbl_educator_list;
    private Object[] row_course_list;
    private DefaultTableModel mdl_educator_list;

    private JTabbedPane tbd_panel;
    private JTextField txt_lesson_filter;
    private JPopupMenu educatorMenu;
    private JButton btn_filter;
    private JTextField txt_content_title;
    private JTextArea txt_description;
    private JTextField txt_youtube_link;
    private JTextArea txt_quiz;
    private JComboBox cbx_content;
    private JTextField txt_content_title_filter;
    private JButton btn_content_add;
    private JTable tbl_educator;
    private JTextArea txt_descrip_area;
    private JTextArea txt_quiz_area;
    private JTextArea txt_asses_area;
    private DefaultTableModel mdl_educator_table;
public EducatorGUI( ){
    add(wrapper);
    setSize(1000,1000);
    setLocation(Helper.screenSize("x", getSize()), Helper.screenSize("y", getSize()));
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle(Config.PROJECT_TITLE);
    setResizable(false);
    setVisible(true);
    mdl_educator_table = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 0)
                return false;
            return super.isCellEditable(row, column);
        }
    };
    mdl_educator_list = new DefaultTableModel();
    Object[] col_educator_list = {"ID", "Course Name", "Programming Language", "Patika"};
    mdl_educator_list.setColumnIdentifiers(col_educator_list);
    row_course_list = new Object[col_educator_list.length];
    tbl_educator_list.setComponentPopupMenu(educatorMenu);
    tbl_educator_list.setModel(mdl_educator_list);
    tbl_educator_list.getColumnModel().getColumn(0).setMaxWidth(100);
    tbl_educator_list.getTableHeader().setReorderingAllowed(false);
    tbl_educator_list.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            Point point = e.getPoint();
            int selected_row = tbl_educator_list.rowAtPoint(point);
            tbl_educator_list.setRowSelectionInterval(selected_row,selected_row);
        }
    });
    loadEducatorModel();
    btn_filter.addActionListener(e -> {

    });
    btn_content_add.addActionListener(e -> {
        if (Helper.isFieldEmpty(txt_content_title) || Helper.isAreaEmpty(txt_description) || Helper.isAreaEmpty(txt_quiz) || Helper.isFieldEmpty(txt_youtube_link)){
            Helper.showMsg("fill");
        }else {
            String content = txt_content_title.getText();
            String description = txt_description.getText();
            String youtube = txt_youtube_link.getText();
            String quiz = txt_quiz.getText();
            String type = cbx_content.getSelectedItem().toString();
            if (Content.contentAdd(content, description ,quiz,youtube,type)){
                Helper.showMsg("success");
                txt_content_title.setText(null);
                txt_description.setText(null);
                txt_quiz.setText(null);
            }

        }
    });
}
public void loadEducatorModel(){
    DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_list.getModel();
    clearModel.setRowCount(0);
    int i = 0;
    int id = 0;
    for (Course obj : Course.getCourseListByUser(id)){
        i = 0;
        row_course_list[i++] = obj.getId();
        row_course_list[i++] = obj.getName();
        row_course_list[i++] = obj.getLanguage();
        row_course_list[i++] = obj.getPatika().getName();
        mdl_educator_list.addRow(row_course_list);

    }

}
public void loadContentTitleCombo(){
    cbx_content.removeAllItems();
    String title = cbx_content.getSelectedItem().toString();
    int id = Course.getCourseID(title);
    for (Course obj : Course.getCourseListByUser(id)){
        cbx_content.addItem(new Item(obj.getId(),obj.getName()));
    }
}

}
