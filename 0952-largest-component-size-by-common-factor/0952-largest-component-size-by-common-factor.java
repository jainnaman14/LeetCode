class Solution {

    int[] parent;
    int[] size;

    public int largestComponentSize(int[] nums) {

        int n = nums.length;

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<Integer, Integer> factorOwner = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int num = nums[i];

            for (int factor = 2; factor * factor <= num; factor++) {

                if (num % factor == 0) {

                    if (factorOwner.containsKey(factor)) {
                        union(i, factorOwner.get(factor));
                    } else {
                        factorOwner.put(factor, i);
                    }

                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }

            if (num > 1) {

                if (factorOwner.containsKey(num)) {
                    union(i, factorOwner.get(num));
                } else {
                    factorOwner.put(num, i);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                answer = Math.max(answer, size[i]);
            }
        }

        return answer;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }
}