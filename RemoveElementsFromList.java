/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.HashSet;
import java.util.Set;

class RemoveElementsFromList {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (numSet.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    // Test cases
    public static void main(String[] args) {
        RemoveElementsFromList solution = new RemoveElementsFromList();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = solution.modifiedList(nums1, head1);
        printList("Test case 1:", result1);

        // Test case 2
        int[] nums2 = {2, 4};
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result2 = solution.modifiedList(nums2, head2);
        printList("Test case 2:", result2);

        // Test case 3
        int[] nums3 = {1, 5};
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result3 = solution.modifiedList(nums3, head3);
        printList("Test case 3:", result3);
    }

    private static void printList(String testCase, ListNode head) {
        System.out.print(testCase + " ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}