class BinarySearch {
    static int binarySearchForBook(int[] bookIDs, int start, int end, int searchID) {
        if (start > end) return -1; // Base case
        int mid = start + (end - start) / 2; // Find the midpoint
        if (bookIDs[mid] == searchID) return mid; // Target found
        if (bookIDs[mid] > searchID) // If the target is less than the midpoint
            return binarySearchForBook(bookIDs, start, mid - 1, searchID); // Search the left half
        return binarySearchForBook(bookIDs, mid + 1, end, searchID); // Search the right half
    }

    public static void main(String[] args) {
        int[] bookIDs = {101, 203, 307, 404, 513, 628, 734, 850, 961};
        int searchID = 367;
        int bookIndex = binarySearchForBook(bookIDs, 0, bookIDs.length - 1, searchID);
        if (bookIndex != -1)
            System.out.println("Book with ID " + searchID + " is at index: " + bookIndex);
        else
            System.out.println("Book with ID " + searchID + " not found.");
    }
}