package JavaAdvancedRetakeExam14April2021.University03;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < getCapacity()) {
            if (students.contains(student)) {
                return "Student is already in the university";
            } else {
                students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        } else {
            return  "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = students.stream().filter(student1 -> student1.getFirstName().equals(firstName)).findFirst().orElse(null);
        if (student != null) {
            if (student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            //==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
            sb.append("==Student: First Name = ").append(student.getFirstName()).append(", Last Name = ").append(student.getLastName()).append(", Best Subject = ").append(student.getBestSubject()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
