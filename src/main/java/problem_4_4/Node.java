package problem_4_4;

public class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;
    private int subnodeCnt;

    public Node(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
        this.subnodeCnt = 0;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isFull() {
        return leftNode != null && rightNode != null;
    }

    public int getSubnodeCnt() {
        return subnodeCnt;
    }

    public void increaseSubnodeCnt() {
        subnodeCnt++;
    }

    public boolean hasNoSubnode() {
        return leftNode == null && rightNode == null;
    }
}