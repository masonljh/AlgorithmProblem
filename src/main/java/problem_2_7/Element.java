package problem_2_7;

public class Element {

    Node node;
    Element nextElement;

    Node getNode() {
        return node;
    }

    void setNode(Node node) {
        this.node = node;
    }

    Element getNextElement() {
        return nextElement;
    }

    void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    boolean hasNextElement() {
        return nextElement != null;
    }
}
