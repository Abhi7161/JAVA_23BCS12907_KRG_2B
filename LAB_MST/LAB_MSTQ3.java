package Collections;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            System.out.println("Enter integers (type 'done' to finish):");

            while (true) {
                String input = sc.next();
                if (input.equals("done")) {
                    break;
                }
                try {
                    int num = Integer.parseInt(input);
                    numbers.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer or 'done'.");
                }
            }

            // Try calculating average
            if (numbers.isEmpty()) {
                throw new ArithmeticException("Cannot calculate average: list is empty.");
            }

            int sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            double average = (double) sum / numbers.size();
            System.out.println("The average is: " + average);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type.");
        } finally {
            sc.close();
        }
    }
}
