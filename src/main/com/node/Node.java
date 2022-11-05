package com.node;

public class Node {

    // **************
    // PRIVATE FIELDS
    // **************

    private Object data;
    private Node next;
    private int index = 0;

    // ************
    // CONSTRUCTORS
    // ************

    public Node() {}

    public Node(Object data) {
        this.next = null;
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    // *****************
    // GETTERS & SETTERS
    // *****************

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}