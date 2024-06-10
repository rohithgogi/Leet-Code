class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> list=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max) max=candies[i];
        }
        for(int can:candies){
            if(can+extraCandies>=max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list; 
    }
}