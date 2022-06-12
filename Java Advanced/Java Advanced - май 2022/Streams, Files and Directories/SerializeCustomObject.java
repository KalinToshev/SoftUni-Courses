import java.io.*;

public class SerializeCustomObject {
    public static class Cube implements Serializable {
        String color;
        double height;
        double length;
        double depth;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube iceCube = new Cube();
        iceCube.color = "water";
        iceCube.height = 13;
        iceCube.length = 42;
        iceCube.depth = 69;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("ice-cube.txt"));

        objectOutputStream.writeObject(iceCube);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ice-cube.txt"));

        Cube cube = (Cube)objectInputStream.readObject();
    }
}
