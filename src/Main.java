import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> testList = new LinkedList<>();
        testList.add(0,1);
        testList.add(1,10);
        testList.add(2,10);
        System.out.println(testList.get(1));
        System.out.println(testList.get(2));
        System.out.println(testList.indexOf(10));
        // duplicates allowed in LinkedList



    }
// this will involve partial second looping but since the fast skips some values it doesn't inncrease the
//  number of steps to complete the solution. Only concern is if fast skips over the slow, othrwise as slow is finishing
    // its first pass, fast will be on its second pass
    // lets consider an even and odd length scenario and assume cycle back to index 0
    // {1,2,3,4,5}
    //S=1;F=1, S=2;F=3, S=3;F=5, S=4;F=2, S=5;F=4, S=1;F=1;
    //{1,2,3,4,5,6}
    //S=1;F=1, S=2;F=3, S=3;F=5, S=4;F=1, S=5;F=3, S=6;F=5; S=1,F=1;
    //even or odd fast still catches up on the first index to find the redundancy

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }

            return false;
        }
    }

}




// questions: does a LinkedList allow for duplicates? If not, store values in a map and if any .next value corresponds
// to a key in the map then return the "index" the list cycles to. such as position 1, position 0 (head) etc.
// with map this would also mean needing a counter to increment where head starts at position 0 and increment the count
// for each new node

//option two, use a size feature. querry the size of the linkedList and include a counter in a while loop. where loop
// will run until current.next == null indicating no cycling. Else, if the counter, starting at 1, exceeds the size of
// the list, some cycling has taken place. Now the problem is i know that it cycles, but not where it cycles to. I can
// get the value of an index and I can get the index of a value, but it will default to the first index where that value
// occurs. this strategy will only work if no duplicates allowed

//JUST KIDDING. THIS REQUIRES ONLY A BOOLEAN, NOT THE INDEX, BUT GOOD STUFF TO KNOW!

// new problem. only head is available, not the whole LinkedList and I cant querry the list length without the actual
// collection object