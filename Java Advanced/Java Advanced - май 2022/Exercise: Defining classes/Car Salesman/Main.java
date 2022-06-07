import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engineInCatalog = new HashMap<>();
        List<Car> carsInCatalog = new ArrayList<>();

        int line = Integer.parseInt(scanner.nextLine());

        while (line-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");
            String model = token[0];
            int power = Integer.parseInt(token[1]);
            Engine engine = null;

            if (token.length==2)  engine = new Engine(model, power);
            if (token.length==3) {
                if (token[2].chars().allMatch(Character::isDigit))
                    engine = new Engine(model, power, Integer.parseInt(token[2]));
                else engine = new Engine(model, power, token[2]);
            }
            if (token.length==4)   engine = new Engine(model, power, Integer.parseInt(token[2]), token[3]);

            engineInCatalog.put(model, engine);
        }

        line = Integer.parseInt(scanner.nextLine());
        while (line-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");
            String model = token[0];
            String engine = token[1];
            Car car = null;
            Engine tempEngine = engineInCatalog.get(engine);

            if (token.length==2)  car = new Car(model, tempEngine);
            if (token.length==3) {
                if (token[2].chars().allMatch(Character::isDigit)) car = new Car(model, tempEngine, Integer.parseInt(token[2]));
                else car = new Car(model, tempEngine, token[2]);
            }
            if (token.length==4)   car = new Car(model, tempEngine, Integer.parseInt(token[2]), token[3]);
            carsInCatalog.add(car);

        }
        carsInCatalog.forEach(System.out::println);
    }
}
