package problem_4_2;

public class BinaryTree {
    public static final int ARRAY_MODE = 0;
    public static final int LINKED_LIST_MODE = 1;

    private Node topNode;
    private int mode;
    private Node[] nodes;
    private int height;

    public BinaryTree() {
        height = 0;
        topNode = null;
        mode = ARRAY_MODE;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setValues(int [] values) {
        if (mode != ARRAY_MODE) {
            throw new WrongModeException();
        }

        nodes = new Node[values.length];
        height = (int) Math.ceil(logB((nodes.length - 1), 2.0));
        for (int i = 0; i < nodes.length; i++) {
            // 마지막 삽입 위치에서 맨 처음 왼쪽에 넣을 수 있는지 확인
            Node node = new Node(values[i]);
            if (i == 0) {
                nodes[i] = node;
                node.setHeight(0);
                continue;
            }

            nodes[i] = new Node(values[i]);
            nodes[i].setHeight(getHeight(i));
            reorderTree(i);
        }
    }

    private int getHeight(int idx) {
        return (int) Math.ceil(logB((idx - 1), 2.0));
    }

    private void reorderTree(int currentSize) {
        for (int i = currentSize; i >= 0; i--) {
            int currentIdx = i;
            boolean hasWrongPos = false;
            while (hasWrongPos) {
                if (checkLocalPos(currentIdx)) {
                    hasWrongPos = true;
                } else {
                    if (!checkParentNode(currentIdx)) {
                        int parentIdx = getParentIdx(currentIdx);
                        nodes[parentIdx].swap(nodes[currentIdx]);
                        currentIdx = parentIdx;
                        continue;
                    }

                    if (!checkLeftNode(currentIdx)) {
                        int leftIdx = currentIdx * 2 + 1;
                        nodes[leftIdx].swap(nodes[currentIdx]);
                        currentIdx = leftIdx;
                        continue;
                    }

                    int rightIdx = currentIdx * 2 + 2;
                    nodes[rightIdx].swap(nodes[currentIdx]);
                    currentIdx = rightIdx;
                }
            }
        }
    }

    private boolean checkLocalPos(int currentIdx) {
        return checkParentNode(currentIdx) && checkLeftNode(currentIdx) && checkRightNode(currentIdx);
    }

    private boolean checkParentNode(int currentIdx) {
        boolean isLeftNode = currentIdx % 2 == 0;
        int parentIdx = getParentIdx(currentIdx);
        return nodes[parentIdx] == null || (isLeftNode && nodes[parentIdx].getValue() > nodes[currentIdx].getValue()) || (!isLeftNode && nodes[parentIdx].getValue() < nodes[currentIdx].getValue());
    }

    private int getParentIdx(int currentIdx) {
        int parentIdx = currentIdx / 2;
        return parentIdx;
    }

    private boolean checkLeftNode(int currentIdx) {
        int leftIdx = currentIdx * 2 + 1;
        return nodes[leftIdx] == null || nodes[leftIdx].getValue() < nodes[currentIdx].getValue();
    }

    private boolean checkRightNode(int currentIdx) {
        int rightIdx = currentIdx * 2 + 2;
        return nodes[rightIdx] == null || nodes[rightIdx].getValue() < nodes[currentIdx].getValue();
    }

    public double logB(double x, double base) {
        return Math.log(x) / Math.log(base);
    }

    public void printAllNode() {
        if (mode == ARRAY_MODE) {
            for (int i = 0; i < nodes.length; i++) {
                System.out.print(nodes[i].getValue() + " ");
            }
        }
    }

    public void addNode(Node node) {
        if (mode != LINKED_LIST_MODE) {
            throw new WrongModeException();
        }

        if (topNode == null) {
            topNode = node;
            height = node.getHeight();
            return;
        }
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    public void clear() {
        height = 0;
        topNode = null;
    }
}
