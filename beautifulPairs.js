// Helper function to calculate the GCD (Greatest Common Divisor)
function gcd(a, b) {
    while (b !== 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// Helper function to extract the first digit of a number
function getFirstDigit(num) {
    while (num >= 10) {
        num = Math.floor(num / 10);
    }
    return num;
}

// Helper function to extract the last digit of a number
function getLastDigit(num) {
    return num % 10;
}

/**
 * @param {number[]} nums
 * @return {number}
 */
var countBeautifulPairs = function(nums) {
    let beautifulPairs = 0;
    
    // Loop through all pairs (i, j) where i < j
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            // Get the first digit of nums[i] and the last digit of nums[j]
            const firstDigit = getFirstDigit(nums[i]);
            const lastDigit = getLastDigit(nums[j]);
            
            // If their GCD is 1, they are coprime and it's a "beautiful pair"
            if (gcd(firstDigit, lastDigit) === 1) {
                beautifulPairs++;
            }
        }
    }
    
    return beautifulPairs;
};

// Example usage:
console.log(countBeautifulPairs([23, 15, 36, 78])); // Output: 5
