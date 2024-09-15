/*
You are given an integer array nums containing distinct numbers, and you can perform the following operations until the array is empty:

If the first element has the smallest value, remove it
Otherwise, put the first element at the end of the array.
Return an integer denoting the number of operations it takes to make nums empty.

 

Example 1:

Input: nums = [3,4,-1]
Output: 5

Example 2:
Input: nums = [1,2,4,3]
Output: 5
*/


/**
 * @param {number[]} nums
 * @return {number}
 */
const countOperationsToEmptyArray = (nums) => {
    const n = nums.length;
    const positions = new Map();
    
    // Store the initial positions of each number
    nums.forEach((num, index) => positions.set(num, index));
    
    // Sort the numbers
    nums.sort((a, b) => a - b);
    
    let operations = 0;
    let prevPosition = -1;
    
    for (const num of nums) {
        let currentPosition = positions.get(num);
        
        // If the current position is less than the previous,
        // it means we've wrapped around the array
        if (currentPosition < prevPosition) {
            currentPosition += n;
        }
        
        // Add the number of steps to reach this position
        operations += currentPosition - prevPosition;
        
        // Update the previous position
        prevPosition = currentPosition % n;
    }
    
    return operations;
};

// Test cases
console.log(countOperationsToEmptyArray([3,4,-1])); // Should output 5
console.log(countOperationsToEmptyArray([1,2,4,3])); // Should output 5
console.log(countOperationsToEmptyArray([1,2,3])); // Should output 3
console.log(countOperationsToEmptyArray([1,3,2])); // Should output 3
console.log(countOperationsToEmptyArray([1,3,2,2])); // This case is invalid as numbers should be distinct
