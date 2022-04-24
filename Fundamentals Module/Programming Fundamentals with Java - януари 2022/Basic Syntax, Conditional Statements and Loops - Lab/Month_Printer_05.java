package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Month_Printer_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input
        int months = Integer.parseInt(scanner.nextLine());
        String month_name;

        //Calculating
        switch (months) {
            case 1:
                month_name = "January";
                break;
            case 2:
                month_name = "February";
                break;
            case 3:
                month_name = "March";
                break;
            case 4:
                month_name ="April";
                break;
            case 5:
                month_name = "May";
                break;
            case 6:
                month_name = "June";
                break;
            case 7:
                month_name  ="July";
                break;
            case 8:
                month_name = "August";
                break;
            case 9:
                month_name = "September";
                break;
            case 10:
                month_name = "October";
                break;
            case 11:
                month_name = "November";
                break;
            case 12:
                month_name = "December";
                break;
            default:
                month_name = "Error!";
                break;
        }

        //Output
        System.out.println(month_name);
    }
}
