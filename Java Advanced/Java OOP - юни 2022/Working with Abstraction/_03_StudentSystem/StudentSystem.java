package WorkingWithAbstractionLab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    //The received command is checked and executed
    public void executeCommand(String[] commandParts) {
        String commandName = commandParts[0];
        switch (commandName) {
            case "Create":
                //A new student is created and added to the Map if it does not exist
                createStudent(commandParts);
                break;
            case "Show":
                //The student with the given name is taken
                //and the information about him is printed on the console
                showStudent(commandParts);
                break;
        }
    }

    private void showStudent(String[] commandParts) {
        Student student;
        String name = commandParts[1];
        if (students.containsKey(name)) {
            student = students.get(name);

            String outputStudent = String.format("%s is %s years old.", student.getName(), student.getAge());
            outputStudent = studentType(student, outputStudent);

            System.out.println(outputStudent);
        }
    }

    private String studentType(Student student, String view) {
        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }
        return view;
    }

    private void createStudent(String[] commandParts) {
        Student student;
        String name;
        name = commandParts[1];
        int age = Integer.parseInt(commandParts[2]);
        double grade = Double.parseDouble(commandParts[3]);

        student = new Student(name, age, grade);
        students.putIfAbsent(name, student);
    }
}
