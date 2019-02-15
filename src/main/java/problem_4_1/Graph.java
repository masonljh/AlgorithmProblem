package problem_4_1;

public class Graph {
    private Node [] nodes;
    private int currentSize;

    public Graph(int n) {
        this.nodes = new Node[n];
        this.currentSize = 0;
    }

    public void addNode(Node node) {
        nodes[currentSize] = node;
        currentSize++;
    }

    public void addPath(int start, int end) {
        nodes[start].setHasWay(end);
    }

    public boolean searchPath(int start, int end) {
        Node startNode = nodes[start];
        Node endNode = nodes[end];


        return false;
    }

    public void printAllNodes() {
        System.out.println("nodeCnt= " + nodes.length);
        for (Node node : nodes) {
            System.out.println(node.getName() + " / " + node.getValue());
        }
    }
}
