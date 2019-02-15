package problem_4_1;

public class Node {
    private String name;
    private int value;
    private boolean [] hasWayArray;

    public Node(String name, int value, int nodeCnt) {
        this.name = name;
        this.value = value;
        this.hasWayArray = new boolean[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            hasWayArray[i] = false;
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean hasWay(int nodeNum) {
        return hasWayArray[nodeNum];
    }

    public void setHasWay(int end) {
        hasWayArray[end] = true;
    }
}
