package problem_4_5;

public class BinaryTree {
    public static final int BINARY_SEARCH_MODE = 1;
    public static final int BALANCED_MODE = 2;
    public static final int UNBALANCED_MODE = 3;

    private Node rootNode;                      // 루트 노드(트리의 최상단)

    public BinaryTree() {
        rootNode = null;
    }

    /**
     * 트리에 값을 세팅하는 메소드
     * @param values    값들
     * @param mode      생성 방법(균형, 불균형)
     */
    public void setValues(int [] values, int mode) {
        if (mode == BINARY_SEARCH_MODE) {
            addNextNode(values, 0, values.length - 1);
            return;
        }

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

    /**
     * 해당 영역에서 중간값을 추출하여 노드로 추가하는 메소드
     * @param values 데이터 배열
     * @param start 영역의 시작 위치
     * @param end 영역의 끝 위치
     */
    private void addNextNode(int[] values, int start, int end) {
        if (start == end) {
            /*
             * 시작과 끝이 같으면 더 이상 해당 영역에서는 넣을 수 없으므로
             * 해당 노드만 추가하고 끝
             */
            Node node = new Node(values[start]);
            addNode(node);
            return;
        }

        /*
         * 로직
         * 1. 중간값을 추출 후 바로 노드에 넣음(이진 탐색 트리에서 중간값이 부모 노드가 됨)
         * 2. 시작 위치 ~ 중간 위치(미포함) 영역에서 확인(재귀호출)
         * 3. 중간 위치(미포함) ~ 끝 위치 영역에서 확인(재귀호출)
         */
        int mid = (start + end) / 2;
        Node midNode = new Node(values[mid]);
        addNode(midNode);
        addNextNode(values, start, mid - 1);
        addNextNode(values, mid + 1, end);
    }

    /**
     * 트리에 노드를 추가하는 메소드
     * @param node 추가할 노드
     */
    private void addNode(Node node) {
        if (rootNode == null) {
            // 처음 노드 추가할 때
            rootNode = node;
            return;
        }

        Node currentNode = rootNode; // 현재 탐색 중인 노드
        while (true) {
            if (currentNode.getValue() < node.getValue()) {
                // 현재 탐색하고 있는 노드보다 삽입할 노드의 값이 큰 경우(오른쪽 하위 노드로 이동)
                if (currentNode.getRightNode() == null) {
                    // 더 이상 값이 없으므로 넣으면 끝
                    currentNode.setRightNode(node);
                    return;
                }

                // 오른쪽 하위 노드로 이동
                currentNode = currentNode.getRightNode();
            } else {
                // 현재 탐색하고 있는 노드보다 삽입할 노드의 값이 작은 경우(왼쪽 하위 노드로 이동)
                if (currentNode.getLeftNode() == null) {
                    // 더 이상 값이 없으므로 넣으면 끝
                    currentNode.setLeftNode(node);
                    return;
                }

                // 왼쪽 하위 노드로 이동
                currentNode = currentNode.getLeftNode();
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

    public boolean isBinarySearchTree() {
        return checkInorder(rootNode);
    }

    /**
     * 중위 탐색법을 통해 이진 탐색 트리인지 확인하는 메소드
     * @param node 현재 노드
     */
    private boolean checkInorder(Node node) {
        if (node == null) {
            return true;
        }

        boolean isBinarySearchTree = true;

        if (node.getLeftNode() != null && node.getLeftNode().getValue() > node.getValue()) {
            isBinarySearchTree = false;
        }

        if (node.getRightNode() != null && node.getRightNode().getValue() < node.getValue()) {
            isBinarySearchTree = false;
        }

        return isBinarySearchTree && (checkInorder(node.getLeftNode()) && checkInorder(node.getRightNode()));
    }
}
