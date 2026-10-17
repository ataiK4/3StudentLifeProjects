import java.util.Scanner;
public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int assignmentPoints = 0, assignmentCount = 0, examPoints = 0, examCount = 0;

        boolean running = true;
        while (running) {
            System.out.println("===== SEMESTER GRADE TRACKER =====");
            System.out.println("\n1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");
            int option = scanner.nextInt();
            if (option > 0 && option < 5) {
                switch (option) {
                    case 1:
                        while (true) {
                            System.out.print("Enter assignment score: ");
                            int score = scanner.nextInt();
                            if (score >= 0 && score <= 100) {
                                assignmentCount++;
                                assignmentPoints += score;
                                System.out.println("\nAssignment score added.\n");
                                break;
                            }else
                                System.out.println("\nInvalid score. Enter a value from 0 to 100.\n");
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.print("Enter exam score: ");
                            int score = scanner.nextInt();
                            if (score >= 0 && score <= 100) {
                                examCount++;
                                examPoints += score;
                                System.out.println("\nExam score added.\n");
                                break;
                            }else
                                System.out.println("\nInvalid score. Enter a value from 0 to 100.\n");
                        }
                        break;
                    case 3:
                        double assignmentAverage = 0.0d, examAverage = 0.0d, overallAverage = 0.0d;
                        if (assignmentCount == 0 && examCount == 0) {
                            System.out.println("\nNo result available yet.\n");
                            break;
                        }
                        System.out.println("\n===== CURRENT RESULTS =====");
                        if (assignmentCount > 0) {
                            assignmentAverage = (double) assignmentPoints / assignmentCount;
                            System.out.println("\nAssignments completed: " + assignmentCount);
                            System.out.println("Assignment average: " + assignmentAverage);
                        }else
                            System.out.println("\nNo assignment completed yet!");
                        if (examCount > 0) {
                            examAverage = (double) examPoints / examCount;
                            System.out.println("\nExam completed: " + examCount);
                            System.out.println("Exam average: " + examAverage);
                        }else
                            System.out.println("\nNo exam completed yet!");

                        if (assignmentCount > 0 && examCount > 0) {
                            overallAverage = assignmentAverage*0.5 + examAverage*0.5;
                        }else if (assignmentCount > 0) {
                            overallAverage = assignmentAverage;
                            System.out.println("\nOverall average is based solely on assignments.");
                        }else {
                            overallAverage = examAverage;
                            System.out.println("\nOverall average is based solely on exams.");
                        }
                        System.out.println("\nOverall average: " + overallAverage);

                        char grade;
                        if (overallAverage >= 90) grade = 'A';
                        else if (overallAverage >= 80) grade = 'B';
                        else if (overallAverage >= 70) grade = 'C';
                        else if (overallAverage >= 60) grade = 'D';
                        else grade = 'F';
                        System.out.println("Grade: " + grade);
                        if (overallAverage >= 60) System.out.println("Status: Passing\n");
                        else System.out.println("Status: Failing\n");
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        running = false;
                        break;
                }
            }else
                System.out.println("\nError! Invalid choice.\n");
        }
    }
}
