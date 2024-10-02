import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Iterate over possible hours (0 to 11)
        for (int hour = 0; hour < 12; hour++) {
            // Iterate over possible minutes (0 to 59)
            for (int minute = 0; minute < 60; minute++) {
                // Count the number of bits turned on
                int bitsOn = Integer.bitCount(hour) + Integer.bitCount(minute);
                
                // If the total bits on matches the turnedOn count
                if (bitsOn == turnedOn) {
                    // Format the time as "H:MM"
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return result;
    }
}
