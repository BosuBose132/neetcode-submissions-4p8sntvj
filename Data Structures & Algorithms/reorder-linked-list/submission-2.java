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
    public void reorderList(ListNode head) {
         ListNode fast=head.next, slow=head;
         while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
         }
         ListNode second = slow.next;
         slow.next=null;
         ListNode prev=null;
         while(second !=null){
            ListNode after=second.next;
            second.next=prev;
            prev=second;
            second=after;
         }
            ListNode first=head;
            second=prev;
            while(second != null){
            ListNode temp1=first.next;
            ListNode temp2= second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
            }
    }
}
