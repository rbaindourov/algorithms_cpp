#include <iostream>
#include <string>
#include <algorithm> // For std::reverse

class Solution {
public:
    std::string convertToBase7(int num) {
        // Handle negative numbers
        if (num < 0) {
            return "-" + convertToBase7(-num); // Recursively convert the positive value
        }

        // Handle zero case
        if (num == 0) {
            return "0";
        }

        std::string result;
        
        // Convert to base 7
        while (num > 0) {
            result += std::to_string(num % 7); // Append remainder (base 7 digit)
            num = num / 7; // Divide by 7 to shift right
        }

        // Reverse the result because the digits are collected in reverse order
        std::reverse(result.begin(), result.end());

        return result;
    }
};

int main() {
    Solution solution;
    std::cout << solution.convertToBase7(-7) << std::endl; // Output: "-10"
    return 0;
}
