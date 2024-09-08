
/*


You have an array p of points on a Cartesian plane. Find and return the minimum possible Euclidian distance between two points with different indices in p.

Example

For p = [[0, 11], [-7, 1], [-5, -3]], the output should be
solution(p) = 4.472135955.

Input/Output

[execution time limit] 4 seconds (js)

[memory limit] 1 GB

[input] array.array.integer p

Every inner array p[i] contains exactly 2 integers: the x and y coordinates of the ith point.

Guaranteed constraints:
2 ≤ p.length ≤ 2 · 104,
p[i].length = 2,
|p[i][j]| ≤ 107.

[output] float

The minimum possible distance between two points with different indices in p.

Your answer will be considered correct if its absolute error doesn't exceed 10-5.
*/



function solution(p) {
    // Sort points by x-coordinate
    p.sort((a, b) => a[0] - b[0]);
    return closestPair(p, 0, p.length - 1);
}

function closestPair(p, left, right) {
    if (right - left <= 3) {
        return bruteForce(p, left, right);
    }

    const mid = Math.floor((left + right) / 2);
    const midX = p[mid][0];
    const dl = closestPair(p, left, mid);
    const dr = closestPair(p, mid + 1, right);
    let d = Math.min(dl, dr);

    const strip = [];
    for (let i = left; i <= right; i++) {
        if (Math.abs(p[i][0] - midX) < d) {
            strip.push(p[i]);
        }
    }

    return Math.min(d, stripClosest(strip, d));
}

function stripClosest(strip, d) {
    strip.sort((a, b) => a[1] - b[1]);
    let min = d;
    for (let i = 0; i < strip.length; i++) {
        for (let j = i + 1; j < strip.length && (strip[j][1] - strip[i][1]) < min; j++) {
            min = Math.min(min, distance(strip[i], strip[j]));
        }
    }
    return min;
}

function bruteForce(p, left, right) {
    let min = Infinity;
    for (let i = left; i < right; i++) {
        for (let j = i + 1; j <= right; j++) {
            min = Math.min(min, distance(p[i], p[j]));
        }
    }
    return min;
}

function distance(p1, p2) {
    return Math.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2);
}

/**
 * Example usage:
 * console.log(solution([[0, 11], [-7, 1], [-5, -3]]));  // Output: approximately 4.472135955
 */

// ... existing code ...