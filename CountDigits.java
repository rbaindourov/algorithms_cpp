class CountDigits { 
  static int countDigits(int num) {
    if(num < 10) {
      return 1;
    } else {
      return 1 + countDigits(num / 10); // Recursive execution to count remaining digits
    }
  }

  public static void main(String args[]) {
    System.out.println(countDigits(9876)); 
  }
}