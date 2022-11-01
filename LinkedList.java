package LinkedListPractice;
import java.util.Arrays;

public class LinkedList {
    private int counter = 0;
    private Node head;
    private Node lastNode;

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        }

        Node nodeToBeAdded = new Node(data);
        Node nodeRev = head;

        if (nodeRev != null) {
            while (nodeRev.getNext() != null) {
                nodeRev = nodeRev.getNext();
            }

            lastNode = nodeToBeAdded;
            nodeRev.setNext(nodeToBeAdded);
            counter++;
            nodeToBeAdded.setIndex(counter);
        }
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return counter;
    }

    public Node getNodeAtIndex(int index) {
        if (head != null) {
            Node nodeRev = head;

            while (nodeRev.getNext() != null) {
                nodeRev = nodeRev.getNext();

                if (nodeRev.getIndex() == index) {
                    return nodeRev;
                }
            }

            return head;
        }

        return null;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        if (head != null) {
            Node nodeRev = head;

            while (nodeRev.getNext() != null) {
                nodeRev = nodeRev.getNext();
                Object nodeData = nodeRev.getData();
                String nodeDataAsString = nodeData.toString();

                output.append("[ ");

                if (nodeData.getClass().isArray()) {
                    nodeDataAsString = Arrays.asList((Object[]) nodeData).toString();
                } 

                output.append(nodeDataAsString);
                output.append(" ]");
            }
        }

        return output.toString();
    }
}
