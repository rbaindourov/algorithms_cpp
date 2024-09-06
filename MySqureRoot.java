public class MySqureRoot {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

//generate method isPerfectSquare to check if a number is a perfect square
public boolean isPerfectSquare(int x) {
        if (x < 2) return x == 1;
        
        long left = 2, right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long squareMid = mid * mid;
            if (squareMid == x) return true;
            if (squareMid < x) left = mid + 1;
            else right = mid - 1;
        }
        return false;
}


//Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
public boolean judgeSquareSum(int c) {
    if (c < 2) return true;
    int left = 0, right = (int)Math.sqrt(c);
    while (left <= right) {
        int sum = left * left + right * right;
        if (sum == c) return true;
        if (sum < c) left++;
        else right--;
    }
    return false;
}





    public static void main(String[] args) {
        MySqureRoot mySqrt = new MySqureRoot();
        System.out.println(mySqrt.mySqrt(4));
        System.out.println(mySqrt.mySqrt(8));

        //generate test cases for isPerfectSquare
        System.out.println(mySqrt.isPerfectSquare(16));
        System.out.println(mySqrt.isPerfectSquare(14));
        System.out.println(mySqrt.isPerfectSquare(1));
        System.out.println(mySqrt.isPerfectSquare(0));
        System.out.println(mySqrt.isPerfectSquare(2));
        System.out.println(mySqrt.isPerfectSquare(3));  
    }
}
