package week6.practice;

class Student {
    private String name;
    private double attendancePercentage;
    static String collegeName = "ABC College";
    static int studentCount = 0;

    public Student(String name, double attendancePercentage) {
        this.name = name;
        this.attendancePercentage = attendancePercentage;
        studentCount++;
    }

    public void printStudent() {
        System.out.printf("Name: %s | Attendance: %.1f%%%n", name, attendancePercentage);
    }

    public static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Total students created: " + studentCount);
    }
}

public class Problem5_StudentAndCollegeInformationManagement {
    public static void main(String[] args) {
        Student s1 = new Student("Aisha", 92.5);
        Student s2 = new Student("Rohit", 87.0);

        s1.printStudent();
        s2.printStudent();
        Student.printCollegeInfo();
    }
}
