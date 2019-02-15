package problem_4_1;

import com.sun.istack.internal.Nullable;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private Node [] nodes;      // 노드 배열
    private int currentSize;    // 노드를 넣어야할 인덱스
    List<Node> currentPath;     // 현재 경로(LinkedList를 쓰는 이유는 삽입, 삭제가 빈번하게 일어나기 때문)

    public Graph(int n) {
        this.nodes = new Node[n];
        this.currentSize = 0;
    }

    /**
     * 노드를 추가하는 메소드
     * @param node 추가할 노드
     */
    public void addNode(Node node) {
        nodes[currentSize] = node;
        currentSize++;
    }

    /**
     * 경로 데이터를 추가하는 메소드
     * @param start 시작 노드 인덱스
     * @param end 끝 노드 인덱스
     */
    public void addPath(int start, int end) {
        nodes[start].setHasWay(end);
    }

    /**
     * 경로의 존재 여부를 확인하는 메소드
     * @param start 시작 노드 인덱스
     * @param end 끝 노드 인덱스
     * @return 경로가 존재하는지 여부
     */
    public boolean searchPath(int start, int end) {
        Node startNode = nodes[start];
        Node endNode = nodes[end];
        currentPath = new LinkedList<>();
        currentPath.add(startNode);
        startNode.setVisited(true);
        printCurrentPath();

        // 현재 경로가 비어있다면 경로를 못 찾은 경우임
        while (!currentPath.isEmpty()) {
            int lastIdx = currentPath.size() - 1;
            Node nextNode = getConnectedNode(currentPath.get(lastIdx));
            if (nextNode == null) {
                // 갈 수 있는 노드가 없는 경우 다시 이전 노드가 경로의 마지막으로 됨
                currentPath.remove(lastIdx);
                printCurrentPath();
                continue;
            }

            // 현재 경로에 추가
            currentPath.add(nextNode);
            nextNode.setVisited(true);

            printCurrentPath();

            if (nextNode.getName().equals(endNode.getName())) {
                // 만약 도착지라면 그대로 찾았음을 알리고 종료
                return true;
            }
        }

        // 못 찾은 경우
        return false;
    }

    /**
     * 현재 경로를 출력하는 메소드
     */
    private void printCurrentPath() {
        for (Node node : currentPath) {
            System.out.print(node.getName() + " ");
        }

        System.out.println();
    }

    /**
     * 현재 노드와 연결된 노드를 찾는 메소드
     * @param currentNode 현재 노드
     * @return 연결된 노드
     */
    @Nullable
    private Node getConnectedNode(Node currentNode) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isVisited() || !currentNode.hasWay(i)) {
                // 이미 방문한 노드이거나 현재 노드와 연결되지 않았다면 무시
                continue;
            }

            // 갈 수 있는 노드
            return nodes[i];
        }

        return null;
    }

    /**
     * 현재 가지고 있는 노드들을 출력하는 메소드
     */
    public void printAllNodes() {
        System.out.println("nodeCnt= " + nodes.length);
        for (Node node : nodes) {
            System.out.println(node.getName() + " / " + node.getValue());
        }
    }
}
