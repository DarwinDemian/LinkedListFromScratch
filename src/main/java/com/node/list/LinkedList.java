package java.com.node.list;

import java.com.node.Node;
import java.util.Arrays;

public class LinkedList {

    // **************
    // PRIVATE FIELDS
    // **************

    private int counter = 0;
    private Node head;
    private Node lastNode;

    // *****************
    // GETTERS & SETTERS
    // *****************

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

    // ***************
    // PRIVATE METHODS
    // ***************

    private void updateVariables(Node nodeToBeAdded, Node nodeRev) {
        lastNode = nodeToBeAdded;
        nodeRev.setNext(nodeToBeAdded);
        counter++;
        nodeToBeAdded.setIndex(counter);
    }

    // **************
    // PUBLIC METHODS
    // **************

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        }

        Node nodeToBeAdded = new Node(data);
        Node nodeRev = head;

        while (nodeRev.getNext() != null) {
            nodeRev = nodeRev.getNext();
        }

        updateVariables(nodeToBeAdded, nodeRev);
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
