package com.project.node.list.utils;

import com.project.algorithms.MergeSort;
import com.project.node.list.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LinkedListSort {
    private LinkedListSort() {
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private static LinkedList orderLinkedList(LinkedList linkedListReference) {
        // add everything in a single int[]
        Integer[] linkedListAsIntArr = getLinkedListAsIntArr(linkedListReference);

        // mergeSort it
        MergeSort.mergeSort(linkedListAsIntArr);

        // return rebuilt linkedList in order
        return rebuildOrderedLinkedList(linkedListReference, linkedListAsIntArr);
    }

    private static Integer[] getLinkedListAsIntArr(LinkedList linkedList) {
        List<Integer> intList = new ArrayList<>();
        addDataToList(intList, linkedList);

        return intList.toArray(new Integer[0]);
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

    private static LinkedList rebuildOrderedLinkedList(LinkedList reference, Integer[] data) {
        LinkedList rebuiltLinkedList = new LinkedList();
        int dataIndex = 0;

        for (int i = 0; i <= reference.getSize(); i++) {
            Object referenceData = reference.getNodeAtIndex(i).getData();

            if (referenceData.getClass().isArray()) {
                dataIndex = addArrayToRebuiltLinkedList(data, rebuiltLinkedList, dataIndex, (Integer[]) referenceData);
            } else if (referenceData instanceof LinkedList) {
                dataIndex = addLinkedListToRebuiltLinkedList(data, rebuiltLinkedList, dataIndex, (LinkedList) referenceData);
            } else {
                rebuiltLinkedList.add(data[dataIndex]);
                dataIndex++;
            }
        }

        return rebuiltLinkedList;
    }

    private static int addLinkedListToRebuiltLinkedList(Integer[] data, LinkedList rebuiltLinkedList, int dataIndex, LinkedList referenceData) {
        int length = referenceData.getSize();
        LinkedList linkedListReference = new LinkedList();

        for (int j = 0; j <= length; j++) {
            linkedListReference.add(data[dataIndex]);
            dataIndex++;
        }

        rebuiltLinkedList.add(linkedListReference);
        return dataIndex;
    }

    private static int addArrayToRebuiltLinkedList(Integer[] data, LinkedList rebuiltLinkedList, int dataIndex, Integer[] referenceData) {
        int length = referenceData.length;
        Integer[] arrReference = new Integer[length];

        for (int j = 0; j < length; j++) {
            arrReference[j] = data[dataIndex];
            dataIndex++;
        }

        rebuiltLinkedList.add(arrReference);
        return dataIndex;
    }

    // **************
    // PUBLIC METHODS
    // **************

    public static LinkedList getOrderedLinkedList(LinkedList linkedList) {
        return linkedList.getHead() != null ? orderLinkedList(linkedList) : null;
    }
}
