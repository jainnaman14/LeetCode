class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if a palindromic permutation is possible
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // Characters available for the left half
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int halfLen = s.length() / 2;
        StringBuilder left = new StringBuilder();

        // Build the left half greedily
        for (int pos = 0; pos < halfLen; pos++) {
            boolean found = false;

            for (int c = 0; c < 26; c++) {
                if (halfCount[c] == 0) continue;

                // Try this smallest available character
                halfCount[c]--;
                left.append((char) ('a' + c));

                // Check whether ANY completion can be > target
                if (canMakeGreater(left, halfCount, middle, target)) {
                    found = true;
                    break;
                }

                // Undo
                left.deleteCharAt(left.length() - 1);
                halfCount[c]++;
            }

            if (!found) {
                return "";
            }
        }

        String result = buildPalindrome(left.toString(), middle);

        return result.compareTo(target) > 0 ? result : "";
    }

    private boolean canMakeGreater(
            StringBuilder left,
            int[] halfCount,
            char middle,
            String target) {

        StringBuilder maxLeft = new StringBuilder(left);

        // Build the LARGEST possible remaining left half
        for (int c = 25; c >= 0; c--) {
            for (int j = 0; j < halfCount[c]; j++) {
                maxLeft.append((char) ('a' + c));
            }
        }

        String palindrome = buildPalindrome(maxLeft.toString(), middle);

        return palindrome.compareTo(target) > 0;
    }

    private String buildPalindrome(String left, char middle) {
        StringBuilder result = new StringBuilder(left);

        if (middle != 0) {
            result.append(middle);
        }

        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }
}