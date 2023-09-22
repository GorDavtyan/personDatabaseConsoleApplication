package homeworks.personDatabaseConsoleApplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type User interface main.
 */
public class UserInterfaceMain {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInterface userInterface = new UserInterface();

        List<Person> people = new ArrayList<>();

        while (true) {
            System.out.println("Menu!");
            System.out.println("1.Load the list of persons");
            System.out.println("2.Add a new person");
            System.out.println("3.Display all persons");
            System.out.println("4.Remove a person from the list");
            System.out.println("5.Save data to file");
            System.out.println("6.Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> userInterface.loadListPersons(people);
                case 2 -> userInterface.addPerson(scanner);
                case 3 -> userInterface.displayTheListOfPersons();
                case 4 -> userInterface.removePerson(scanner);
                case 5 -> userInterface.personsToFile();
                case 6 -> {
                    System.out.println("Existing the program");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again");
            }

        }
    }
}
