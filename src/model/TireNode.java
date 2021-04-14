package model;

public class TireNode {
    // 26个字母
    private TireNode[] children;
    private boolean isEnd;

    public TireNode() {
        this.children = new TireNode[26];
        isEnd = false;
    }

    public void addChild(Character ch) {
        this.children[ch - 'a'] = new TireNode();
    }

    public TireNode getChild(Character ch) {
        return this.children[ch - 'a'];
    }

    public TireNode[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd() {
        this.isEnd = true;
    }
}
