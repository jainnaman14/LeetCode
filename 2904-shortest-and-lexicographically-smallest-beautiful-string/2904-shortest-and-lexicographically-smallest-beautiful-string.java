class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        String answer = "";

        int left = 0;
        int ones = 0;

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // Shrink while we have exactly k ones
            while (ones == k) {

                String current = s.substring(left, right + 1);

                if (answer.isEmpty()
                        || current.length() < answer.length()
                        || (current.length() == answer.length()
                            && current.compareTo(answer) < 0)) {

                    answer = current;
                }

                // Move left forward
                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }
        }

        return answer;
    }
}