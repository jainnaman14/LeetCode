class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int num : target) {
            maxHeap.offer(num);
            sum += num;
        }

        while (true) {
            int largest = maxHeap.poll();
            long restSum = sum - largest;

            if (largest == 1 || restSum == 1) {
                return true;
            }

            if (restSum == 0 || largest <= restSum) {
                return false;
            }

            int previous = (int)(largest % restSum);

            if (previous == 0) {
                return false;
            }

            maxHeap.offer(previous);
            sum = restSum + previous;
        }
    }
}