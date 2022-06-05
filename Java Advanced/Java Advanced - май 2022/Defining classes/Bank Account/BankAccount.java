public class BankAccount {
    private static double interestRate = 0.02;
    private static int IDs = 1;

    private int ID;
    private double balance;

    public BankAccount() {
        this.ID = IDs;
        IDs++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getID() {
        return ID;
    }
}
