package WeekTwo.StudentInformationSystem;

public class Student {
    // Attributes
    String name;
    String studentNo;
    int classes;
    Course math;
    Course physics;
    Course chemistry;
    double average;
    boolean isPass;

    // Methods
    Student(
            String name, String studentNo,int classes, Course math, Course physics,
            Course chemistry)
    {
        this.name = name;
        this.studentNo = studentNo;
        this.classes = classes;
        this.math = math;
        this.chemistry = chemistry;
        this.physics= physics;
        calculateAverage();
        this.isPass = false;

    }
    public void addBulkExamNote(int math, int physics, int chemistry){
        if (math >= 0 && math <= 100)
            this.math.note = math;

        if (physics >= 0 && math <= 100)
            this.physics.note = physics;

        if (chemistry >= 0 && chemistry <= 100)
            this.chemistry.note = chemistry;
    }
    public void calculateAverage(){
        this.average = (this.chemistry.note + this.physics.note + this.math.note) / 3;
    }
    public void isPass(){
        if (this.math.note == 0 || this.chemistry.note == 0 || this.physics.note == 0){
            System.out.println("Notes not fully entered");
        }else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average : " + this.average);
            if (this.isPass){
                System.out.println("Class Passed.");
            }else {
                System.out.println("Failed in Class.");
            }
        }
    }
    public boolean isCheckPass(){
        calculateAverage();
        return this.average > 55;
    }
    public void printNote(){
        System.out.println("-------------------------------");
        System.out.println("Student : " + this.name);
        System.out.println("Mathematic Note : " + this.math.note);
        System.out.println("Physics Note : " + this.physics.note);
        System.out.println("Chemistry Note : " + this.chemistry.note);
    }
}
