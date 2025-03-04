#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// Definition for a singly-linked list node
struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

// Comparator for the min-heap (to compare ListNode values)
struct Compare {
    bool operator()(ListNode* a, ListNode* b) {
        return a->val > b->val; // Min-Heap (smallest value first)
    }
};

ListNode* mergeKLists(vector<ListNode*>& lists) {
    // Min-Heap to store the nodes
    priority_queue<ListNode*, vector<ListNode*>, Compare> minHeap;

    // Step 1: Push the head of each linked list into the min-heap
    for (auto list : lists) {
        if (list) { // Only non-empty lists
            minHeap.push(list);
        }
    }

    // Step 2: Create a dummy node to construct the merged linked list
    ListNode* dummy = new ListNode(-1);
    ListNode* current = dummy;

    // Step 3: Pop from heap and build the merged linked list
    while (!minHeap.empty()) {
        ListNode* node = minHeap.top();
        minHeap.pop();

        // Add the smallest node to the result list
        current->next = node;
        current = current->next;

        // If there is a next node for the current list, push it into the heap
        if (node->next) {
            minHeap.push(node->next);
        }
    }

    return dummy->next; // Return the merged linked list
}

// Utility function to print a linked list
void printList(ListNode* head) {
    while (head) {
        cout << head->val << " -> ";
        head = head->next;
    }
    cout << "nullptr" << endl;
}

int main() {
    // Example lists: [[1,4,5], [1,3,4], [2,6]]
    ListNode* list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode* list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode* list3 = new ListNode(2, new ListNode(6));

    vector<ListNode*> lists = {list1, list2, list3};

    ListNode* mergedList = mergeKLists(lists);

    cout << "Merged Linked List: ";
    printList(mergedList);

    return 0;
}