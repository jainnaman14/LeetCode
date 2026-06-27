

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        // 1. Add rotten oranges to queue and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[] dir = {0, 1, 0, -1, 0};

        // 2. BFS minute by minute
        while (!q.isEmpty() && fresh > 0) {
            for (int size = q.size(); size > 0; size--) {
                int[] cell = q.poll();

                for (int k = 0; k < 4; k++) {
                    int r = cell[0] + dir[k];
                    int c = cell[1] + dir[k + 1];

                    if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1)
                        continue;

                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[]{r, c});
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}