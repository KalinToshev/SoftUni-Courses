package ReflectionAndAnnotationLab.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //Take an object of Class type
        Class clazz = Reflection.class;
        //Take all methods of clazz object
        Method[] allMethods = clazz.getDeclaredMethods();

        sortAndPrintMethods(allMethods, "get", 0, "%s will return class %s%n");
        sortAndPrintMethods(allMethods, "set", 1, "%s and will set field of class %s%n");
    }

    private static void sortAndPrintMethods(Method[] allMethods, String startWord, int parameterCount, String message) {
        //Take all methods who starts with "get" || "set" and have 0 || 1 parameters
        //and sort them alphabetical, and print all methods
        Method[] getMethod = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith(startWord) && m.getParameterCount() == parameterCount)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        //Print each method
        Arrays.stream(getMethod)
                .forEach( m -> System.out.printf(message, m.getName(),
                        m.getReturnType().getName()));
    }
}
