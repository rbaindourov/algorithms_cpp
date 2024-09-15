    class Calculator {
        value = 0;
        /** 
         * @param {number} value
         */
        constructor(value) {
            this.value = value
            return this
        }
        
        /** 
         * @param {number} value
         * @return {Calculator}
         */
        add(value){
            this.value += value
            return this
        }
        
        /** 
         * @param {number} value
         * @return {Calculator}
         */
        subtract(value){
            this.value= this.value - value
            return this
        }
        
        /** 
         * @param {number} value
         * @return {Calculator}
         */  
        multiply(value) {
            this.value=this.value * value
            return this
        }
        
        /** 
         * @param {number} value
         * @return {Calculator}
         */
        divide(value) {
            if (value === 0) {
                throw new Error("Division by zero is not allowed");
            }
            this.value =  this.value / value
            return this
        }
        
        /** 
         * @param {number} value
         * @return {Calculator}
         */
        power(value) {
            this.value = this.value ** value
            return this
        }
        
        /** 
         * @return {number}
         */
        getResult() {
            return this.value
        }
}

const calculator = new Calculator(10);
console.log(calculator.add(5).subtract(3).multiply(2).divide(2).power(2).getResult()); // 27

const calculator2 = new Calculator(10);
console.log(calculator2.add(5).subtract(3).multiply(2).divide(2).power(2).getResult()); // 27


/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let count = init;
    const increment =  _ => ++count;
    const decrement = _ => --count;
    const reset = _ => count = init;

    return {
        increment,
        decrement,
        reset
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */


/**
 * @return {Function}
 */
const createHelloWorld = _ => 
    _ => "Hello World";


/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */