package LinkedListPractice;

import java.util.Arrays;
import java.util.Collections;

public abstract class LinkedListUtils {
    private LinkedListUtils() {
    }

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

            Object[] convertedNodeData = (Object[]) nodeData;
            Object[] copiedArray = Arrays.copyOf(convertedNodeData, convertedNodeData.length);

            Collections.reverse(Arrays.asList(copiedArray));

            newLinkedList.add(copiedArray);

        } else {

            newLinkedList.add(nodeData);
        }
    }

    public static LinkedList getReversedLinkedList(LinkedList linkedList) {
        LinkedList reversedLinkedList = new LinkedList();

        if (linkedList.getHead() != null) {
            reverseLinkedList(linkedList, reversedLinkedList);
        }

        return reversedLinkedList;
    }

    public static LinkedList getOrderedLinkedList(LinkedList linkedList) {
        LinkedList reversedLinkedList = new LinkedList();

        if (linkedList.getHead() != null) {
            for (int i = linkedList.getSize(); i > 0; i--) {
                reversedLinkedList.add(linkedList.getNodeAtIndex(i).getData());
            }
        }

        return reversedLinkedList;
    }
}