package WeekSix.com.patikadev.Model;

import WeekSix.com.patikadev.Helper.DBConnector;
import WeekSix.com.patikadev.Helper.Helper;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private String content_title;
    private String content_des;
    private String content_quiz;
    private String lesson_info;
    private String content_youtube;
    private Patika patika;
    private User user;
    private String patik;

    public Content(){

    }

    public Content(int id, String contentTitle, String contentDes, String contentQuiz, String lessonInfo, String contentYoutube ) {
        this.id = id;
        this.content_title = contentTitle;
        this.content_des = contentDes;
        this.content_quiz = contentQuiz;
        this.lesson_info = lessonInfo;
        this.content_youtube = contentYoutube;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getContent_des() {
        return content_des;
    }

    public void setContent_des(String content_des) {
        this.content_des = content_des;
    }

    public String getContent_quiz() {
        return content_quiz;
    }

    public void setContent_quiz(String content_quiz) {
        this.content_quiz = content_quiz;
    }

    public String getLesson_info() {
        return lesson_info;
    }

    public void setLesson_info(String lesson_info) {
        this.lesson_info = lesson_info;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static boolean contentAdd(String contentTitle, String contentDes,String contentQuiz, String lessonInfo,String contentYoutube){
        String query = "INSERT INTO content (content_title, content_description, lesson_info, content_youtube, content_quiz) VALUES (?, ?, ?, ?, ?)";
        Content find = getFetch(contentTitle);
        if (find != null){
            Helper.showMsg("This content title cannot be the same as the already exist title");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,contentTitle);
            pr.setString(2,contentDes);
            pr.setString(3,contentQuiz);
            pr.setString(3,lessonInfo);
            pr.setString(4,contentYoutube);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean deleteContent(int id){
        String query = "DELETE FROM content WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() == -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Content getFetch(String title){
        Content obj = null;
        String query = "SELECT * FROM content WHERE content_title = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,title);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Content(rs.getInt("id"), rs.getString("content_title"),rs.getString("content_description"),rs.getString("content_quiz"),rs.getString("lesson_info"),rs.getString("content_youtube"));
            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return obj;
    }

    public static ArrayList<Content> getContentList(int contentID){
        ArrayList<Content> courseList = new ArrayList<>();
        Content obj;
        String query = "SELECT * FROM content WHERE id" + contentID;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String contentTitle = rs.getString("content_title");
                String contentDes = rs.getString("content_description");
                String contentQuiz = rs.getString("content_quiz");
                String lessonInfo = rs.getString("lesson_info");
                String contentYoutube = rs.getString("content_youtube");
                obj = new Content(id, contentTitle, contentDes, contentQuiz, lessonInfo, contentYoutube);
                courseList.add(obj);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return courseList;
    }

    public static ArrayList<Content> getContentList(String contentTitle){
        ArrayList<Content> courseList = new ArrayList<>();
        Content obj;
        String query = "SELECT * FROM content WHERE content_title = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,contentTitle);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("content_title");
                String contentDes = rs.getString("content_description");
                String contentQuiz = rs.getString("content_quiz");
                String lessonInfo = rs.getString("lesson_info");
                String contentYoutube = rs.getString("content_youtube");
                obj = new Content(id, title, contentDes, contentQuiz, lessonInfo, contentYoutube);
                courseList.add(obj);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return courseList;
    }
    public static ArrayList<Content> searchContentTitle(String title, int id){
        String query = "SELECT * FROM content WHERE content_title ILIKE '%{{"+title+"}}%' AND course_id = " + id;
        query = query.replace("{{content_title}}",title);
        ArrayList<Content> contentList = new ArrayList<>();
        Content obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new Content(rs.getInt("id"),rs.getString("content_title"),rs.getString("content_description"),rs.getString("content_quiz"),rs.getString("lesson_info"),rs.getString("content_youtube"));
                contentList.add(obj);
            }
    }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return contentList;
    }

    public static boolean addQuiz(String title , String quiz){
        String query = "UPDATE content SET content_quiz = ? WHERE content_title = ? ";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,quiz);
            pr.setString(2,title);
            return pr.executeUpdate() != -1;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return true;
    }
}
