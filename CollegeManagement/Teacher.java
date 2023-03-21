package CollegeManagement;

import java.util.Date;

class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher(String name, int age, Date joiningDate, String subject, double salary) {
        super(name, age, joiningDate);
        this.subject = subject;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + getSubject() + ", Salary: " + getSalary();
    }
}