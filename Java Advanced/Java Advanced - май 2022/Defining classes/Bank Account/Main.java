import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {

            String[] tokens = line.split("\\s+");

            String command = tokens[0];

            String output= null;
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int id = bankAccount.getID();
                    bankAccounts.put(id, bankAccount);
                    output = "Account ID"  + id + " created";
                    break;
                case "Deposit":
                    int inputID = Integer.parseInt(tokens[1]);
                    int inputAmount = Integer.parseInt(tokens[2]);
                    BankAccount inputBankAccount = bankAccounts.get(inputID);
                    if (inputBankAccount != null) {
                        inputBankAccount.deposit(inputAmount);
                        output = "Deposited " + inputAmount + " to ID" + inputID;
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    inputID = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    inputBankAccount = bankAccounts.get(inputID);
                    if (inputBankAccount != null) {
                        output = String.format("%.2f", inputBankAccount.getInterest(years));
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
        }
    }
}
