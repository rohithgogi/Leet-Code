class Solution {
   
    
    public int minimumDifference(int[] nums) {
        int n=nums.length/2;
        int total=0;
        for(int i:nums){
            total+=i;
        }

        List<Integer>[] left=new ArrayList[n+1];
        List<Integer>[] right=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            left[i]=new ArrayList<>();
            right[i]=new ArrayList<>();

        }

        rec(nums,0,n,0,0,left);
        rec(nums,n,nums.length,0,0,right);

        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {

            List<Integer> leftList = left[k];
            List<Integer> rightList = right[n - k];

            for (int leftSum : leftList) {

                int target = total / 2 - leftSum;

                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < rightList.size()) {
                    int sum = leftSum + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (idx > 0) {
                    int sum = leftSum + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }
    public void rec(int[] nums, int start, int end,
                          int count, int sum,
                          List<Integer>[] list) {

        if (start == end) {
            list[count].add(sum);
            return;
        }

        rec(nums, start + 1, end,
                 count + 1,
                 sum + nums[start],
                 list);

        rec(nums, start + 1, end,
                 count,
                 sum,
                 list);
    }
}