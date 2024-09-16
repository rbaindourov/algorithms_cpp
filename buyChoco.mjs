/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
var buyChoco = function(prices, money) {
    // Sort the prices in ascending order
    prices.sort((a, b) => a - b);
    
    // Initialize the minimum sum of prices
    let minSum = Infinity;
    
    // Iterate over the prices to find the minimum sum
    for (let i = 0; i < prices.length - 1; i++) {
      for (let j = i + 1; j < prices.length; j++) {
        // Calculate the sum of the current pair of prices
        const currentSum = prices[i] + prices[j];
        
        // Check if the current sum is less than the minimum sum and does not exceed the money
        if (currentSum < minSum && currentSum <= money) {
          minSum = currentSum;
        }
      }
    }
    
    // If the minimum sum is still infinity, it means we cannot buy two chocolates without going in debt
    if (minSum === Infinity) {
      return money;
    } else {
      // Return the leftover money
      return money - minSum;
    }
  }