//use the stack to back traverse the linked list
//a traditional way to create one linkedlist in the reverse order

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;

        while((!s1.empty())||(!s2.empty())){
            int val1 = (!s1.empty())?s1.pop():0;
            int val2 = (!s2.empty())?s2.pop():0;
            int sum = carry + val1 + val2;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = head;
            head = newNode;
            carry = sum/10;
        }

        if(carry == 0)
            return head;
        else{
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
            return head;
        }
    }
}