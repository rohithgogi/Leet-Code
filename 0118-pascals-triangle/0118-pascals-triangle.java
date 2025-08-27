class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> arr=new ArrayList<>();
            for(int j=0;j<=i;j++){
                
                if(j==0 || j==i){
                    arr.add(1);
                }else{
                    List<Integer> prev=list.get(i-1);
                    arr.add(prev.get(j-1)+prev.get(j));
                }  
                
            }
            list.add(arr);
        }
        return list;
    }
}