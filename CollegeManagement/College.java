package CollegeManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class College {
    private List<Student> students;
    private List<Teacher> teachers;

    public College() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public void addStudent(Student student) {
        try {
            if (findStudent(student.getRollNumber()) != null) {
                throw new IllegalArgumentException(
                        "Student with roll number " + student.getRollNumber() + " already exists");
            }
            students.add(student);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTeacher(Teacher teacher) {
        try {
            if (findTeacher(teacher.getName()) != null) {
                throw new IllegalArgumentException("Teacher with name " + teacher.getName() + " already exists");
            }
            teachers.add(teacher);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(Student oldStudent, Student newStudent) {

        try {
            if (!students.contains(oldStudent)) {
                throw new IllegalArgumentException("Student not found");
            }
            if (findStudent(newStudent.getRollNumber()) != null
                    && newStudent.getRollNumber() != oldStudent.getRollNumber()) {
                throw new IllegalArgumentException(
                        "Another student with roll number " + newStudent.getRollNumber() + " already exists");
            }
            students.set(students.indexOf(oldStudent), newStudent);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTeacher(Teacher oldTeacher, Teacher newTeacher) {
        try {
            if (!teachers.contains(oldTeacher)) {
                throw new IllegalArgumentException("Teacher not found");
            }
            if (findTeacher(newTeacher.getName()) != null && !newTeacher.getName().equals(oldTeacher.getName())) {
                throw new IllegalArgumentException(
                        "Another teacher with name " + newTeacher.getName() + " already exists");
            }
            teachers.set(teachers.indexOf(oldTeacher), newTeacher);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeStudent(Student student) {
        try {
            if (!students.contains(student)) {
                throw new IllegalArgumentException("Student not found");
            }
            students.remove(student);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeTeacher(Teacher teacher) {
        try {
            if (!teachers.contains(teacher)) {
                throw new IllegalArgumentException("Teacher not found");
            }
            teachers.remove(teacher);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public Teacher findTeacher(String name) {
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                return teacher;
            }
        }
        return null;
    }

}