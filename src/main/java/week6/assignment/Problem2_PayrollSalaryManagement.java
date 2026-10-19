package week6.assignment;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary rejected. Basic salary set to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0.");
            return;
        }
        bonus += amount;
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percentage must be between 0 and 100.");
            return;
        }
        basicSalary -= basicSalary * percent / 100.0;
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Problem2_PayrollSalaryManagement {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.printf("Net salary: %.2f%n", account.getNetSalary());
    }
}
