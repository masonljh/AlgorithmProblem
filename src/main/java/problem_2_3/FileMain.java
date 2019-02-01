package problem_2_3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) {

        String removeNodeName;
        Node firstNode;

        try {
            File file = new File("src/main/java/problem_2_3/input.txt");
            Scanner scanner = new Scanner(file);
            removeNodeName = scanner.next();
            System.out.println("removeNodeName=" + removeNodeName);

            if (!scanner.hasNext()) {
                return;
            }

            Node currentNode = new Node(scanner.next());
            firstNode = currentNode;

            while (scanner.hasNext()) {
                Node nextNode = new Node(scanner.next());
                currentNode.setNextNode(nextNode);
                currentNode = nextNode;
            }

            currentNode = firstNode;
            System.out.println("----------original-----------");
            System.out.print(currentNode.getName() + " ");
            while (currentNode.hasNextNode()) {
                currentNode = currentNode.getNextNode();
                System.out.print(currentNode.getName() + " ");
            }
        } catch (IOException e) {
            return;
        }

        // 첫 번째는 무조건 아니라는 전제 하에 다음 노드부터 담색
        Node currentNode = firstNode;
        while (currentNode.hasNextNode()) {
            Node preNode = currentNode;
            currentNode = currentNode.getNextNode();
            if (!needToRemove(currentNode, removeNodeName)) {
                continue;
            }

            Node nextNode = currentNode.getNextNode();
            currentNode.setNextNode(null);
            preNode.setNextNode(nextNode);
            break;
        }

        currentNode = firstNode;
        System.out.println();
        System.out.println("----------changed-----------");
        System.out.print(currentNode.getName() + " ");
        while (currentNode.hasNextNode()) {
            currentNode = currentNode.getNextNode();
            System.out.print(currentNode.getName() + " ");
        }
    }

    private static boolean needToRemove(Node node, String removeNodeName) {
        return node.getName().equals(removeNodeName);
    }

}