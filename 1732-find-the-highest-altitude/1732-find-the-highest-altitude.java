class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int value : gain) {
            altitude += value;
            highest = Math.max(highest, altitude);
        }

        return highest;
    }
}