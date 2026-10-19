package week7.practice;

class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully for locker " + lockerNumber + ".");
            return true;
        }
        System.out.println("Code change rejected: incorrect current code.");
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class Problem4_LockerCode {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
        System.out.println("Locker number: " + locker.getLockerNumber());
        // There is intentionally no getter for the private code.
    }
}
