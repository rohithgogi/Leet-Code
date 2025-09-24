class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) return false;

        Map<Long, Long> bucket = new HashMap<>();
        long size = (long) valueDiff + 1;  

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            long id = getBucketId(num, size);

 
            if (bucket.containsKey(id)) return true;

 
            if (bucket.containsKey(id - 1) && Math.abs(num - bucket.get(id - 1)) <= valueDiff)
                return true;
            if (bucket.containsKey(id + 1) && Math.abs(num - bucket.get(id + 1)) <= valueDiff)
                return true;


            bucket.put(id, num);

            if (i >= indexDiff) {
                long oldId = getBucketId((long) nums[i - indexDiff], size);
                bucket.remove(oldId);
            }
        }
        return false;
    }

    private long getBucketId(long num, long size) {
        return num < 0 ? (num + 1) / size - 1 : num / size;
    }
}
