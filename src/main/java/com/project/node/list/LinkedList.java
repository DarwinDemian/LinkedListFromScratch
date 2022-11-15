package com.project.node.list;

import com.project.node.Node;

import java.util.Arrays;
import java.util.List;

public class LinkedList {

    // **************
    // PRIVATE FIELDS
    // **************

    private int counter = 0;
    private Node head;
    private Node lastNode;

    // ************
    // CONSTRUCTORS
    // ************

    public LinkedList() {
    }

    public LinkedList(Object... data) {
        goThroughObject(data);
    }

    // ******************
    // CONSTRUCTOR METHOD
    // ******************

    // Add N objects to this LinkedList
    private void goThroughObject(Object... data) {

        // Go through each argument
        for (Object obj : data) {

            if (obj instanceof List<?>) {

                // if the argument passed is a List, add everything inside it
                for (Object objInsideArr : (List<?>) obj) {
                    add(objInsideArr);
                }

            } else {

                // else just add the Object in the argument
                add(obj);
            }
        }
    }

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
        // can't get an Index with an empty LinkedList
        if (getHead() == null) {
            return null;
        }

        Node nodeRev = getHead();

        // keep going through each Node in LinkedList
        while (nodeRev.getNext() != null) {
            nodeRev = nodeRev.getNext();

            // If the Node index equals the index you passed, return it
            if (nodeRev.getIndex() == index) {
                return nodeRev;
            }
        }

        // if nothing was found, you wanted the first node
        return getHead();
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    // Update all variables necessary
    private void updateVariables(Node nodeToBeAdded, Node nodeRev) {

        setLastNode(nodeToBeAdded);
        nodeRev.setNext(nodeToBeAdded);

        counter++;
        nodeToBeAdded.setIndex(counter);
    }

    // **************
    // PUBLIC METHODS
    // **************

    public void add(Object data) {
        // if the data is already a Node, there is no need to create a new one with it
        // just add the Node instead
        boolean isNode = data instanceof Node;

        if (getHead() == null) {
            setHead(isNode ? (Node) data : new Node(data));
            return;
        }

        Node nodeToBeAdded = isNode ? (Node) data : new Node(data);
        Node nodeRev = getHead();

        while (nodeRev.getNext() != null) {
            nodeRev = nodeRev.getNext();
        }

        updateVariables(nodeToBeAdded, nodeRev);
    }

    // Goes through everything in LinkedList and sys-outs everything inside it
    public String toString() {
        StringBuilder output = new StringBuilder();

        if (getHead() == null) {
            return output.toString();
        }

        Node nodeRev = head;

        while (nodeRev.getNext() != null) {
            valueToString(output, nodeRev);

            nodeRev = nodeRev.getNext();
        }

        valueToString(output, nodeRev);

        return output.toString();
    }

    private static void valueToString(StringBuilder output, Node nodeRev) {
        output.append("[ ");
        Object nodeData = nodeRev.getData();
        String nodeDataAsString = nodeData.toString();

        if (nodeData.getClass().isArray()) {
            nodeDataAsString = Arrays.toString((Object[]) nodeData);
        }

        output.append(nodeDataAsString);
        output.append(" ]");
    }
}
