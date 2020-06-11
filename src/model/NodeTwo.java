package model;

public class NodeTwo {
    public int val;
    public NodeTwo left;
    public NodeTwo right;
    public NodeTwo next;

    public NodeTwo() {
    }

    public NodeTwo(int _val) {
        val = _val;
    }

    public NodeTwo(int _val, NodeTwo _left, NodeTwo _right, NodeTwo _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
