class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }

        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                for(int j=i+1;j<nums2.length;j++){
                    if(nums2[j]>nums2[i]){
                        ans[map.get(nums2[i])]=nums2[j];
                        break;
                    }
                }
            }
        }
        return ans;
    }
}