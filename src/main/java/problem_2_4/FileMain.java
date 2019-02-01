package problem_2_4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) {

        Node firstNode;
        int x;

        // 입력
        try {
            File file = new File("src/main/java/problem_2_4/input.txt");
            Scanner scanner = new Scanner(file);
            x = scanner.nextInt();
            System.out.println("x=" + x);

            if (!scanner.hasNext()) {
                return;
            }

            boolean isExistX = false;
            firstNode = new Node(scanner.nextInt());
            Node currentNode = firstNode;
            while (scanner.hasNext()) {
                Node nextNode = new Node(scanner.nextInt());
                currentNode.setNextNode(nextNode);
                currentNode = nextNode;

                if (currentNode.getValue() == currentNode.getValue()) {
                    isExistX = true;
                }
            }

            currentNode = firstNode;
            System.out.println("----------original-----------");
            System.out.print(currentNode.getValue() + " ");
            printNodes(currentNode);

            if (!isExistX) {
                System.out.println("----------result-----------");
                System.out.print(currentNode.getValue() + " ");
                printNodes(currentNode);
                return;
            }
        } catch (IOException e) {
            return;
        }

        Node resultFirstNode = getResultFirstNode(firstNode, x);
        System.out.println("----------result-----------");
        System.out.print(resultFirstNode.getValue() + " ");
        printNodes(resultFirstNode);
    }

    private static Node getResultFirstNode(Node firstNode, int x) {
        Node smallGroupFirstNode = null;
        Node smallGroupLastNode = null;
        Node sameOrBigGroupFirstNode = null;
        Node sameOrBigGroupLastNode = null;

        Node currentNode = firstNode;
        if (currentNode.getValue() < x) {
            smallGroupFirstNode = currentNode;
            smallGroupLastNode = currentNode;
        } else {
            sameOrBigGroupFirstNode = currentNode;
            sameOrBigGroupLastNode = currentNode;
        }

        while (currentNode.hasNextNode()) {
            Node nextNode = currentNode.getNextNode();
            currentNode = nextNode;
            if (nextNode.getValue() < x) {
                if (smallGroupFirstNode == null) {
                    smallGroupFirstNode = nextNode;
                    smallGroupLastNode = nextNode;
                } else {
                    if (sameOrBigGroupLastNode != null) {
                        sameOrBigGroupLastNode.setNextNode(null);
                    }
                    smallGroupLastNode.setNextNode(nextNode);
                    smallGroupLastNode = smallGroupLastNode.getNextNode();
                }
            } else {
                if (sameOrBigGroupFirstNode == null) {
                    sameOrBigGroupFirstNode = nextNode;
                    sameOrBigGroupLastNode = nextNode;
                } else {
                    if (smallGroupLastNode != null) {
                        smallGroupLastNode.setNextNode(null);
                    }
                    sameOrBigGroupLastNode.setNextNode(nextNode);
                    sameOrBigGroupLastNode = sameOrBigGroupLastNode.getNextNode();
                }
            }
        }

        if (smallGroupLastNode != null) {
            smallGroupLastNode.setNextNode(sameOrBigGroupFirstNode);
        }

        return smallGroupFirstNode == null ? sameOrBigGroupFirstNode : smallGroupFirstNode;
    }

    private static void printNodes(Node currentNode) {
        while (currentNode.hasNextNode()) {
            currentNode = currentNode.getNextNode();
            System.out.print(currentNode.getValue() + " ");
        }
        System.out.println();
    }
}