import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfTheFilm = scanner.nextLine();
        double seatsInTheHall = Double.parseDouble(scanner.nextLine());
        double ticketCounter = 0;
        double totalTickets = 0;
        double studentTickets =0;
        double standardTickets =0;
        double kidsTickets =0;

        while (!nameOfTheFilm.equals("Finish")) {

            String ticket = scanner.nextLine();

            while (!ticket.equals("End")) {

                switch (ticket) {
                    case "student": studentTickets++; break;
                    case "standard": standardTickets++; break;
                    case "kid": kidsTickets++; break;
                }

                ticketCounter++;

                 if (ticketCounter == seatsInTheHall) {
                     break;
                 }

                ticket = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%% full.\n",nameOfTheFilm, (ticketCounter / seatsInTheHall)*100);

            totalTickets+=ticketCounter;
            ticketCounter = 0;

            nameOfTheFilm = scanner.nextLine();
            if (nameOfTheFilm.equals("Finish")) {
                break;
            }
            seatsInTheHall = Double.parseDouble(scanner.nextLine());
        }
        System.out.printf("Total tickets: %.0f\n", totalTickets);
        System.out.printf("%.2f%% student tickets.\n", (studentTickets / totalTickets) * 100);
        System.out.printf("%.2f%% standard tickets.\n", (standardTickets / totalTickets) * 100);
        System.out.printf("%.2f%% kids tickets.", (kidsTickets / totalTickets) * 100);
    }
}
