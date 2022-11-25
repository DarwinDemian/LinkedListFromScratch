package com.project;

import com.project.node.list.LinkedList;
import com.project.node.list.LinkedListUtils;

import java.util.Arrays;

public class Main {

    private static void runDemonstration() {
        LinkedList linkedList = new LinkedList(1, 2, 3, 4, 5);

        Integer[] strArr = {6, 7, 8};

        linkedList.add(strArr);

        runSysOut("Single LinkedList", linkedList);

        LinkedList reversedLinkedList = LinkedListUtils.getReversedLinkedList(linkedList);

        runSysOut("Reversed Single LinkedList", reversedLinkedList);

        LinkedList doubleLinkedList = new LinkedList(9, 10);

        linkedList.add(doubleLinkedList);

        runSysOut("Nested LinkedList", linkedList);

        LinkedList reversedDoubleLinkedList = LinkedListUtils.getReversedLinkedList(linkedList);

        runSysOut("Nested Reversed LinkedList", reversedDoubleLinkedList);
    }

    private static void runSysOut(String linkedListType, LinkedList linkedList) {
        System.out.println();
        System.out.println("========================");
        System.out.println(linkedListType);
        System.out.println(linkedList.toString());
        System.out.println("========================");
        System.out.println();
    }

    public static void main(String[] args) {
        runDemonstration();
    }
}