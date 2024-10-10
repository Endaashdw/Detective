import java.util.ArrayList;
import java.util.Scanner;

class CaseManager {
    private ArrayList<String> cases;

    public CaseManager() {
        cases = new ArrayList<>();
    }

    public void addCase(String caseName) {
        cases.add(caseName);
    }

    public boolean searchCase(String caseName) {
        return cases.contains(caseName);
    }

    public boolean deleteCase(String caseName) {
        return cases.remove(caseName);
    }

    public ArrayList<String> getPendingCases() {
        return new ArrayList<>(cases);
    }
}

public class Detective {

    public static void main(String[] args) {
        CaseManager caseManager = new CaseManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Detective agency system.");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add case");
            System.out.println("2. Search for a specific case");
            System.out.println("3. Delete case");
            System.out.println("4. Display pending cases");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter case to add: ");
                    String itemToAdd = scanner.nextLine();
                    caseManager.addCase(itemToAdd);
                    System.out.println(itemToAdd + " added.");
                    break;

                case "2":
                    System.out.print("Enter name to search: ");
                    String itemToSearch = scanner.nextLine();
                    if (caseManager.searchCase(itemToSearch)) {
                        System.out.println(itemToSearch + " found.");
                    } else {
                        System.out.println(itemToSearch + " not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter case to delete: ");
                    String itemToDelete = scanner.nextLine();
                    if (caseManager.deleteCase(itemToDelete)) {
                        System.out.println(itemToDelete + " deleted.");
                    } else {
                        System.out.println(itemToDelete + " not found.");
                    }
                    break;

                case "4":
                    System.out.println("Pending cases: " + caseManager.getPendingCases());

                    break;

                case "5":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!command.equals("5"));

        scanner.close();
    }
}