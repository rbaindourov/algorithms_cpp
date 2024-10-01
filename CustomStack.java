class CustomStack {
    int[] stack;
    int size;
    int max;

    
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.size = 0;
        this.max = maxSize;
    }
    
    public void push(int x) {
        if( size < max ){
            stack[size] = x;
            size++;
        }
    }
    
    public int pop() {
        if(size > 0){
         return stack[--size];
        } 
        return -1;
    }
    
    public void increment(int k, int val) {
        for (int i = Math.min(size, k) - 1; i >= 0; i--) {
            stack[i] += val;  // Increment the top k elements
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */