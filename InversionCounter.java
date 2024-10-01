import java.util.Arrays;

class InversionCounter {
    public static void main(String[] args) {
        CountInversions countInversions = new CountInversions();
        int[] numbers1 = {5, 4, 3, 2, 1};
        System.out.println(countInversions.countInversions(numbers1).inversions); // Expected output: 10
        int[] numbers2 = {-3, -2, -1, 0, 1};
        System.out.println(countInversions.countInversions(numbers2).inversions); // Expected output: 0
    }
}

class Result {
    public int[] sorted;
    public long inversions;

    public Result(int[] sorted, long inversions) {
        this.sorted = sorted;
        this.inversions = inversions;
    }
}

class CountInversions {
    public Result countInversions(int[] arr) {
        if (arr.length <= 1) {
            return new Result(arr, 0);
        }

        int middle = arr.length / 2;
        Result left = countInversions(Arrays.copyOfRange(arr, 0, middle));
        Result right = countInversions(Arrays.copyOfRange(arr, middle, arr.length));
        Result merged = mergeAndCountInversions(left.sorted, right.sorted);

        // Total inversions are the inversions from left, right, and during the merge
        long totalInversions = left.inversions + right.inversions + merged.inversions;
        return new Result(merged.sorted, totalInversions);
    }

    private Result mergeAndCountInversions(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        long inversions = 0;

        // Merge the two sorted subarrays and count inversions
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
                // Since left[i] > right[j], all elements remaining in the left array 
                // will also be greater than right[j], hence we count inversions
                inversions += left.length - i;
            }
        }

        // Copy any remaining elements from left subarray
        while (i < left.length) {
            merged[k++] = left[i++];
        }

        // Copy any remaining elements from right subarray
        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return new Result(merged, inversions);
    }
}
