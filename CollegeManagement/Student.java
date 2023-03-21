package CollegeManagement;

import java.util.Date;

class Student extends Person {
    private int rollNumber;
    private String department;

    public Student(String name, int age, Date joiningDate, int rollNumber, String department) {
        super(name, age, joiningDate);
        this.rollNumber = rollNumber;
        this.department = department;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Roll Number: " + getRollNumber() + ", Department: " + getDepartment();
    }
}