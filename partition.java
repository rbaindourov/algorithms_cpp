/* 

int partition(int[] arr, int start, int end) {
    int pivot = arr[end]; // choosing the last element as pivot
    int i = (start - 1);  // marking the index of smaller element

    for (int j = start; j < end; j++) {
        // checking if the current element is smaller than the pivot
        if (arr[j] <= pivot) {
            i++;

            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

void quickSort(int[] arr, int start, int end) {
    if (start < end) {
        int pivot_index = partition(arr, start, end);
        quickSort(arr, start, pivot_index - 1); // sort left part
        quickSort(arr, pivot_index + 1, end);  // sort right part
    }
}
*/

class QuickSort{
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;

        for (int j = start + 1; j <= end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[start] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] items = {7, 3, 2, 10, 9, 5, 6, 9, 2, 3};
        int pivotIndex = partition(items, 0, items.length - 1);

        System.out.println("Pivot Index: " + pivotIndex);
        for (int item : items) {
            System.out.print(item + " ");
        }
    }
}




class Solution {
    static int partitionCelestial(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        // TODO: Implement the partition loop
        for( int j = start; j < end; j++ ){
          if( arr[j] < pivot){
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] =temp;
          }  
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
      int[] celestialMagnitudes = {5, 3, 0, -1, -2, 1};
      int pivotPosition = partitionCelestial(celestialMagnitudes, 0, celestialMagnitudes.length - 1);
      // Now, celestialMagnitudes is partitioned, with pivot in the correct position.
    }
}



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