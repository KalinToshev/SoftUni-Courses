package ReflectionAndAnnotationLab.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Take an object of Class type
        Class clazz = Reflection.class;
        //Print the class type
        System.out.println(clazz);
        //Print the super class
        System.out.println(clazz.getSuperclass());
        //Print all the interfaces that we inherit from the Reflection class
        //Take an array of the interfaces we inherit from
        Class[] clazzInterfaces = clazz.getInterfaces();
        //Through Stream API we print the array of the interfaces
        Arrays.stream(clazzInterfaces).forEach(System.out::println);
        //Instantiate object using reflection and print it
        Constructor reflectionConstructor = clazz.getDeclaredConstructor();
        Reflection reflection = (Reflection) reflectionConstructor.newInstance();
        System.out.println(reflection);
    }
}
