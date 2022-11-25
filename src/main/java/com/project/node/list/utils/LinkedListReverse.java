package com.project.node.list.utils;

import com.project.node.Node;
import com.project.node.list.LinkedList;

import java.util.Arrays;
import java.util.Collections;

public final class LinkedListReverse {
    private LinkedListReverse() {
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
        return linkedList.getHead() != null ? LinkedListReverse.reverseLinkedList(linkedList) : null;
    }
}
