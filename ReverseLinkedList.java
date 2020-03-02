/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Time complexity -> O(number of node in the linked List)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        
        ListNode currentPointer = head;
        ListNode previousPointer = null;
        
        ListNode temp;
        while(currentPointer != null){
            temp = currentPointer.next;//storing the next nodes address
            currentPointer.next = previousPointer;//updating the current nodes next pointer to previous node
            previousPointer = currentPointer;// updating the previous node to current node for next iteration
            currentPointer = temp;//updating the current to be current next node for next iteration
        }
        return previousPointer;
    }
}