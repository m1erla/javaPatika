package WeekSix.com.patikadev.Model;

import WeekSix.com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContentStudent {

    private int id;
    private int userId;
    private int patikaId;
    private String descrip;
    private String youtube;
    private String quiz;
    private String patikaName;
    private String courseName;
    private String lang;
    private User educator;
    private Patika patika;
    public ContentStudent(){

    }
    public ContentStudent(int id, String patikaName, String courseName, String lang, String descrip, String youtube, String quiz) {
        this.id = id;
        this.patikaName = patikaName;
        this.courseName = courseName;
        this.lang = lang;
        this.descrip = descrip;
        this.youtube = youtube;
        this.quiz = quiz;
        this.educator = User.getFetch(userId);
        this.patika = Patika.getId(patikaId);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatikaName() {
        return patikaName;
    }

    public void setPatikaName(String patikaName) {
        this.patikaName = patikaName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }
    public static boolean addLesson(String patikaName, String courseName, String lang, String descrip, String youtube, String quiz){
        String query = "INSERT INTO student_content (patika_name, course_name, language, description, youtube, quiz) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,patikaName);
            pr.setString(2,courseName);
            pr.setString(3,lang);
            pr.setString(4,descrip);
            pr.setString(5,youtube);
            pr.setString(6,quiz);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<ContentStudent> getList(int courseId){
        ArrayList<ContentStudent> courseList = new ArrayList<>();
        ContentStudent obj;
        String query = "SELECT * FROM student_content WHERE id = " + courseId;
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String patikaName = rs.getString("patika_name");
                String courseName = rs.getString("course_name");
                String lang = rs.getString("language");
                String descrip = rs.getString("description");
                String youtube = rs.getString("youtube");
                String quiz = rs.getString("quiz");

                obj = new ContentStudent(id, patikaName, courseName, lang, descrip, youtube, quiz);
                courseList.add(obj);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return courseList;
    }
    public static boolean addQuiz(String title, String quiz){
        String query = "UPDATE student SET quiz = ? WHERE course_name = ?";
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
    public static ArrayList<Content> searchContent(String title, int id){
        String query = "SELECT * FROM content WHERE content_title ILIKE '%"+title+"%' AND id = " + id;
        query = query.replace("{{content_title}}",title);
        ArrayList<Content> contentList = new ArrayList<>();
        Content obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new Content(rs.getInt("id"),rs.getString("content_title"),rs.getString("content_description"),rs.getString("content_quiz"), rs.getString("lesson_info"),rs.getString("content_youtube"));
                contentList.add(obj);
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return contentList;
    }
    public static int getCourseID(String name){
        String query = "SELECT id FROM course WHERE name = ?";
        int id = 0;
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                id = rs.getInt("id");
            }
            return id;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return Integer.parseInt(name);
    }
}
