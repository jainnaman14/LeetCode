class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();

        backtrack(n, new StringBuilder(), result);

        if (k > result.size()) {
            return "";
        }

        return result.get(k - 1);
    }

    private void backtrack(
        int n,
        StringBuilder current,
        List<String> result
    ) {

        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {

            if (current.length() > 0 &&
                current.charAt(current.length() - 1) == ch) {
                continue;
            }

            current.append(ch);

            backtrack(n, current, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}