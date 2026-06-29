class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int usedDays = 1;
        int currentWeight = 0;

        for (int w : weights) {

            if (currentWeight + w > capacity) {

                usedDays++;
                currentWeight = 0;
            }

            currentWeight += w;
        }

        return usedDays <= days;
    }
}