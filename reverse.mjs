/**
 * Reverse a given number.
 * @param {number} num - the number to reverse
 * @returns {number} the re versed number
 */
function ReverseNumber(num) {
    let result = 0
    while (num > 0) {
        result = result * 10 + num % 10
        num = Math.floor(num / 10)
    }
    return result

}

/**
 * Reverse a given number.
 * @param {number} num - the number to reverse
 * @returns {number} the re versed number
 */
function ReverseNumber2(num) {  
    return num.toString().split('').reverse().join('');
}
 
console.log(ReverseNumber(12345));

console.time('ReverseNumber');
for (let i = 0; i < 1000000; i++) {
    ReverseNumber(12345);
}
console.timeEnd('ReverseNumber');

console.time('ReverseNumber2');
for (let i = 0; i < 1000000; i++) {
    ReverseNumber2(12345);
}
console.timeEnd('ReverseNumber2');
