package LinkedListPractice;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        Integer[] strArr = { 6, 7, 8 };

        linkedList.add(strArr);

        System.out.println();
        System.out.println("========================");
        System.out.println("Single Linked List:");
        System.out.println(linkedList.toString());
        System.out.println("========================");
        System.out.println();

        LinkedList reversedLinkedList = LinkedListUtils.getReversedLinkedList(linkedList);

        System.out.println();
        System.out.println("========================");
        System.out.println("Reversed Single Linked List:");
        System.out.println(reversedLinkedList.toString());
        System.out.println("========================");
        System.out.println();

        LinkedList doubleLinkedList = new LinkedList();
        doubleLinkedList.add(9);
        doubleLinkedList.add(10);

        linkedList.add(doubleLinkedList);

        System.out.println();
        System.out.println("========================");
        System.out.println("Nested Linked List:");
        System.out.println(linkedList.toString());
        System.out.println("========================");
        System.out.println();

        LinkedList reversedDoubleLinkedList = LinkedListUtils.getReversedLinkedList(linkedList);

        System.out.println();
        System.out.println("========================");
        System.out.println("Nested Reversed Linked List:");
        System.out.println(reversedDoubleLinkedList.toString());
        System.out.println("========================");
        System.out.println();

    }
}