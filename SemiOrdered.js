/**
 * @param {number[]} nums
 * @return {number}
 */
const semiOrderedPermutation = (nums) => {
    let n = nums.length;
    
    // Find the indices of 1 and n
    let idx1 = nums.indexOf(1);
    let idxN = nums.indexOf(n);
    
    // Calculate the number of swaps to move 1 to the start and n to the end
    let movesToFront = idx1; // Swaps to move 1 to index 0
    let movesToEnd = (n - 1) - idxN; // Swaps to move n to index n-1
    
    // If 1 is before n in the original array, no adjustment needed
    // If 1 is after n, moving 1 shifts n's position to the left by 1, so we reduce one swap
    if (idx1 > idxN) {
        return movesToFront + movesToEnd - 1;
    } else {
        return movesToFront + movesToEnd;
    }
};
