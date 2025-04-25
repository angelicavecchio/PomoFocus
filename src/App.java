import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("------------------------------");
        System.out.println("Welcome to the Pomodoro Timer!");
        System.out.println("------------------------------");

        Scanner scanner = new Scanner(System.in);
        Timer timer = null;
        Thread timerThread = null;
        int choice;

        do {
            printMenu();
            while(true) {
                try {
                    System.out.print("\nEnter your choice: ");
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);

                    if(choice < 1 || choice > 4) {
                        System.out.println("Enter a valid input (1-4).");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid input (1-4).");
                } catch (InputMismatchException ex) {
                    System.out.println("Enter a valid input (1-4).");
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("\nChoose your timer in minutes: ");
                    int minutes = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    timer = new Timer(minutes);
                    timerThread = new Thread(timer);
                    timerThread.start();
                    break;

                case 2:
                    if (timer != null && timer.isRunning()) {
                        timer.stop();
                        System.out.println("\nTimer stopped!");
                    } else {
                        System.out.println("\nNo timer is running.");
                    }
                    break;

                case 3:
                    if (timer != null) {
                        timer.reset(25); // Reset to default Pomodoro time
                        System.out.println("\nTimer reset to 25 minutes.");
                    } else {
                        System.out.println("\nNo timer is running.");
                    }
                    break;

                case 4:
                    System.out.println("\nExiting Pomodoro Timer. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select a valid option.");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Start Timer");
        System.out.println("2. Stop Timer");
        System.out.println("3. Reset Timer");
        System.out.println("4. Exit");
        System.out.println();
    }
}
