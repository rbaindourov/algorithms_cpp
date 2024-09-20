function shortestPalindrome(s) {
    const n = s.length;
    
    if (n === 0) return s;
    
    // Reverse the string
    const rev = s.split('').reverse().join('');
    
    // Create a new string with original + special character + reverse
    const combined = s + "#" + rev;
    
    // Create lps (longest prefix suffix) array for KMP algorithm
    const lps = new Array(combined.length).fill(0);
    
    // Fill the LPS array (similar to the KMP preprocessing step)
    for (let i = 1; i < combined.length; i++) {
        let j = lps[i - 1];
        
        while (j > 0 && combined[i] !== combined[j]) {
            j = lps[j - 1];
        }
        
        if (combined[i] === combined[j]) {
            j++;
        }
        
        lps[i] = j;
    }
    
    // lps[combined.length - 1] gives us the length of the longest palindromic prefix
    const longestPalindromePrefixLength = lps[combined.length - 1];
    
    // Add the reverse of the remaining non-palindromic part at the beginning
    const suffixToAdd = s.slice(longestPalindromePrefixLength).split('').reverse().join('');
    
    return suffixToAdd + s;
}

// Example 1
console.log(shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"

// Example 2
console.log(shortestPalindrome("abcd")); // Output: "dcbabcd"
