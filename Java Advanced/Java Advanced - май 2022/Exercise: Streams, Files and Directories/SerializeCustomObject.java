import java.io.*;

public class SerializeCustomObject {
    static class Course implements Serializable {
        String name;
        int students;

        public Course(String name, int students) {
            this.name = name;
            this.students = students;
        }
    }
    public static void main(String[] args) throws IOException {
        Course course = new Course("Java Advanced", 250);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("course.ser"));
            oos.writeObject(course);
            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.students);
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
