class Solution {

    int[] parent;

    public boolean[] friendRequests(
        int n,
        int[][] restrictions,
        int[][] requests
    ) {

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] answer = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {

            int u = requests[i][0];
            int v = requests[i][1];

            int rootU = find(u);
            int rootV = find(v);

            boolean allowed = true;

            for (int[] restriction : restrictions) {

                int a = find(restriction[0]);
                int b = find(restriction[1]);

                if ((a == rootU && b == rootV) ||
                    (a == rootV && b == rootU)) {

                    allowed = false;
                    break;
                }
            }

            if (allowed) {
                union(rootU, rootV);
                answer[i] = true;
            } else {
                answer[i] = false;
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

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}