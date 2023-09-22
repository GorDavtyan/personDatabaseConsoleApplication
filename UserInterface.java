package homeworks.personDatabaseConsoleApplication1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type User interface.
 */
public class UserInterface {
    private List<Person> personList;
    private static final String PATH = "personObj.txt";


    /**
     * Instantiates a new User interface.
     */
    public UserInterface() {
        personList = new ArrayList<>();
    }

    /**
     * Add person.
     *
     * @param scanner the scanner
     */
    public void addPerson(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surName: ");
        String surName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        validAge(scanner, age);
        scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        validDOB(scanner, dateOfBirth);
        Person person = new Person(name, surName, age, dateOfBirth);
        searchPerson(person, scanner);
    }

    /**
     * Display the list of persons.
     */
    public void displayTheListOfPersons() {
        personList.forEach(System.out::println);
    }

    /**
     * Valid date format boolean.
     *
     * @param dateOfBirth the date of birth
     * @return the boolean
     */
    public boolean validDateFormat(String dateOfBirth) {
        String str = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[5-9][0-9]|20(0[0-9]|1[0-9]|2[0-3]))$";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(dateOfBirth);
        boolean test = false;
        if (matcher.matches()) {
            String[] split = dateOfBirth.split("/");
            System.out.println(Arrays.toString(split));
            int day = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int year = Integer.parseInt(split[2]);

            if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                    && (day >= 1 && day <= 31)) || ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1 && day <= 30)) {
                return true;
            } else if ((month == 2 && (year % 4 == 0 && year % 100 != 0) && (day >= 1 && day <= 29)) || (month == 2 && day >= 1 && day <= 28)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valid dob.
     *
     * @param scanner     the scanner
     * @param dateOfBirth the date of birth
     */
    public void validDOB(Scanner scanner, String dateOfBirth) {
        boolean test = validDateFormat(dateOfBirth);
        while (!test) {
            System.out.println("Invalid statement, please enter the valid date of birth");
            dateOfBirth = scanner.nextLine();
            test = validDateFormat(dateOfBirth);
        }
    }

    /**
     * Valid age.
     *
     * @param scanner the scanner
     * @param age     the age
     */
    public void validAge(Scanner scanner, int age) {
        while (age <= 0) {
            System.out.println("Invalid statement, please enter the positive number");
            age = scanner.nextInt();
        }
    }

    /**
     * Search person.
     *
     * @param person  the person
     * @param scanner the scanner
     */
    public void searchPerson(Person person, Scanner scanner) {
        boolean test = false;
        for (Person p : personList) {
            if (p.getName().equalsIgnoreCase(person.getName()) && p.getSurName().equalsIgnoreCase(person.getSurName())) {
                test = true;
                System.out.println("With such data, a person already exists, we offer two options, choose one and one");
                System.out.println("1.Add as a new person");
                System.out.println("2.Overwrite the existing person's data");
                int ch = scanner.nextInt();
                if (ch == 1) {
                    personList.add(person);
                    break;
                } else {
                    int index = personList.indexOf(p);
                    personList.set(index, person);
                    break;
                }
            }
        }
        if (!test) {
            personList.add(person);
        }
    }


    /**
     * Persons to file.
     */
    public void personsToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(personList);
            objectOutputStream.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Load list persons.
     *
     * @param people the people
     */
    public void loadListPersons(List<Person> people) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            people = (List<Person>) objectInputStream.readObject();
            System.out.println("Load persons : ");
            people.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("File is empty: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    /**
     * Remove person.
     *
     * @param scanner the scanner
     */
    public void removePerson(Scanner scanner) {
        System.out.print("Enter the name person for remove: ");
        String name = scanner.nextLine();
        System.out.print("Enter the surName person for remove: ");
        String surName = scanner.nextLine();

        if (personList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (Person p : personList) {
                if (p.getName().equalsIgnoreCase(name) && p.getSurName().equalsIgnoreCase(surName)) {
                    personList.remove(p);
                    break;
                }
            }
        }
    }
}
