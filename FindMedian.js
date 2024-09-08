/*
findMedian

Example

For sequence = [-1, 3, -2, 2], the output should be
solution(sequence) = 0.5;
For sequence = [1, 3, 2], the output should be
solution(sequence) = 2.
Input/Output

[execution time limit] 4 seconds (js)

[memory limit] 1 GB

[input] array.integer sequence

An unsorted array of integers.

Guaranteed constraints:
2 ≤ sequence.length ≤ 105,
-106 ≤ sequence[i] ≤ 106.

[output] float

The median of sequence.

*/

function solution(sequence) {
    const n = sequence.length;
    if (n % 2 === 1) {
        return quickSelect(sequence, 0, n - 1, Math.floor(n / 2));
    } else {
        const left = quickSelect(sequence, 0, n - 1, n / 2 - 1);
        const right = quickSelect(sequence, 0, n - 1, n / 2);
        return (left + right) / 2;
    }
}

function quickSelect(arr, left, right, k) {
    if (left === right) return arr[left];

    const pivotIndex = partition(arr, left, right);
    if (k === pivotIndex) {
        return arr[k];
    } else if (k < pivotIndex) {
        return quickSelect(arr, left, pivotIndex - 1, k);
    } else {
        return quickSelect(arr, pivotIndex + 1, right, k);
    }
}

function partition(arr, left, right) {
    const pivot = arr[right];
    let i = left - 1;

    for (let j = left; j < right; j++) {
        if (arr[j] <= pivot) {
            i++;
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }

    [arr[i + 1], arr[right]] = [arr[right], arr[i + 1]];
    return i + 1;
}

/**
 * Example usage:
 * console.log(solution([-1, 3, -2, 2]));  // Output: 0.5
 * console.log(solution([1, 3, 2]));  // Output: 2
 */

// ... existing code ...


/*
import java.util.Random;

public class QuickSelect {
    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        // Choose the median of the first, middle, and last elements as the pivot
        int pivot = medianOfThree(arr, left, right);

        // Partition the array around the pivot
        int pivotIndex = partition(arr, left, right, pivot);

        if (pivotIndex == k) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int medianOfThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        return arr[mid];
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 6, 11, 26};
        int k = 3; // Find the 3rd smallest element

        int kthSmallest = quickSelect(arr, 0, arr.length - 1, k - 1);
        System.out.println("The " + k + "-th smallest element is: " + kthSmallest);
    }
}