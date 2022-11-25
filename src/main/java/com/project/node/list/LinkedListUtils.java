package com.project.node.list;

import com.project.node.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    private static void addDataToList(List<Integer> intList, LinkedList linkedList) {
        for (int i = 0; i <= linkedList.getSize(); i++) {
            Object nodeData = linkedList.getNodeAtIndex(i).getData();

            if (nodeData instanceof LinkedList) {
                addDataToList(intList, (LinkedList) nodeData);
            } else if (nodeData.getClass().isArray()) {
                intList.addAll(Arrays.asList((Integer[]) nodeData));
            } else {
                intList.add((Integer) nodeData);
            }
        }
    }

    private static Integer[] getLinkedListAsIntArr(LinkedList linkedList) {
        List<Integer> intList = new ArrayList<>();
        addDataToList(intList, linkedList);

        return intList.toArray(new Integer[0]);
    }

    private static void mergeSort(Integer[] intArr) {
        int arrLength = intArr.length;

        if (arrLength < 2) {
            return;
        }

        int midIndex = arrLength / 2;
        Integer[] leftHalf = getLeftHalf(intArr, midIndex);
        Integer[] rightHalf = getRightHalf(intArr, midIndex);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(intArr, leftHalf, rightHalf);
    }

    public static void merge(Integer[] reference, Integer[] leftHalf, Integer[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                reference[k] = leftHalf[i];
                i++;
            } else {
                reference[k] = rightHalf[j];
                j++;
            }

            k++;
        }


        cleanUp(reference, leftHalf, leftSize, i, k);
        cleanUp(reference, rightHalf, rightSize, j, k);
    }

    private static void cleanUp(Integer[] reference, Integer[] half, int halfSize, int i, int k) {
        while (i < halfSize) {
            reference[k] = half[i];
            i++;
            k++;
        }
    }

    public static Integer[] getLeftHalf(Integer[] reference, int midIndex) {
        Integer[] leftHalf = new Integer[midIndex];

        System.arraycopy(reference, 0, leftHalf, 0, midIndex);

        return leftHalf;
    }

    public static Integer[] getRightHalf(Integer[] reference, int midIndex) {
        Integer[] rightHalf = new Integer[reference.length - midIndex];

        if (reference.length - midIndex >= 0) {
            System.arraycopy(reference, midIndex, rightHalf, 0, reference.length - midIndex);
        }

        return rightHalf;
    }

    private static LinkedList orderLinkedList(LinkedList linkedListReference) {
        // add everything in a single int[]
        Integer[] linkedListAsIntArr = getLinkedListAsIntArr(linkedListReference);

        // mergeSort it
        mergeSort(linkedListAsIntArr);

        // return rebuilt linkedList in order
        return rebuildOrderedLinkedList(linkedListReference, linkedListAsIntArr);
    }

    private static LinkedList rebuildOrderedLinkedList(LinkedList reference, Integer[] data) {
        LinkedList rebuiltLinkedList = new LinkedList();
        int dataIndex = 0;

        for (int i = 0; i <= reference.getSize(); i++) {
            Object referenceData = reference.getNodeAtIndex(i).getData();

            if (referenceData.getClass().isArray()) {
                int length = ((Integer[]) referenceData).length;
                Integer[] arrReference = new Integer[length];

                for (int j = 0; j < length; j++) {
                    arrReference[j] = data[dataIndex];
                    dataIndex++;
                }

                rebuiltLinkedList.add(arrReference);

            } else if (referenceData instanceof LinkedList) {
                int length = ((LinkedList) referenceData).getSize();
                LinkedList linkedListReference = new LinkedList();

                for (int j = 0; j <= length; j++) {
                    linkedListReference.add(data[dataIndex]);
                    dataIndex++;
                }

                rebuiltLinkedList.add(linkedListReference);

            } else {
                rebuiltLinkedList.add(data[dataIndex]);
                dataIndex++;
            }
        }

        return rebuiltLinkedList;
    }


    public static LinkedList getOrderedLinkedList(LinkedList linkedList) {
        return linkedList.getHead() != null ? orderLinkedList(linkedList) : null;
    }
}