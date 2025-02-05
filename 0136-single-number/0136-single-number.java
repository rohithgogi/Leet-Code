class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if ((nums[i] ^ nums[i + 1]) != 0) {
                return nums[i];
            }
            i = i + 2;
        }
        return nums[i];
    }
}