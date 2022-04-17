import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPagesInTheCurrentBook = Integer.parseInt(scanner.nextLine());
        int pagesHeReadsIn1Hour = Integer.parseInt(scanner.nextLine());
        int theNumberOfDaysTheBookShouldBeRead = Integer.parseInt(scanner.nextLine());
        //Общо време за четене на книгата
        int totalTimeToReadTheBook = numberOfPagesInTheCurrentBook / pagesHeReadsIn1Hour;
        //Необходимите часове на ден
        int theRequiredHoursPerDay = totalTimeToReadTheBook / theNumberOfDaysTheBookShouldBeRead;
        System.out.println(theRequiredHoursPerDay);
    }
}
