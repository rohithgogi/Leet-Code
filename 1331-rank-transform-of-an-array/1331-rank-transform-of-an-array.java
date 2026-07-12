class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] nums=arr.clone();
        Arrays.sort(nums);
        int j=1;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],j);
                j++;
            }else continue;
        }
        for(int i=0;i<arr.length;i++){
            nums[i]=map.get(arr[i]);
        }
        return nums;
    }
}