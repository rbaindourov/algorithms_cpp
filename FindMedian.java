/* 
 * 
 * 
 * 
 295. Find Median from Data Stream
Hard
Topics
Companies
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation

 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
    */

    import java.util.PriorityQueue;

    class MedianFinder {
    
        // Max-heap to store the smaller half of the numbers
        private PriorityQueue<Integer> low;
        
        // Min-heap to store the larger half of the numbers
        private PriorityQueue<Integer> high;
    
        /** Initialize your data structure here. */
        public MedianFinder() {
            // Max-heap for the smaller half (use reverse order to simulate max-heap)
            low = new PriorityQueue<>((a, b) -> b - a);
            
            // Min-heap for the larger half
            high = new PriorityQueue<>();
        }
    
        /** Adds a number into the data structure. */
        public void addNum(int num) {
            // Add to the max-heap (low)
            low.offer(num);
            
            // Ensure the smallest number in the high heap is larger than the largest number in the low heap
            high.offer(low.poll());
            
            // If low heap has fewer elements than high, rebalance the heaps
            if (low.size() < high.size()) {
                low.offer(high.poll());
            }
        }
    
        /** Returns the median of current data stream. */
        public double findMedian() {
            // If the max-heap (low) has more elements, the median is the top of low
            if (low.size() > high.size()) {
                return low.peek();
            }
            // If both heaps are the same size, the median is the average of the tops of both heaps
            return (low.peek() + high.peek()) / 2.0;
        }

        //generate main method
        public static void main(String[] args) {
            MedianFinder medianFinder = new MedianFinder();
            medianFinder.addNum(1);
            medianFinder.addNum(2);
            System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
            medianFinder.addNum(3);
            System.out.println(medianFinder.findMedian()); // return 2.0
        }
    }

    
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder* obj = new MedianFinder();
     * obj->addNum(num);
     * double param_2 = obj->findMedian();
     */