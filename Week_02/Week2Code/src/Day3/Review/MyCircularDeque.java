package Day3.Review;

import java.awt.*;

public class MyCircularDeque {
    ListNode start = null;
    ListNode end = null;
    int capacity;
    int size = 0;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k ;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        ListNode createNode = new ListNode(value);
        if (isEmpty()) {
            start = createNode;
            end = createNode;
        }
        else {
            createNode.next = start;
            start.prev =createNode;
            start = createNode;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        ListNode createNode = new ListNode(value);
        if (isEmpty()) {
            start = createNode;
            end = createNode;

        }
        else {
            end.next = createNode;
            createNode.prev =end;
            end = createNode;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size==1) {
            start=null;
            end=null;
            size--;
            return true;
        }
        start = start.next;
        start.prev = null;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size==1) {
            start=null;
            end=null;
            size--;
            return true;
        }
        end = end.prev ;
        end.next =null;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return start.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return end.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size==capacity;
    }

    private class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
