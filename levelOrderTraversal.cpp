#include <boost/property_tree/ptree.hpp>
#include <iostream>
#include <string>
#include <queue>
using namespace std;

void levelOrder(const boost::property_tree::ptree& tree) {
    std::queue<boost::property_tree::ptree> q;
    q.push(tree);

    while (!q.empty()) {
        int levelSize = q.size();
        while (levelSize > 0) {
            boost::property_tree::ptree current = q.front();
            q.pop();

            // Print the value at the current level
            auto val = current.get_value<std::string>("");
            if (val != "")
                std::cout << current.get_value<std::string>("")<<" ";

            // Add children nodes to the queue
            for (const auto& node : current) {
                q.push(node.second);
            }
            --levelSize;
        }
        std::cout << std::endl;  // Newline after printing one level
    }
}

int main() {
    // Create a Boost property tree
    boost::property_tree::ptree tree;

    // Insert elements to mimic a binary tree
    tree.put("root.value", "10");

    // Left child
    tree.put("root.left.value", "5");
    tree.put("root.left.left.value", "3");
    tree.put("root.left.right.value", "7");

    // Right child
    tree.put("root.right.value", "15");
    tree.put("root.right.right.value", "20");

    levelOrder(tree);

    return 0;
}
