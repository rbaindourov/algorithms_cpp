public class Cookies {
    public int findContentChildren(int[] g, int[] s) {
        // Find the maximum greed factor and cookie size to set the range for counting arrays
        int maxGreed = 0;
        for (int greed : g) {
            if (greed > maxGreed) {
                maxGreed = greed;
            }
        }

        int maxSize = 0;
        for (int size : s) {
            if (size > maxSize) {
                maxSize = size;
            }
        }

        // Create counting arrays for greed and cookies
        int[] greedCount = new int[maxGreed + 1];
        int[] sizeCount = new int[maxSize + 1];

        // Fill the greed counting array
        for (int greed : g) {
            greedCount[greed]++;
        }

        // Fill the cookie size counting array
        for (int size : s) {
            sizeCount[size]++;
        }

        // Greedily assign cookies to children
        int contentChildren = 0;
        for (int i = 1; i <= maxSize; i++) {
            while (sizeCount[i] > 0 && contentChildren < greedCount.length) {
                // Check if there are children that can be satisfied
                while (contentChildren < greedCount.length && greedCount[contentChildren] == 0) {
                    contentChildren++;
                }
                if (contentChildren < greedCount.length && contentChildren + 1 <= i) {
                    greedCount[contentChildren]--;
                    sizeCount[i]--;
                } else {
                    break;
                }
            }
        }

        // Count satisfied children
        int satisfied = 0;
        for (int count : greedCount) {
            if (count == 0) {
                satisfied++;
            }
        }

        return satisfied;
    }

    public static void main(String[] args) {
        Cookies cookies= new Cookies();
        int[] g = {1, 2, 3}; // Greed factors
        int[] s = {1, 1}; // Cookie sizes
        System.out.println( cookies.findContentChildren(g, s)); // Output: 1
    }
}
