package problem_2_3;

class Node {
    private String name;
    private Node nextNode;

    Node(String name) {
        nextNode = null;
        this.name = name;
    }

    String getName() {
        return name;
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
