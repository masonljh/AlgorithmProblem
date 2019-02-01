package problem_2_4;

class Node {
    private int value;
    private Node nextNode;

    Node(int value) {
        nextNode = null;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    Node getNextNode() {
        return nextNode;
    }

    void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    boolean hasNextNode() {
        return nextNode != null;
    }
}
