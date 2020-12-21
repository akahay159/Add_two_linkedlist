
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2 nodes pointer to point 
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        
        // make a dummy node for the result and a pointer to point it
        ListNode dummy = new ListNode(0);
        ListNode dummyptr = dummy;
        
        //for carry get the variable
        int carry = 0;
        
        //iterate to the end of both of the list
        while(ptr1 != null || ptr2 != null){
            // check the pointer exists and get the value of each pointer
            int first = (ptr1 != null) ? ptr1.val : 0;
            int second = (ptr2 != null) ? ptr2.val : 0;
            
            // add the values with the carry that is remained
            int sum = carry + first + second;
            
            // check the carry wheather it is in 0 or other than 0
            carry = sum/10;
            // creating the new node with the currect value
            dummyptr.next = new ListNode(sum % 10);
            
            if(ptr1 != null){
                ptr1 = ptr1.next;
            }
            if(ptr2 != null){
                ptr2 = ptr2.next;
            }
            dummyptr = dummyptr.next;
            
        }
        // last bound case if the carry is too large then add the carry to the list
        // 9999 + 1 for this case
        if(carry > 0){
            // make the new node and add that to the list
                dummyptr.next = new ListNode(carry); 
        }
        return dummy.next;
    }
}
