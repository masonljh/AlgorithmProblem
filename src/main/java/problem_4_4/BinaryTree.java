package problem_4_4;

public class BinaryTree {
    public static final int BALANCED_MODE = 1;
    public static final int UNBALANCED_MODE = 2;

    private Node rootNode;                      // 루트 노드(트리의 최상단)
    private int mode;

    public BinaryTree() {
        rootNode = null;
    }

    /**
     * 트리에 값을 세팅하는 메소드
     * @param values    값들
     * @param mode
     */
    public void setValues(int [] values, int mode) {
        for (int value : values) {
            switch (mode) {
                case BALANCED_MODE:
                    addNodeInBalancedWay(rootNode, value);
                    break;
                case UNBALANCED_MODE:
                    addNodeInUnbalancedWay(rootNode, value);
                    break;
            }
        }
    }

    private void addNodeInUnbalancedWay(Node currentNode, int value) {
        Node node = new Node(value);
        if (currentNode == null) {
            // 루트 노드가 비어있다면 루트 노드로 추가
            rootNode = node;
            return;
        }

        // 왼쪽 자식 노드 확인 후 없으면 삽입
        if (currentNode.getLeftNode() == null) {
            currentNode.setLeftNode(node);
            currentNode.increaseSubnodeCnt();
            return;
        }

        // 오른쪽 자식 노드 확인 후 없으면 삽입
        if (currentNode.getRightNode() == null) {
            currentNode.setRightNode(node);
            currentNode.increaseSubnodeCnt();
            return;
        }

        // 둘 다 있으면 왼쪽 자식 노드으로 이동
        currentNode = currentNode.getLeftNode();
        addNodeInUnbalancedWay(currentNode, value);
    }

    private void addNodeInBalancedWay(Node currentNode, int value) {
        Node node = new Node(value);
        if (currentNode == null && rootNode == null) {
            // 루트 노드가 비어있다면 루트 노드로 추가
            rootNode = node;
            return;
        }

        if (currentNode == null) {
            // 현재 탐색 중인 위치가 비어있다면 해당 위치에 추가
            currentNode = node;
            return;
        }

        // 왼쪽 자식 노드 확인 후 없으면 삽입
        if (currentNode.getLeftNode() == null) {
            currentNode.setLeftNode(node);
            currentNode.increaseSubnodeCnt();
            return;
        }

        // 오른쪽 자식 노드 확인 후 없으면 삽입
        if (currentNode.getRightNode() == null) {
            currentNode.setRightNode(node);
            currentNode.increaseSubnodeCnt();
            return;
        }

        // 자식 노드가 꽉 찼으면 왼쪽 자식 노드로 이동 후 삽입 메소드 호출(재귀)
        Node leftNode = currentNode.getLeftNode();
        Node rightNode = currentNode.getRightNode();
        if (leftNode.isFull()) {
            // 왼쪽 노드가 가득 찼다면
            if (rightNode.isFull()) {
                // 오른쪽 노드가 가득 찼다면 자식 노드 개수를 비교해서 어디로 갈지 정함
                currentNode = leftNode.getSubnodeCnt() < rightNode.getSubnodeCnt() ? leftNode : rightNode;
            } else {
                // 오른쪽 노드가 가득 차지 않았다면 오른쪽 노드 탐색
                currentNode = rightNode;
            }
        } else {
            // 왼쪽 노드가 가득 차지 않았다면 왼쪽 노드 탐색
            currentNode = leftNode;
        }

        // 현재 탐색 중인 노드로 다시 추가
        currentNode.increaseSubnodeCnt();
        addNodeInBalancedWay(currentNode, value);
    }

    public boolean isBalanced() {
        return isBalanced(rootNode);
    }

    private boolean isBalanced(Node currentNode) {
        if (currentNode == null) {
            return true;
        }

        int leftDept = getDepth(currentNode.getLeftNode(), 1);
        int rightDept = getDepth(currentNode.getRightNode(), 1);
        return isBalanced(currentNode.getLeftNode()) && isBalanced(currentNode.getRightNode()) && Math.abs(leftDept - rightDept) <= 1;
    }

    private int getDepth(Node currentNode, int currentDepth) {
        if (currentNode == null) {
            return currentDepth - 1;
        }

        if (currentNode.hasNoSubnode()) {
            return currentDepth;
        }

        int leftDepth = getDepth(currentNode.getLeftNode(), currentDepth + 1);
        int rightDepth = getDepth(currentNode.getRightNode(), currentDepth + 1);

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
