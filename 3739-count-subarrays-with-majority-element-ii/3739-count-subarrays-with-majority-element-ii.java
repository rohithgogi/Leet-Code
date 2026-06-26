class Solution {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        return mergeSort(prefix, 0, n);
    }

    private long mergeSort(long[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = mergeSort(arr, left, mid)
                   + mergeSort(arr, mid + 1, right);

        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[j] <= arr[i]) {
                j++;
            }
            count += right - j + 1;
        }

        merge(arr, left, mid, right);

        return count;
    }

    private void merge(long[] arr, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }
}