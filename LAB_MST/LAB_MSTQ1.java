package Collections;
import java.util.*;
import java.util.ArrayList;
public class StudentNameList {
    private ArrayList<String> studentList = new ArrayList<>();

    public void addName(String name) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        studentList.add(name);
        System.out.println("Name added successfully!");
    }

    public void remove(String name) throws EmptyListException {
        if (studentList.isEmpty()) {
            throw new EmptyListException("List is empty, nothing to remove");
        }
        if (studentList.remove(name)) {
            System.out.println("Name removed successfully!");
        } else {
            System.out.println("Name not found in the list!");
        }
    }

    public static class EmptyListException extends Exception {
        public EmptyListException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        StudentNameList studentList = new StudentNameList();
        Scanner sc = new Scanner(System.in);
        int choice;
        Boolean status=true;
        do {
            System.out.println("\n1. Add a name");
            System.out.println("2. Remove a name");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter a name: ");
                        String nameToAdd = sc.nextLine();
                        studentList.addName(nameToAdd);
                        break;

                    case 2:
                        System.out.print("Enter a name to remove: ");
                        String nameToRemove = sc.nextLine();
                        studentList.remove(nameToRemove);
                        break;

                    case 3:
                        System.out.println("Exiting... Goodbye!");
                        status=false;
                        break;

                    default:
                        System.out.println("Invalid choice, try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine(); // clear buffer
                choice = -1;
            } catch (NullPointerException | EmptyListException e) {
                System.out.println(e.getMessage());
                choice = -1;
            }
        } while (status);
        sc.close();
    }
}
