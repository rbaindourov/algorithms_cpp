import java.util.HashMap;
import java.util.Map;   
import java.util.List;

    class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


class Solution {
    public int romanToInt(String s) {
        int result=0;
        int prevValue=0;

        HashMap<Character, Integer> lookup = new HashMap<>();
        lookup.put('I',1);
        lookup.put('V',5);
        lookup.put('X',10);
        lookup.put('L',50);
        lookup.put('C',100);
        lookup.put('D',500);
        lookup.put('M',1000);
        
        for( int i = s.length() -1; i>=0; i--){
            char currentChar = s.charAt(i);
            int currentValue = lookup.get(currentChar);
            if( currentValue < prevValue){
                result -= currentValue;
            }else{
                result += currentValue;
            }
            prevValue = currentValue;

        }
        return result;
        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        }else if(list2 != null){
            current.next = list2;
        }
        return dummy.next;


     
        
    }


}

//test cases
public class RomanNumerals {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("III")); // 3
        System.out.println(sol.romanToInt("IV")); // 4
        System.out.println(sol.romanToInt("IX")); // 9
        System.out.println(sol.romanToInt("LVIII")); // 58
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = sol.mergeTwoLists(list1, list2);
        while(mergedList != null){
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}           

//test cases
                