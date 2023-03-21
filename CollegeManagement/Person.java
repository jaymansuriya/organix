package CollegeManagement;

import java.util.Date;

public class Person {
    private String name;
    private int age;
    private Date joiningDate;

    public Person(String name, int age, Date joiningDate) {
        this.name = name;
        this.age = age;
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Age: " + getAge() + ", Joining Date: " + getJoiningDate();
    }
}