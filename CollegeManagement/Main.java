package CollegeManagement;

import java.text.ParseException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        College college = new College();

        Student student1 = new Student("John Doe", 20, new Date(), 1001, "Computer Science");
        Student student2 = new Student("Jane Doe", 22, new Date(), 1002, "Mechanical Engineering");
        Teacher teacher1 = new Teacher("Dr. Smith", 40, new Date(), "Computer Science", 80000);
        Teacher teacher2 = new Teacher("Dr. Johnson", 45, new Date(), "Mechanical Engineering", 90000);

        college.addStudent(student1);
        college.addStudent(student2);
        college.addTeacher(teacher1);
        college.addTeacher(teacher2);

        Student foundStudent = college.findStudent(1001);
        System.out.println("Found Student: " + foundStudent);

        System.out.println(" ");
        Teacher foundTeacher = college.findTeacher("Dr. Johnson");
        System.out.println("Found Teacher: " + foundTeacher);

        Student newStudent = new Student("John Smith", 21, new Date(), 1001,
                "Computer Science");
        college.updateStudent(foundStudent, newStudent);
        System.out.println(" ");

        System.out.println("Updated Student: " + college.findStudent(1001));

        Teacher newTeacher = new Teacher("Dr. Brown", 50, new Date(), "Mechanical Engineering", 95000);
        college.updateTeacher(teacher2, newTeacher);
        System.out.println(" ");

        System.out.println("Updated Teacher: " + college.findTeacher("Dr. Brown"));

        System.out.println();

        System.out.println("All Students: " + college.getAllStudents());
        System.out.println();

        System.out.println("All Teachers: " + college.getAllTeachers());

        college.removeStudent(student2);
        college.removeTeacher(teacher1);
        System.out.println(" ");

        System.out.println("All Students after removing: " +
                college.getAllStudents());
        System.out.println(" ");

        System.out.println("All Teachers after removing: " +
                college.getAllTeachers());

    }
}
