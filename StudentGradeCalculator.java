import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" Student Grade Calculator");
        System.out.print("Enter number of subjects: ");
        int subjectCount = input.nextInt();

        int totalMarks = 0;

        
        for (int i = 1; i <= subjectCount; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = input.nextInt();

           
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks. Please enter again (0-100): ");
                marks = input.nextInt();
            }

            totalMarks += marks;
        }

        
        double percentage = (double) totalMarks / subjectCount;

        
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B+";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else if (percentage >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        
        System.out.println("\n Result Summary:");
        System.out.println("Total Marks Obtained: " + totalMarks + " out of " + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Assigned Grade: " + grade);

        input.close();
    }
}

