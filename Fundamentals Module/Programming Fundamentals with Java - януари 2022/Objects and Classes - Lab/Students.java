package bg.softuni.ObjectsАndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        //Getter and Setter #1
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        //Getter and Setter #2
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        //Getter and Setter #3
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        //Getter and Setter #4
        public String getHometown() {
            return hometown;
        }
        public void setHometown(String hometown) {
            this.hometown = hometown;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            Student s = new Student();

            s.setFirstName(tokens[0]);
            s.setLastName(tokens[1]);
            s.setAge(Integer.parseInt(tokens[2]));
            s.setHometown(tokens[3]);

            students.add(s);

            line = scanner.nextLine();
        }

        String hometown = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(hometown)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
