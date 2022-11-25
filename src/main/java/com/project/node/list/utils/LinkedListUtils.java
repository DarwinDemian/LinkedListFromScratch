package com.project.node.list.utils;

import com.project.node.list.LinkedList;

public final class LinkedListUtils {
    private LinkedListUtils() {
    }

    // **************
    // PUBLIC METHODS
    // **************

    public static LinkedList getReversedLinkedList(LinkedList linkedList) {
        return LinkedListReverse.getReversedLinkedList(linkedList);
    }

    public static LinkedList getOrderedLinkedList(LinkedList linkedList) {
        return LinkedListSort.getOrderedLinkedList(linkedList);
    }
}