package problem_4_3;

import java.util.*;

public class BinaryTree {
    private Node rootNode;                      // 루트 노드(트리의 최상단)
    private Map<Integer, List<Node>> depthMap;  // 같은 깊이의 노드 리스트를 저장하는 맵

    public BinaryTree() {
        rootNode = null;
        depthMap = new HashMap<>();
    }

    /**
     * 트리에 값을 세팅하는 메소드
     * @param values
     */
    public void setValues(int [] values) {
        for (int value : values) {
            addNode(rootNode, value);
        }
    }

    private void addNode(Node currentNode, int value) {
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
        addNode(currentNode, value);
    }

    /**
     * 같은 깊이의 노드를 리스트로 연결시켜 맵에 넣어놓는 메소드
     */
    public void chainningEqualDepth() {
        int depth = 1;
        depthMap.clear();
        while (true) {
            List<Node> nodeList = getNodeListOfDepth(rootNode, 1, depth);
            // 해당 깊이의 노드리스트를 맵에 등록함
            depthMap.put(depth, nodeList);

            if (nodeList.isEmpty()) {
                break;
            }
            depth++;
        }
    }

    /**
     * 해당 깊이의 노드 리스트를 반환하는 메소드
     * @param currentNode   현재 탐색 중인 노드
     * @param currentDepth  현재 깊이
     * @param depth         최종 깊이
     * @return              해당 깊이의 노드 리스트
     */
    private List<Node> getNodeListOfDepth(Node currentNode, int currentDepth, int depth) {
        List<Node> nodeList = new ArrayList<>();
        if (currentDepth > depth) {
            return nodeList;
        }

        if (currentDepth == depth) {
            // 해당 깊이의 노드이므로 추가 후 리턴
            nodeList.add(currentNode);
            return nodeList;
        }

        if (currentNode.getLeftNode() != null) {
            // 왼쪽 자식 노드가 비어있지 않다면 탐색해서 리스트에 추가
            nodeList.addAll(getNodeListOfDepth(currentNode.getLeftNode(), currentDepth + 1, depth));
        }

        if (currentNode.getRightNode() != null) {
            // 오른쪽 자식 노드가 비어있지 않다면 탐색해서 리스트에 추가
            nodeList.addAll(getNodeListOfDepth(currentNode.getRightNode(), currentDepth + 1, depth));
        }

        return nodeList;
    }

    public void printAllDepth() {
        int depth = 1;
        while (true) {
            List<Node> nodeList = depthMap.get(depth);
            if (nodeList == null || nodeList.isEmpty()) {
                break;
            }

            System.out.print(depth + "번째 깊이의 노드들 : ");
            for (Node node : nodeList) {
                System.out.print(node.getValue() + " ");
            }
            System.out.println();

            depth++;
        }
    }
}
