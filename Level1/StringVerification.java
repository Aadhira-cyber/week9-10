import java.util.Scanner;

public class StringVerification {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Take user input using next()
        System.out.print("Enter the first word: ");
        String firstWord = input.next();

        System.out.print("Enter the second word: ");
        String secondWord = input.next();

        // 2. Call the custom method using charAt()
        boolean customResult = manualCompare(firstWord, secondWord);

        // 3. Use the built-in String equals() method
        boolean builtInResult = firstWord.equals(secondWord);

        // 4. Compare results and display
        System.out.println("\n--- Verification Report ---");
        System.out.println("Custom (charAt) comparison: " + customResult);
        System.out.println("Built-in (equals) comparison: " + builtInResult);

        if (customResult == builtInResult) {
            System.out.println("Status: Success! Both methods returned the same result.");
        } else {
            System.out.println("Status: Error! Results do not match.");
        }

        input.close();
    }

    /**
     * Method to compare two strings character by character
     * Returns true if strings are identical, false otherwise
     */
    public static boolean manualCompare(String s1, String s2) {
        // Strings of different lengths can never be equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check every character index
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false; // Found a mismatch
            }
        }

        return true; // No mismatches found
    }
}
