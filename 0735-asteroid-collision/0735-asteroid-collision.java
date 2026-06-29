class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            while (!stack.isEmpty() &&
                    asteroid < 0 &&
                    stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    stack.pop();
                }
                else if (stack.peek() == -asteroid) {
                    stack.pop();
                    asteroid = 0;
                }
                else {
                    asteroid = 0;
                }
            }

            if (asteroid != 0)
                stack.push(asteroid);
        }

        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0; i--)
            ans[i] = stack.pop();

        return ans;
    }
}