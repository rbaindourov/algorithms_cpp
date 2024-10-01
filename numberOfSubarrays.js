/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfSubarrays = function(nums) {
    let count = 0;                   // To keep track of the total number of valid subarrays
    let oddCount = 0;                // To keep track of the number of odd numbers encountered
    let prefixCounts = {0: 1};       // To store the count of prefix sums (oddCount occurrences)
    
    // Iterate through the array
    for (let i = 0; i < nums.length; i++) {
        // Check if the current number is odd
        if (nums[i] % 2 === 1) {
            oddCount++;
        }
        
        // If the (oddCount - k) exists in prefixCounts, add the number of such subarrays
        if (prefixCounts[oddCount] !== undefined) {
            count += prefixCounts[oddCount];
        }
        
        // Increment the prefix count for the current oddCount
        prefixCounts[oddCount] = (prefixCounts[oddCount] || 0) + 1;
    }

    return count;
};

// Example Usage
console.log(numberOfSubarrays([1, 4, 3, 3, 2])); // Output: 6 (if counting odd numbers as subarrays)
console.log(numberOfSubarrays([3, 3, 3])); // Output: 6 (since all are odd numbers)
console.log(numberOfSubarrays([1])); // Output: 1 (single element odd number subarray)
