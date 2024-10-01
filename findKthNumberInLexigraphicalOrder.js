/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var findKthNumber = function(n, k) {
    let curr = 1;
    k--; // We're looking for the k-th number (0-indexed)
    
    while (k > 0) {
        let steps = countSteps(n, curr, curr + 1);
        if (steps <= k) {
            curr++;  // Move to the next prefix
            k -= steps;
        } else {
            curr *= 10;  // Go deeper in the current prefix
            k--;
        }
    }
    
    return curr;
};

// Function to count the steps between two prefixes
function countSteps(n, curr, next) {
    let steps = 0;
    while (curr <= n) {
        steps += Math.min(n + 1, next) - curr;
        curr *= 10;
        next *= 10;
    }
    return steps;
}

console.log( findKthNumber( 100,90 ));

function lexicalOrder(n) {
    let result = [];
    
    function dfs(curr) {
        if (curr > n) return;
        result.push(curr);
        for (let i = 0; i <= 9; i++) {
            let next = curr * 10 + i;
            if (next > n) break;
            dfs(next);
        }
    }
    
    for (let i = 1; i <= 9; i++) {
        dfs(i);
    }
    
    return result;
}

// Example usage:
console.log(lexicalOrder(100));  // Output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
console.log(lexicalOrder(2));   // Output: [1, 2]
