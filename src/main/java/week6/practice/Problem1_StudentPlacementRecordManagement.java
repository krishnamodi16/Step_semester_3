package week6.practice;

class PlacementRecord {
    private String studentName;
    private String company;
    private double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.printf("Student: %s | Company: %s | Package: %.2f LPA%n",
                studentName, company, packageLpa);
    }
}

public class Problem1_StudentPlacementRecordManagement {
    public static void main(String[] args) {
        PlacementRecord[] records = {
            new PlacementRecord("Aisha", "Infosys", 6.5),
            new PlacementRecord("Rohit", "TCS", 5.8),
            new PlacementRecord("Meena", "Wipro", 7.2)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
