import java.util.Scanner;
public class ScreenTimeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int socialmedia = 0, gaming = 0, studying = 0, videostreaming = 0, sessions = 0, total = 0;

        int option = 0;
        while (option != 6) {
            System.out.println("===== SCREEN-TIME TRACKER =====");
            System.out.println("\n1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.print("\nChoose an option: ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option > 0 && option < 5) {
                    String nametime = "";
                    switch (option) {
                        case 1:
                            nametime = "social media";
                            break;
                        case 2:
                            nametime = "gaming";
                            break;
                        case 3:
                            nametime = "studying";
                            break;
                        case 4:
                            nametime = "video or streaming";
                            break;
                    }
                    System.out.print("Enter " + nametime + " minutes: ");
                    int time = scanner.nextInt();
                    if (time > 0) {
                        sessions++;
                        total += time;
                        System.out.println("\nTime added successfully\n");
                        switch (option) {
                            case 1:
                                socialmedia += time;
                                break;
                            case 2:
                                gaming += time;
                                break;
                            case 3:
                                studying += time;
                                break;
                            case 4:
                                videostreaming += time;
                        }
                    } else
                        System.out.println("\nInvalid time. Minutes must be greater than 0.\n");
                }else if (option == 5){
                    System.out.println("\n===== TODAY'S SCREEN TIME =====");
                    System.out.println("\nSocial media: " + socialmedia + " minutes");
                    System.out.println("Gaming: " + gaming + " minutes");
                    System.out.println("Studying: " + studying + " minutes");
                    System.out.println("Streaming: " + videostreaming + " minutes");
                    System.out.println("\nTotal screen time: " + total + " minutes");
                    System.out.println("Recorded sessions: " + sessions);

                    if (total < 120) {
                        System.out.println("Low screen time");
                    }else if (total >= 120 && total <= 240) {
                        System.out.println("Moderate screen time");
                    }else {
                        System.out.println("High screen time");
                    }

                    int entertainmentTime = socialmedia + gaming + videostreaming;
                    if (studying > entertainmentTime) {
                        System.out.println("\nStudy screen time is greater than entertainment screen time. Good balance!\n");
                    }else if (studying < entertainmentTime) {
                        System.out.println("\nEntertainment screen time is greater than study time.\n");
                    }else {
                        System.out.println("\nStudy and entertainment screen time are equal.\n");
                    }
                }else if (option == 6) {
                    System.out.println("\nScreen-time tracker closed.");
                }
                else
                    System.out.println("\nInvalid choice. Choose between 1 to 6.\n");
            }else {
                System.out.println("\nInvalid input! Enter number between 1 to 6.\n");
                scanner.next();
            }
        }
    }
}
