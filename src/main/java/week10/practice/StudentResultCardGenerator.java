package week10.practice;

import java.util.Locale;

class Student {
    private final String name;
    private final int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int total = 0;
        for (int mark : marks) total += mark;
        return (double) total / marks.length;
    }

    char grade() {
        double avg = average();
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    void printResult() {
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average(), grade());
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});
        s1.printResult();
        s2.printResult();
    }
}
