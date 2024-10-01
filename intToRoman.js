const intToRoman = function (num) {
    // Define Roman numeral symbols and their corresponding values
    const romanMap = [
        ["M", 1000],
        ["CM", 900],
        ["D", 500],
        ["CD", 400],
        ["C", 100],
        ["XC", 90],
        ["L", 50],
        ["XL", 40],
        ["X", 10],
        ["IX", 9],
        ["V", 5],
        ["IV", 4],
        ["I", 1]
    ];

    let result = "";

    // Iterate over the romanMap
    for (let [symbol, value] of romanMap) {
        // Keep subtracting the value and appending the symbol while the number is >= value
        while (num >= value) {
            result += symbol;
            num -= value;
        }
    }

    return result;
}

debugger;
// Test cases
console.log(intToRoman(1));    // Output: "I"
console.log(intToRoman(4));    // Output: "IV"
console.log(intToRoman(9));    // Output: "IX"
console.log(intToRoman(58));   // Output: "LVIII"
console.log(intToRoman(1994)); // Output: "MCMXCIV"

