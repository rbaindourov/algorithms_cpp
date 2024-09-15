import java.util.HashSet;

public class DifferentNumbers {
    public int numDifferentIntegers(String word) {
        HashSet<String> unique = new HashSet<>(); // Use String to preserve leading zeros
        StringBuilder currentNum = new StringBuilder();

        for (char c : word.toCharArray()) { // Iterate through each character
            if (Character.isDigit(c)) {
                currentNum.append(c); // Build the current number
            } else {
                if (currentNum.length() > 0) {
                    unique.add(currentNum.toString().replaceFirst("^0+", "")); // Add the number without leading zeros
                    currentNum.setLength(0); // Reset for the next number
                }
            }
        }
        if (currentNum.length() > 0) {
            unique.add(currentNum.toString().replaceFirst("^0+", "")); // Add the last number if exists
        }

        return unique.size(); // Return the count of unique integers
    }
    public static void main(String[] args) {
        DifferentNumbers dn = new DifferentNumbers();
        System.out.println(dn.numDifferentIntegers("a123bc34d8ef34"));  // Output: 3
        System.out.println(dn.numDifferentIntegers("leet1234code234"));  // Output: 2
        System.out.println(dn.numDifferentIntegers("a1b01c001"));  // Output: 1
    }
}