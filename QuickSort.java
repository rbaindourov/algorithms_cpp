class Solution {
    static void quickSort(int[] sizes, int left, int right) {
        if (left < right) {
            int pi = partition(sizes, left, right);
            quickSort(sizes, left, pi - 1);  // Recursively sort left side
            quickSort(sizes, pi + 1, right); // Recursively sort right side
        }
    }

    static int partition(int[] sizes, int left, int right) {
        int pivot = sizes[right];
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (sizes[j] < pivot) {
                i++;
                int temp = sizes[i];
                sizes[i] = sizes[j];
                sizes[j] = temp;
            }
        }
        int temp = sizes[i + 1];
        sizes[i + 1] = sizes[right];
        sizes[right] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] celestialSizes = {3, 5, 2, 1, 9, 5, 7, 8}; // Unsorted space rock sizes
        quickSort(celestialSizes, 0, celestialSizes.length - 1);
        for (int size : celestialSizes) {
            System.out.print(size + " ");
        }
    }
}