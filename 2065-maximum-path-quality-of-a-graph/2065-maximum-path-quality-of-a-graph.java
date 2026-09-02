class Solution {
    int ans = 0;
    List<int[]>[] graph;
    int[] values;
    int maxTime;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;

        this.values = values;
        this.maxTime = maxTime;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] visited = new int[n];

        dfs(0, maxTime, 0, visited);

        return ans;
    }

    private void dfs(int node, int timeLeft, int score, int[] visited) {

        if (visited[node] == 0) {
            score += values[node];
        }

        visited[node]++;

        if (node == 0) {
            ans = Math.max(ans, score);
        }

        for (int[] next : graph[node]) {
            int nei = next[0];
            int cost = next[1];

            if (timeLeft >= cost) {
                dfs(nei, timeLeft - cost, score, visited);
            }
        }

        visited[node]--;
    }
}