class Solution {
    public int minSubarray(int[] nums, int p) {

        long total = 0;

        for (int num : nums)
            total += num;

        int remainder = (int)(total % p);

        if (remainder == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        long prefix = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int currentMod = (int)(prefix % p);

            int need = (currentMod - remainder + p) % p;

            if (map.containsKey(need)) {
                answer = Math.min(answer,
                        i - map.get(need));
            }

            map.put(currentMod, i);
        }

        return answer == nums.length ? -1 : answer;
    }
}