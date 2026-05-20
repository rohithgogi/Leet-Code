class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[A.length];
        int cnt=0;
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])){
                cnt++;
                map.remove(A[i]);
            }else{
                map.put(A[i],1);
            }

            if(map.containsKey(B[i])){
                cnt++;
                map.remove(B[i]);
            }else{
                map.put(B[i],1);
            }
            ans[i]=cnt;
            
        }
        return ans;
    }
}