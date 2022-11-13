package linkedlist;

import com.project.node.list.LinkedList;
import com.project.node.list.LinkedListUtils;
import helpers.NodeUnitTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListUnitTest {
    private LinkedList linkedList;

    private void given_LinkedListExists() {
        linkedList = new LinkedList();
    }

    private void when_LinkedListIsConstructedWithNNodes() {
        linkedList = new LinkedList(NodeUnitTestHelper.getNodesWithOrderedDataWithoutNext());
    }

    private void when_LinkedListIsConstructedWithNValues() {
        linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
    }

    private void when_LinkedListIsConstructedWithNValuesWithArray() {
        linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Object[] intArr = {4, 5};
        linkedList.add(intArr);
    }

    private void when_NestedLinkedListIsConstructedWithNValuesWithArray() {
        when_LinkedListIsConstructedWithNValuesWithArray();

        linkedList.add(new LinkedList(6, 7));
    }

    private void then_NestedReversedLinkedListWithArrayHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(4).getData());
        assertEquals(2, linkedList.getNodeAtIndex(3).getData());
        assertEquals(3, linkedList.getNodeAtIndex(2).getData());

        Object[] intArr = {5, 4};
        assertEquals(Arrays.toString(intArr), Arrays.toString((Object[]) linkedList.getNodeAtIndex(1).getData()));

        LinkedList expectedLinkedList = new LinkedList(7, 6);
        LinkedList actualLinkedList = (LinkedList) linkedList.getNodeAtIndex(0).getData();
        assertEquals(expectedLinkedList.getNodeAtIndex(0).getData(), actualLinkedList.getNodeAtIndex(0).getData());
        assertEquals(expectedLinkedList.getNodeAtIndex(1).getData(), actualLinkedList.getNodeAtIndex(1).getData());
    }

    private void given_LinkedListIsReversed() {
        this.linkedList = LinkedListUtils.getReversedLinkedList(this.linkedList);
    }

    private void then_ReversedLinkedListWithArrayHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(3).getData());
        assertEquals(2, linkedList.getNodeAtIndex(2).getData());
        assertEquals(3, linkedList.getNodeAtIndex(1).getData());

        Object[] intArr = {5, 4};
        assertEquals(Arrays.toString(intArr), Arrays.toString((Object[]) linkedList.getNodeAtIndex(0).getData()));
    }

    private void then_ReversedLinkedListConstructorHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(2).getData());
        assertEquals(2, linkedList.getNodeAtIndex(1).getData());
        assertEquals(3, linkedList.getNodeAtIndex(0).getData());
    }

    private void then_NewLinkedListConstructorHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(0).getData());
        assertEquals(2, linkedList.getNodeAtIndex(1).getData());
        assertEquals(3, linkedList.getNodeAtIndex(2).getData());
    }

    @Test
    public void test_LinkedListConstructorWithNNodes() {
        when_LinkedListIsConstructedWithNNodes();
        then_NewLinkedListConstructorHasTheCorrectValues();
    }

    @Test
    public void test_LinkedListConstructorWithNValues() {
        when_LinkedListIsConstructedWithNValues();
        then_NewLinkedListConstructorHasTheCorrectValues();
    }


    @Test
    public void test_LinkedListConstructorWithNValuesReversed() {
        when_LinkedListIsConstructedWithNValues();
        given_LinkedListIsReversed();
        then_ReversedLinkedListConstructorHasTheCorrectValues();
    }

    @Test
    public void test_LinkedListWithArrayWithNValuesReversed() {
        when_LinkedListIsConstructedWithNValuesWithArray();
        given_LinkedListIsReversed();
        then_ReversedLinkedListWithArrayHasTheCorrectValues();
    }

    @Test
    public void test_NestedLinkedListWithArrayWithNValuesReversed() {
        when_NestedLinkedListIsConstructedWithNValuesWithArray();
        given_LinkedListIsReversed();
        then_NestedReversedLinkedListWithArrayHasTheCorrectValues();
    }


}
