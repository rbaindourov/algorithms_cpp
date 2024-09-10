 

import java.time.LocalDate;

/**
 * FindDay
 */
public class FindDay {

    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().name();
    }
    
    //generate a main method to test the findDay method
    public static void main(String[] args) {
        System.out.println(findDay(8, 5, 2015));
    }    
}




