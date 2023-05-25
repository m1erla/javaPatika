package WeekTwo.StudentInformationSystem;

public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String match;
    boolean isMatch;
    int note;
    public Course(String name, String code, boolean isMatch){
        this.name = name;
        this.code = code;
        this.isMatch = isMatch;
        this.note = 0;
    }
    public void addTeacher(Teacher teacher){
        if (this.isMatch == true){
            this.match = teacher.branch;
            this.courseTeacher = teacher;
            System.out.println("Transaction successful");
        }else {
            System.out.println(teacher.name + " Academician cannot teach this course.");
        }
    }
    public void printTeacher(){
        if (courseTeacher != null){
            System.out.println(this.name + " Academician of the course : " + courseTeacher.name);
        }else {
            System.out.println(this.name + " No Academician has been assigned to the course." );
        }
    }
}
