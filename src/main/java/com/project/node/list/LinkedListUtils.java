package com.project.node.list;

import com.project.node.Node;

import java.util.Arrays;
import java.util.Collections;

public final class LinkedListUtils {
    private LinkedListUtils() {
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private static LinkedList reverseLinkedList(LinkedList linkedListReference) {
        LinkedList newLinkedList = new LinkedList();

        for (int i = linkedListReference.getSize(); i >= 0; i--) {
            copyDataToNewList(linkedListReference, newLinkedList, i);
        }

        return newLinkedList;
    }

    private static void copyDataToNewList(LinkedList linkedListReference, LinkedList newLinkedList, int i) {
        Node nodeToBeAdded = linkedListReference.getNodeAtIndex(i);
        final Object nodeData = nodeToBeAdded.getData();

        if (nodeData instanceof LinkedList) {

            newLinkedList.add(getReversedLinkedList((LinkedList) nodeData));

        } else if (nodeData.getClass().isArray()) {

            Object[] copiedArray = objectToArray(nodeData);
            newLinkedList.add(copiedArray);

        } else {

            newLinkedList.add(nodeData);
        }
    }

    private static Object[] objectToArray(final Object nodeData) {
        Object[] convertedNodeData = (Object[]) nodeData;
        Object[] copiedArray = Arrays.copyOf(convertedNodeData, convertedNodeData.length);

        Collections.reverse(Arrays.asList(copiedArray));
        return copiedArray;
    }

    // **************
    // PUBLIC METHODS
    // **************

    public static LinkedList getReversedLinkedList(LinkedList linkedList) {
        return linkedList.getHead() != null ? reverseLinkedList(linkedList) : null;
    }

    public static void getOrderedLinkedList(LinkedList linkedList) {
        // TODO
    }
}