package ReflectionAndAnnotationExercise.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Field>> fieldsMap = fillFieldsMap();

        String command = scanner.nextLine();
        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    fieldsMap.get("private").forEach(Main::printField);
                    break;
                case "protected":
                    fieldsMap.get("protected").forEach(Main::printField);
                    break;
                case "public":
                    fieldsMap.get("public").forEach(Main::printField);
                    break;
                case "all":
                    fieldsMap.get("all").forEach(Main::printField);
                    break;
            }
            command = scanner.nextLine();
        }
    }

    private static void printField(Field field) {
        System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName());
    }

    private static Map<String, List<Field>> fillFieldsMap() {
        Map<String, List<Field>> map = new HashMap<>();

        Class clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        map.put("private", new ArrayList<>());
        map.put("protected", new ArrayList<>());
        map.put("public", new ArrayList<>());
        map.put("all", Arrays.asList(fields));

        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            switch (modifier) {
                case "private":
                    map.get("private").add(field);
                    break;
                case "protected":
                    map.get("protected").add(field);
                    break;
                case "public":
                    map.get("public").add(field);
                    break;
            }
        }

        return map;
    }
}
