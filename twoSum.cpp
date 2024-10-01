#include <iostream> 
#include <vector>
#include <unordered_map>

using namespace std;


vector<int> twoSum(vector<int>& nums, int target) {

    unordered_map<int, int> num_map;
    for (int i = 0; i < nums.size(); i++) {
        int complement = target - nums[i];
        if (num_map.find(complement) != num_map.end()) {
            return {num_map[complement], i};
        }
        num_map[nums[i]] = i;
    }
    return {};
}



std::vector<int> twoSum2(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> map;  // Stores number and its index

    for (int i = 0; i < nums.size(); i++) {
        int complement = target - nums[i];
        
        // Check if complement exists in the map
        if (map.find(complement) != map.end()) {
            return { map[complement], i };
        }

        // Add the current number to the map
        map[nums[i]] = i;
    }

    // Return an empty vector if no solution is found (should not happen as per problem)
    return {};
}

int main() {
    std::vector<int> nums = {2, 7, 11, 15};
    int target = 9;

    std::vector<int> result = twoSum(nums, target);

    if (!result.empty()) {
        std::cout << "Indices: " << result[0] << ", " << result[1] << std::endl;
    } else {
        std::cout << "No solution found." << std::endl;
    }

    return 0;
}
