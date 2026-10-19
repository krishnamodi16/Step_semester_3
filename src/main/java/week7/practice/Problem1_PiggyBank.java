package week7.practice;

class PiggyBank {
    private double savings;
    private final String bankId;

    public PiggyBank(String bankId) {
        this.bankId = bankId;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be greater than 0.");
            return;
        }
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be greater than 0.");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings.");
        } else {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getBankId() {
        return bankId;
    }
}

public class Problem1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        System.out.println("Bank ID: " + pb.getBankId());
        System.out.println("Savings: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("Savings after rejected withdrawal: " + pb.getSavings());
    }
}
