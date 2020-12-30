package model;

public class BinaryNodeWithNext {
    public int val;
    public BinaryNodeWithNext left;
    public BinaryNodeWithNext right;
    public BinaryNodeWithNext next;

    public BinaryNodeWithNext() {
    }

    public BinaryNodeWithNext(int _val) {
        val = _val;
    }

    public BinaryNodeWithNext(int _val, BinaryNodeWithNext _left, BinaryNodeWithNext _right, BinaryNodeWithNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
