package WeekTwo.StudentInformationSystem;


import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        // Defined Objects -- Courses Defined
        Course physics = new Course("Physics", "PHY301", true);
        Course mathematic = new Course("Mathematic", "MTH301", true);
        Course chemistry = new Course("Chemistry", "CHE301", true);
        // Teacher Assigment
        Teacher teacherOne = new Teacher("Tyler Perr", "Dr","MATH");
        Teacher teacherTwo = new Teacher("Jennifer Stone", "Prof.Dr", "PHY");
        Teacher teacherThree = new Teacher("Michelle Ray", "Assoc.Prof.Dr","CHE" );
        // Add Attributes and Output
        System.out.println("Teacher Assignment");
        System.out.println("-------------------------------");
        mathematic.addTeacher(teacherOne);
        mathematic.printTeacher();

        System.out.println("-------------------------------");


        physics.addTeacher(teacherTwo);
        physics.printTeacher();
        System.out.println("-------------------------------");

        chemistry.addTeacher(teacherThree);
        chemistry.printTeacher();
        System.out.println("-------------------------------");
        // Add Some Student
        Student studentOne = new Student("Jennifer Lawrance", "15199032",2,
                mathematic,physics,chemistry);
        studentOne.addBulkExamNote(45,95,55);
        studentOne.isPass();

        Student studentTwo = new Student("Emma Stone", "06198834",3,
                mathematic,physics,chemistry);
        studentTwo.addBulkExamNote(85,63,77);
        studentTwo.isPass();

        Student studentThree = new Student("Tom Hardy", "15197745",4,
                mathematic,physics,chemistry);
        studentThree.addBulkExamNote(56,44,48);
        studentThree.isPass();
    }
}
