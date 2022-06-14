import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("Mercedes-Benz");
        cars.add("BMW");
        cars.add("Honda");
        cars.add("Audi");
        cars.add("Toyota");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ArrayList.ser"));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ArrayList.ser"));
            oos.writeObject(cars);
            Object listFromFile =  ois.readObject();
            System.out.println(listFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
