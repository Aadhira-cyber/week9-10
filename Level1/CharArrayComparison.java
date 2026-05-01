import java.util.Scanner;

public class CharArrayComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take user input
        System.out.print("Enter a word: ");
        String userInput = sc.next();

        // 2. Call user-defined method to get char array
        char[] manualArray = getCharsManually(userInput);

        // 3. Call built-in toCharArray() method
        char[] builtInArray = userInput.toCharArray();

        // 4. Compare the two arrays using the custom method
        boolean arraysMatch = compareCharArrays(manualArray, builtInArray);

        // Display results
        System.out.println("\n--- Array Comparison Results ---");
        System.out.println("Manual extraction complete.");
        System.out.println("Built-in extraction complete.");
        System.out.println("Do both arrays match? " + arraysMatch);

        sc.close();
    }

    /**
     * Method to return the characters in a string without using toCharArray()
     */
    public static char[] getCharsManually(String text) {
        // String uses .length() method
        char[] result = new char[text.length()];
        
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    /**
     * Method to compare two char arrays
     * Fix: Arrays use .length property (no parentheses)
     */
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        // Corrected: removed () after length
        if (arr1.length != arr2.length) {
            return false;
        }

        // Corrected: removed () after length
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
