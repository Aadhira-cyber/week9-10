import java.util.Scanner;

public class StringSplitComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take user input using nextLine()
        System.out.print("Enter a sentence: ");
        String userInput = sc.nextLine().trim();

        // 2. Call user-defined split method
        String[] manualWords = manualSplit(userInput);

        // 3. Call built-in split method
        // Using " +" regex to handle multiple spaces like a manual count would
        String[] builtInWords = userInput.split(" ");

        // 4. Compare the results
        boolean arraysMatch = compareStringArrays(manualWords, builtInWords);

        // Display results
        System.out.println("\n--- Split Comparison Results ---");
        System.out.println("Manual Words Count:  " + manualWords.length);
        System.out.println("Built-in Words Count: " + builtInWords.length);
        System.out.println("Do both arrays match? " + arraysMatch);

        sc.close();
    }

    // Method to find length without using .length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text using charAt() and space indexing
    public static String[] manualSplit(String text) {
        int len = findLength(text);
        if (len == 0) return new String[0];

        // Count spaces to determine word count
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // Create array for space indexes (+2 for virtual start/end boundaries)
        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1; // Boundary before the first word
        int indexTracker = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[indexTracker++] = i;
            }
        }
        spaceIndexes[spaceCount + 1] = len; // Boundary after the last word

        // Create array to store words
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            // Extract substring using boundaries
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    // Method to compare two string arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}

