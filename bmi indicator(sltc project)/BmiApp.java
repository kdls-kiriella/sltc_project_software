import java.util.ArrayList;
import java.util.Scanner;

public class BmiApp {
    private ArrayList<Bmi> bmiRecords = new ArrayList<>();

    public static void main(String[] args) {
        BmiApp app = new BmiApp();
        app.run();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            executeAction(choice);
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Create a record");
        System.out.println("2. Show BMI data for all users");
        System.out.println("3. Show BMI data for a selected user");
        System.out.println("4. Delete all records");
        System.out.println("5. Exit application");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                index();
                break;
            case 3:
                int id = getUserChoice(); // Prompt for ID
                view(id); // Call view(int id) with the obtained ID
                break;
            case 4:
                delete();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

   
        public void create() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter ID: ");
    int id = scanner.nextInt();
    System.out.print("Enter name: ");
    String name = scanner.next();
    System.out.print("Enter year of birth: ");
    int yob = scanner.nextInt();
    System.out.print("Enter height (cm): ");
    int height = scanner.nextInt();
    System.out.print("Enter weight (kg): ");
    int weight = scanner.nextInt();

    Bmi bmi = new Bmi(id, name, yob, height, weight);
    bmiRecords.add(bmi);
    System.out.println("Record created successfully.");
}
           public void index() {
    if (bmiRecords.isEmpty()) {
        System.out.println("No records found.");
    } else {
        System.out.println("BMI Records:");
        for (Bmi bmi : bmiRecords) {
            bmi.display();
        }
    }
}

public void view(int id) {
    for (Bmi bmi : bmiRecords) {
        if (bmi.getId() == id) {
            bmi.display();
            return;
        }
    }
    System.out.println("Record not found.");
}

public void delete() {
    bmiRecords.clear();
    System.out.println("All records deleted.");
}

public void exit() {
    System.out.println("Exiting application.");
    System.exit(0);
}

    }

    