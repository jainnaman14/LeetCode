class Solution {

    public int[] beautifulArray(int n) {

        List<Integer> result = helper(n);

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private List<Integer> helper(int n) {

        if (n == 1) {
            return Arrays.asList(1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : helper((n + 1) / 2)) {
            ans.add(2 * x - 1);
        }
        for (int x : helper(n / 2)) {
            ans.add(2 * x);
        }

        return ans;
    }
}