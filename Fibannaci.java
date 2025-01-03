import java.util.*;

class Fibannaci {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        if( n == 0) return 0;
        if( n == 1) return 1;
        if( memo.containsKey(n) ) return memo.get(n);
        else
            memo.put(n, fib(n-1) + fib(n-2));
        return memo.get(n);
    }

    //generate test cases
    public static void main(String[] args) {
        Fibannaci obj = new Fibannaci();
        System.out.println(obj.fib(30));
    }
}

