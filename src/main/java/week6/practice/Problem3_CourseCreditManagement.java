package week6.practice;

class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public void printCourse() {
        System.out.printf("%s - %s | Theory credits: %d | Lab credits: %d | Total: %d%n",
                code, title, credits, labCredits, totalCredits());
    }
}

public class Problem3_CourseCreditManagement {
    public static void main(String[] args) {
        Course course1 = new Course("CSE301", "Data Structures", 3, 1);
        Course course2 = new Course("CSE302", "Java Programming", 4);
        course1.printCourse();
        course2.printCourse();
    }
}
