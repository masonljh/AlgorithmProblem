package problem_4_2;

public class BinaryTree {
    private Node topNode;
    private int height;

    BinaryTree() {
        height = 0;
        topNode = null;
    }

    void setValues(int[] values) {
        addNextNode(values, 0, values.length - 1);
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
     * 현재 트리의 정보를 출력하는 메소드(높이, 값들)
     */
    public void printTreeInfo() {
        System.out.println(height);
        printInorder(topNode);
    }

    /**
     * 중위 표기법대로 트리의 값을 탐색하여 출력하는 메소드(
     * @param node 현재 노드
     */
    private void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.getLeftNode());
        System.out.print(node.getValue() + " ");
        printInorder(node.getRightNode());
    }

    /**
     * 트리에 노드를 추가하는 메소드
     * @param node 추가할 노드
     */
    private void addNode(Node node) {
        if (topNode == null) {
            // 처음 노드 추가할 때
            topNode = node;
            height = 1;
            return;
        }

        int currentHeight = 0;      // 삽입할 노드의 현재 높이
        Node currentNode = topNode; // 현재 탐색 중인 노드
        while (true) {
            currentHeight++;
            if (currentNode.getValue() < node.getValue()) {
                // 현재 탐색하고 있는 노드보다 삽입할 노드의 값이 큰 경우(오른쪽 하위 노드로 이동)
                if (currentNode.getRightNode() == null) {
                    // 더 이상 값이 없으므로 넣으면 끝
                    currentNode.setRightNode(node);
                    currentHeight++;
                    updateTreeMaxHeight(currentHeight);
                    return;
                }

                // 오른쪽 하위 노드로 이동
                currentNode = currentNode.getRightNode();
            } else {
                // 현재 탐색하고 있는 노드보다 삽입할 노드의 값이 작은 경우(왼쪽 하위 노드로 이동)
                if (currentNode.getLeftNode() == null) {
                    // 더 이상 값이 없으므로 넣으면 끝
                    currentNode.setLeftNode(node);
                    currentHeight++;
                    updateTreeMaxHeight(currentHeight);
                    return;
                }

                // 왼쪽 하위 노드로 이동
                currentNode = currentNode.getLeftNode();
            }
        }
    }

    /**
     * 현재 트리의 높이를 업데이트하는 메소드
     * @param currentHeight 현재 탐색한 노드의 높이
     */
    private void updateTreeMaxHeight(int currentHeight) {
        if (height < currentHeight) {
            height = currentHeight;
        }
    }
}
