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
    public ListNode removeNthFromEnd(ListNode head, int n) {
            
            ListNode temp= head;
            ListNode dummy= new ListNode(0);
            dummy.next=head;
            ListNode prev=dummy;
            while (n>0){
                temp=temp.next;
                n--;
            }
            while(temp !=null){
                prev=prev.next;
                temp=temp.next;
            }
            prev.next=prev.next.next;
            return dummy.next;
    }
}

