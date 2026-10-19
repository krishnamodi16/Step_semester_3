package week6.practice;

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance rejected. Balance set to 0.");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0.");
            return;
        }
        balance += amount;
        System.out.printf("Top-up successful. Balance: %.2f%n", balance);
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction rejected: amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Deduction rejected: insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Deduction successful. Balance: %.2f%n", balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Problem2_HostelMessWalletManagement {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(150);
        wallet.deduct(1000);
        System.out.printf("Final balance: %.2f%n", wallet.getBalance());
    }
}
