import java.util.Scanner;

public class UniqueCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take user input
        System.out.print("Enter a string: ");
        String userInput = sc.next();

        // 2. Find unique characters
        char[] uniqueChars = findUniqueChars(userInput);

        // 3. Display the result
        System.out.print("Unique characters: ");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }
        
        System.out.println("\nTotal unique count: " + uniqueChars.length);

        sc.close();
    }

    /**
     * Method to find length without .length()
     */
    public static int getLength(String text) {
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

    /**
     * Method to find unique characters using nested loops
     */
    public static char[] findUniqueChars(String text) {
        int len = getLength(text);
        char[] tempArray = new char[len];
        int uniqueCount = 0;

        // Outer loop to pick characters one by one
        for (int i = 0; i < len; i++) {
            char currentChar = text.charAt(i);
            boolean isAlreadyPresent = false;

            // Inner loop to check if the character appeared previously
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isAlreadyPresent = true;
                    break;
                }
            }

            // If not found earlier, it is unique to this point
            if (!isAlreadyPresent) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create a new array of the exact size to store unique characters
        char[] finalUniqueArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            finalUniqueArray[i] = tempArray[i];
        }

        return finalUniqueArray;
    }
}
