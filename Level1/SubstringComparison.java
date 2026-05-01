import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take user input
        System.out.print("Enter a word: ");
        String originalText = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index (exclusive): ");
        int end = sc.nextInt();

        // 2. Generate substring using charAt() method
        String manualSub = createManualSubstring(originalText, start, end);

        // 3. Generate substring using built-in method
        String builtInSub = originalText.substring(start, end);

        // 4. Compare the two results using the custom comparison method
        boolean areEqual = compareStrings(manualSub, builtInSub);

        // Display results
        System.out.println("\n--- Substring Results ---");
        System.out.println("Manual Substring:  " + manualSub);
        System.out.println("Built-in Substring: " + builtInSub);
        System.out.println("Methods Match:      " + areEqual);

        sc.close();
    }

    /**
     * Creates a substring manually by looping through indices 
     * and appending characters using charAt()
     */
    public static String createManualSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    /**
     * Compares two strings character by character using charAt()
     */
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
