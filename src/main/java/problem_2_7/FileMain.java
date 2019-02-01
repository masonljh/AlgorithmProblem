package problem_2_7;

import java.util.Random;

public class FileMain {

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int n = randomGenerator.nextInt(30) + 1;
        int p = randomGenerator.nextInt(n) + 1;
        int m = randomGenerator.nextInt(30) + 1;
        int q = randomGenerator.nextInt(m) + 1;

        System.out.println("n=" + n + " / m=" + m + " / p=" + p + " / q=" + q);

        Element firstOfFirstList = new Element();
        Element firstOfSecondList = new Element();

        // 1은 중복되는 노드로 표현
        Node duplicatedNode = new Node(1);

        createList(firstOfFirstList, n, p, duplicatedNode);
        createList(firstOfSecondList, m, q, duplicatedNode);

        System.out.println("현재 리스트");
        printList(firstOfFirstList);
        printList(firstOfSecondList);

        Element intersectionElement = getIntersectionElement(firstOfFirstList, firstOfSecondList);
        System.out.println(intersectionElement == null ? "교집합 원소가 존재하지 않습니다." : intersectionElement.getNode().getValue());
    }

    private static Element getIntersectionElement(Element firstOfFirstList, Element firstOfSecondList) {
        Element currentElementOfFirstList = firstOfFirstList;
        Element currentElementOfSecondList = firstOfSecondList;
        while (true) {
            while (true) {
                if (currentElementOfFirstList.getNode() == currentElementOfSecondList.getNode()) {
                    return currentElementOfFirstList;
                }

                if (!currentElementOfSecondList.hasNextElement()) {
                    break;
                }

                currentElementOfSecondList = currentElementOfSecondList.getNextElement();
            }

            currentElementOfSecondList = firstOfSecondList;

            if (!currentElementOfFirstList.hasNextElement()) {
                break;
            }

            currentElementOfFirstList = currentElementOfFirstList.getNextElement();
        }
        return null;
    }

    private static void printList(Element firstOfList) {
        Element currentElement = firstOfList;
        while (currentElement.hasNextElement()) {
            System.out.print(currentElement.getNode().getValue() + " ");
            currentElement = currentElement.getNextElement();
        }

        System.out.println();
    }

    private static void createList(Element firstOfList, int size, int position, Node duplicatedNode) {
        Element currentElement = firstOfList;
        for (int i = 0; i < size; i++) {
            if (i == position - 1) {
                currentElement.setNode(duplicatedNode);
            } else {
                currentElement.setNode(new Node(0));
            }

            Element nextElement = new Element();
            currentElement.setNextElement(nextElement);
            currentElement = nextElement;
        }
    }
}