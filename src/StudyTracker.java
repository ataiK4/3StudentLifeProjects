import java.util.Scanner;
public class StudyTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int weeklyGoal = 600, total = 0, programming = 0, mathematics = 0, english = 0, other = 0, sessions = 0;

        boolean running = true;
        while (running) {
            System.out.println("===== STUDY TRACKER =====\n");
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit\n");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            if (option > 0 && option < 5) {
                switch (option) {
                    case 1:
                        System.out.println("\nChoose subject:");
                        System.out.println("1. Programming");
                        System.out.println("2. Mathematics");
                        System.out.println("3. English");
                        System.out.println("4. Other");
                        System.out.print("\nChoose an option: ");
                        int subject = scanner.nextInt();
                        if (subject > 0 && subject < 5) {
                            while (true) {
                                System.out.print("Study time in minutes: ");
                                int studytime = scanner.nextInt();

                                if (studytime > 0) {
                                    sessions++;
                                    total += studytime;
                                    if (subject == 1)
                                        programming += studytime;
                                    else if (subject == 2)
                                        mathematics += studytime;
                                    else if (subject == 3)
                                        english += studytime;
                                    else
                                        other += studytime;
                                    System.out.println("\nStudy session added!");
                                    System.out.println("Current total study time: " + total + " minutes\n");
                                    break;
                                }else
                                    System.out.println("\nInvalid study time. Time must be greater than 0.\n");
                            }
                        }else
                            System.out.println("\nError! Invalid choice.\n");
                        break;
                    case 2:
                        System.out.println("===== WEEKLY STATISTICS =====\n");
                        System.out.println("Study sessions: " + sessions);
                        System.out.println("Total study time: " + total + " minutes\n");
                        System.out.println("Programming: " + programming + " minutes");
                        System.out.println("Mathematics: " + mathematics + " minutes");
                        System.out.println("English: " + english + " minutes");
                        System.out.println("Other: " + other + " minutes\n");
                        break;
                    case 3:
                        System.out.println("\nWeekly goal: " + weeklyGoal + " minutes");
                        System.out.println("You studied: " + total + " minutes");
                        if (total >= 600)
                            System.out.println("Weekly goal achieved!\n");
                        else
                            System.out.println("Remaining: " + (weeklyGoal-total) + " minutes\n");
                        break;
                    case 4:
                        System.out.println("Study tracker closed. Keep up the good work!");
                        running = false;
                        break;
                }
            }else
                System.out.println("\nError! Invalid choice.\n");
        }
    }
}

