package Day1.Day1Review;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        UseRecursion
        if (head==null||head.next==null){
            return head ;
        }
        ListNode curr = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return curr;
    }
}
