public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // This array stores the last index of each character encountered.
        // Initialize all values to -1 indicating character not seen yet.
        int[] lastIndex = new int[128];
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }

        int maxLength = 0;
        int start = 0; // Start index of the sliding window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If we have seen this character before and it's index is within the current window
            if (lastIndex[currentChar] >= start) {
                // Move the start to one position after the last occurrence of this character
                start = lastIndex[currentChar] + 1;
            }

            // Update the last index of the current character
            lastIndex[currentChar] = end;

            // Calculate the window size and update max length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a string: ");
            String input = br.readLine();
            int result = lengthOfLongestSubstring(input);
            System.out.println("Length of the longest substring without repeating characters: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}