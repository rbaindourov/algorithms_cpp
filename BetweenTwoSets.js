function getTotalX(a, b) {
    // Helper function to compute GCD (Greatest Common Divisor)
    const gcd = (x, y) => {
        while (y !== 0) {
            [x, y] = [y, x % y];
        }
        return x;
    };

    // Helper function to compute LCM (Least Common Multiple)
    const lcm = (x, y) => (x * y) / gcd(x, y);

    // Find the LCM of all elements in array 'a'
    const lcmOfA = a.reduce((acc, curr) => lcm(acc, curr));

    // Find the GCD of all elements in array 'b'
    const gcdOfB = b.reduce((acc, curr) => gcd(acc, curr));

    // Now we need to find how many multiples of lcmOfA divide gcdOfB
    let count = 0;
    let multiple = lcmOfA;
    
    while (multiple <= gcdOfB) {
        if (gcdOfB % multiple === 0) {
            count++;
        }
        multiple += lcmOfA;
    }

    return count;
}

getTotalX([2, 4], [16, 32, 96]);