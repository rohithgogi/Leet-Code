class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Set<int[]> set=new HashSet<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]); 
        });
        for(int i=0;i<intervals.length-1;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[j][0]>=s && intervals[j][1]<=e){
                    set.add(intervals[j]);
                }
            }
        }
        return intervals.length-set.size();
    }
}