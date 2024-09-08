function solution(fractions) {
    return fractions.map(processFraction);
}

function processFraction(fraction) {
    const [frac1, frac2] = fraction.split('+');
    const [num1, den1] = frac1.split('/').map(Number);
    const [num2, den2] = frac2.split('/').map(Number);
    
    const lcm = getLCM(den1, den2);
    const numerator = num1 * (lcm / den1) + num2 * (lcm / den2);
    const denominator = lcm;
    
    const gcd = getGCD(numerator, denominator);
    return `${numerator / gcd}/${denominator / gcd}`;
}

function getGCD(a, b) {
    return b === 0 ? a : getGCD(b, a % b);
}

function getLCM(a, b) {
    return (a * b) / getGCD(a, b);
}

/**
 * Example usage:
 * console.log(solution(["2/6+2/6", "7/10+13/10"]));  // Output: ["2/3", "2/1"]
 */

// ... existing code ...