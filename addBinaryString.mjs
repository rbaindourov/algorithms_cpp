/*
Given two binary strings a and b, add them together and return the resulting string.

Example

For a = "1000" and b = "111", the output should be
solution(a, b) = "1111";
For a = "1" and b = "1", the output should be
solution(a, b) = "10".
*/


function solution(a, b) {
    let result = '';
    let carry = 0;
    let i = a.length - 1;
    let j = b.length - 1;
    
    while (i >= 0 || j >= 0 || carry > 0) {
        const digitA = i >= 0 ? parseInt(a[i]) : 0;
        const digitB = j >= 0 ? parseInt(b[j]) : 0;
        
        const sum = digitA + digitB + carry;
        result = (sum % 2) + result;
        carry = Math.floor(sum / 2);
        
        i--;
        j--;
    }
    
    return result;
}

/**
 * Example usage:
 * console.log(solution("1000", "111"));  // Output: "1111"
 * console.log(solution("1", "1"));       // Output: "10"
 */

// ... existing code ...