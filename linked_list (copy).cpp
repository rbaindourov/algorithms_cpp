#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy(0, head);
        ListNode* fast = &dummy;
        ListNode* slow = &dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast->next;
        }

        // Move both pointers
        while (fast) {
            fast = fast->next;
            slow = slow->next;
        }

        // Remove the nth node
        slow->next = slow->next->next;

        return dummy.next;
    }
};

// Function to create a linked list from an array
ListNode* createLinkedList(int arr[], int size) {
    if (size == 0) return nullptr;
    ListNode* head = new ListNode(arr[0]);
    ListNode* current = head;
    for (int i = 1; i < size; i++) {
        current->next = new ListNode(arr[i]);
        current = current->next;
    }
    return head;
}

// Function to print a linked list
void printLinkedList(ListNode* head) {
    while (head) {
        cout << head->val << " -> ";
        head = head->next;
    }
    cout << "NULL" << endl;
}

// Main function for testing
int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);
    int n = 2;  // Remove the 2nd node from the end

    // Create linked list
    ListNode* head = createLinkedList(arr, size);

    cout << "Original List: ";
    printLinkedList(head);

    // Call removeNthFromEnd function
    Solution solution;
    head = solution.removeNthFromEnd(head, n);

    cout << "Updated List: ";
    printLinkedList(head);

    return 0;
}
