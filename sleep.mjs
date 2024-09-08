/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise(resolve => setTimeout(resolve, millis));
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */


/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let count = n;
    return function() {
        return count++;
    };
};


var createCounter1 = function(n) {
    const generator = (function* () {
        while (true) yield n++;
    })();
    
    return function() {
        return generator.next().value;
    };
};


var createCounter2 = function(n) {
    return () => n++;
};
/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
function reduce(nums, fn, init) {
    let val = init;
    for (let i = 0; i < nums.length; i++) {
        val = fn(val, nums[i]);
    }
    return val;
}

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
const reduce2 = (nums, fn, init) => {
    let val = init;
    nums.forEach(num => val = fn(val, num));
    return val;
};

// Alternative version using for...of loop
const reduceAlt = (nums, fn, init) => {
    let val = init;
    for (const num of nums) {
        val = fn(val, num);
    }
    return val;
};

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
const map = (arr, fn) => {
    const len = arr.length;
    for (let i = 0; i < len; i++) {
        arr[i] = fn(arr[i], i);
    }
    return arr;
};


/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map2 = function(arr, fn) {
    let i = 0, len = arr.length;
    if (len < 32) {
        for (; i < len; i++) {
            arr[i] = fn(arr[i], i);
        }
    } else {
        // Unrolled loop for larger arrays
        for (; i < len - 4; i += 4) {
            arr[i] = fn(arr[i], i);
            arr[i+1] = fn(arr[i+1], i+1);
            arr[i+2] = fn(arr[i+2], i+2);
            arr[i+3] = fn(arr[i+3], i+3);
        }
        // Handle remaining elements
        for (; i < len; i++) {
            arr[i] = fn(arr[i], i);
        }
    }
    return arr;
};


var once = function(fn) {
    let called = false;
    let result;

    return function(...args){
        if(called) return undefined;
        called = true;
        result = fn.apply(this, args);
        return result;
    }
};


/**
 * @param {Function} fn
 * @return {Function}
 */
const once2 = function(fn) {
    let called = false;
    return function(...args){
        if(called) return undefined;
        called = true;
        return fn.apply(this, args);
    }
};


/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
const chunk = (arr, size) => {
    const chunked = [];
    for (let i = 0; i < arr.length; i += size) {
        chunked.push(arr.slice(i, i + size));
    }
    return chunked;
};


/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function(nums) {
    this.arr = nums;
};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function() {
    return this.arr.reduce( (sum, i)=> sum+i , 0)
}

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function() {
    return JSON.stringify( this.arr )
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */


/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
const cancellable = function(fn, args, t) {
    // Store the timeout ID
    let timeoutId = setTimeout(() => {
        fn(...args);
    }, t);

    // Return the cancel function
    return function cancelFn() {
        clearTimeout(timeoutId);
    };
};

/**
 * Example usage:
 * 
 * function fn(x) { console.log(x) }
 * const args = [5], t = 1000, cancelTimeMs = 500
 * const cancel = cancellable(fn, args, t)
 * setTimeout(cancel, cancelTimeMs)
 * 
 * // If cancelTimeMs < t, "5" is not logged to the console
 * // If cancelTimeMs > t, "5" is logged to the console
 */


/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    for( const key in obj )
        return false;
    return true;
};

/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
const sortBy = (arr, fn) => {
    return arr.slice().sort((a, b) => fn(a) - fn(b));
};

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    return (await promise1) + (await promise2) 
 };


 /**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
const addTwoPromises2 = async function(promise1, promise2) {
    const [value1, value2] = await Promise.all([promise1, promise2]);
    return value1 + value2;
};


/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    let arr = functions.reverse();
    return function(x) {
        return arr.reduce( (compistion, fn) => fn(compistion) , x )
    }
};


/**
 * @param {Function[]} functions
 * @return {Function}
 */
const compose2 = functions => x => functions.reduceRight((acc, fn) => fn(acc), x);



var compose3 = function(functions) {    
    return function(x) {
        return functions.reduceRight( (compistion, fn) => fn(compistion) , x )
    }
};
var compose4 = function(functions) {
    return (x) => functions.reduceRight( (compistion, fn) => fn(compistion) , x )
};


/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {

    return this.length ? this[this.length - 1] : -1;
  
  };
  
  /**
   * const arr = [1, 2, 3];
   * arr.last(); // 3
   */


  /**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {number[][]}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    // Check for invalid input
    if (rowsCount * colsCount !== this.length || rowsCount <= 0 || colsCount <= 0) {
        return [];
    }

    // Initialize the 2D array with empty arrays
    const result = Array(rowsCount).fill().map(() => []);
    
    let index = 0;
    for (let col = 0; col < colsCount; col++) {
        if (col % 2 === 0) {
            // Move down for even columns
            for (let row = 0; row < rowsCount; row++) {
                result[row][col] = this[index++];
            }
        } else {
            // Move up for odd columns
            for (let row = rowsCount - 1; row >= 0; row--) {
                result[row][col] = this[index++];
            }
        }
    }

    return result;
};

/**
 * Example usage:
 * const arr = [19, 10, 3, 7, 9, 8, 5, 2, 1, 17, 16, 14, 12, 18, 6, 13, 11, 20, 4, 15];
 * console.log(arr.snail(5, 4));
 */

// ... existing code ...

