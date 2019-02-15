package problem_4_1;

public class Node {
    private String name;
    private int value;
    private boolean [] hasWayArray;
    private boolean isVisited;

    public Node(String name, int value, int nodeCnt) {
        this.name = name;
        this.value = value;
        this.hasWayArray = new boolean[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            this.hasWayArray[i] = false;
        }
        this.isVisited = false;
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

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
