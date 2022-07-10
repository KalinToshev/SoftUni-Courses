package InterfacesAndAbstractionExercise.Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            //Check for digits
            String regex = "[0-9]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            } else {
                //"Browsing: {site}!"
                stringBuilder.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers) {
            //Check for only digits
            String regex = "^[0-9]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                //"Calling... {number}"
                stringBuilder.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }
}
