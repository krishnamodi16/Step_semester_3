import java.util.Scanner;

public class CSVStudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0].trim()
                + " | Roll No: " + fields[1].trim()
                + " | Dept: " + fields[2].trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name,RollNumber,Department: ");
        parseStudentRecord(sc.nextLine());
        sc.close();
    }
}
