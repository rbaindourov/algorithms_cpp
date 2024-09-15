/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let carry = 1;
    for(let i = digits.length-1; i >= 0; i--){
        digits[i] = digits[i] + carry;
        carry = Math.floor(digits[i]/10);
        digits[i] = digits[i] % 10;
    }
    if(carry > 0)
        digits.unshift(carry);
    return digits;
}

console.log(plusOne([1,2,3]));
console.log(plusOne([4,3,2,1]));
console.log(plusOne([9]));
console.log(plusOne([9,9,9]));
console.log(plusOne([9,9,9,9]));
