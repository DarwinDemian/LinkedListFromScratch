package com.node.list;

import java.util.Arrays;
import java.util.Collections;

import com.node.Node;

public final class LinkedListUtils {
    private LinkedListUtils() {
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private static void reverseLinkedList(LinkedList linkedListReference, LinkedList newLinkedList) {
        for (int i = linkedListReference.getSize(); i > 0; i--) {
            copyDataToNewList(linkedListReference, newLinkedList, i);
        }
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

    public static final LinkedList getReversedLinkedList(LinkedList linkedList) {
        LinkedList reversedLinkedList = new LinkedList();

        if (linkedList.getHead() != null) {
            reverseLinkedList(linkedList, reversedLinkedList);
        }

        return reversedLinkedList;
    }

    public static final void getOrderedLinkedList(LinkedList linkedList) {
        // TODO
    }
}