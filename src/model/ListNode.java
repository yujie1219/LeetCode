package model;

public class ListNode {
    public int val;
    public int position;
    public int height;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int height, int position) {
        this.position = position;
        this.height = height;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
