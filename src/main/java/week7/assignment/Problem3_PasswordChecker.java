package week7.assignment;

class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password == null ? "" : password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        }
        return "Strong";
    }
}

public class Problem3_PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        PasswordChecker pc3 = new PasswordChecker("abcdefghij");

        System.out.println("Password 1 strength: " + pc1.getStrength());
        System.out.println("Password 2 strength: " + pc2.getStrength());
        System.out.println("Password 3 strength: " + pc3.getStrength());
        // The password itself is never exposed by the class.
    }
}
