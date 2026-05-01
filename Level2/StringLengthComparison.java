import java.util.Scanner;

public class StringLengthComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take user input
        System.out.print("Enter a string: ");
        String userInput = sc.next();

        // 2. Call user-defined method
        int manualLength = findLengthManually(userInput);

        // 3. Call built-in length() method
        int builtInLength = userInput.length();

        // Display results
        System.out.println("\n--- Length Comparison ---");
        System.out.println("Manual length (via Exception): " + manualLength);
        System.out.println("Built-in length method:        " + builtInLength);

        if (manualLength == builtInLength) {
            System.out.println("Status: Success! Both values match.");
        }

        sc.close();
    }

    /**
     * Method to find length without .length()
     * Uses an infinite loop and catches StringIndexOutOfBoundsException
     */
    public static int findLengthManually(String text) {
        int count = 0;
        try {
            // Infinite loop to access every character
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // When charAt() goes past the last index, the loop breaks here
            return count;
        }
    }
}
