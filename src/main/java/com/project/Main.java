package com.project;

import com.project.node.list.LinkedList;
import com.project.node.list.LinkedListUtils;

public class Main {

    private static void runDemonstration() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        Integer[] strArr = {6, 7, 8};

        linkedList.add(strArr);

        runSysOut("Single LinkedList", linkedList);

        LinkedList reversedLinkedList = LinkedListUtils.getReversedLinkedList(linkedList);

        runSysOut("Reversed Single LinkedList", reversedLinkedList);

        LinkedList doubleLinkedList = new LinkedList();
        doubleLinkedList.add(9);
        doubleLinkedList.add(10);

        linkedList.add(doubleLinkedList);

        runSysOut("Nested LinkedList", linkedList);

        LinkedList reversedDoubleLinkedList = LinkedListUtils.getReversedLinkedList(linkedList);

        runSysOut("Nested Reversed LinkedList", reversedDoubleLinkedList);
    }

    private static void runSysOut(String linkedListType, LinkedList linkedList) {
        System.out.println();
        System.out.println("========================");
        System.out.println(linkedListType);
        System.out.println(linkedList);
        System.out.println("========================");
        System.out.println();
    }

    public static void main(String[] args) {
        runDemonstration();
    }
}