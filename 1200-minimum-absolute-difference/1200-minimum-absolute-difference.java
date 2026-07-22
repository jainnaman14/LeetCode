import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE;
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];

            if (difference < minDifference) {
                minDifference = difference;

                answer.clear();

                answer.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (difference == minDifference) {
                answer.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return answer;
    }
}