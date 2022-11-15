package linkedlist;

import com.project.exceptions.ParseIntException;
import com.project.node.Node;
import com.project.node.list.LinkedList;
import com.project.node.list.LinkedListUtils;
import helpers.NodeUnitTestHelper;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LinkedListSteps {
    protected LinkedList linkedList;

    // *****
    // GIVEN
    // *****


    @BeforeEach
    protected void given_LinkedListExists() {
        linkedList = new LinkedList();
    }

    protected void given_LinkedListIsConstructedWithNNodes() {
        linkedList = new LinkedList(NodeUnitTestHelper.getNodesWithOrderedDataWithoutNext());
    }

    protected void given_LinkedListIsConstructedWithRandomDataWithArrays() throws ParseIntException {
        boolean withArrays = true;
        linkedList = new LinkedList(NodeUnitTestHelper.getNodesWithRandomData(6, withArrays));
    }

    protected void given_LinkedListIsConstructedWithRandomData() throws ParseIntException {
        boolean withArrays = false;
        List<Node> nodes = NodeUnitTestHelper.getNodesWithRandomData(6, withArrays);
        linkedList = new LinkedList(nodes);
    }

    protected void then_LinkedListWithRandomDataHasDistinctValues() {
        for (int i = 0; i < linkedList.getSize(); i++) {
            Object thisNode = linkedList.getNodeAtIndex(i).getData();
            Object nextNode = linkedList.getNodeAtIndex(i + 1).getData();

            assertNotEquals(thisNode, nextNode);
        }
    }

    protected void given_LinkedListIsConstructedWithNValues() {
        given_LinkedListExists();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
    }

    protected void given_LinkedListIsConstructedWithNValuesWithArray() {
        given_LinkedListExists();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Object[] intArr = {4, 5};
        linkedList.add(intArr);
    }

    protected void given_NestedLinkedListIsConstructedWithNValuesWithArray() {
        given_LinkedListIsConstructedWithNValuesWithArray();

        linkedList.add(new LinkedList(6, 7));
    }


    // ****
    // WHEN
    // ****

    protected void when_LinkedListIsReversed() {
        this.linkedList = LinkedListUtils.getReversedLinkedList(this.linkedList);
    }

    // ****
    // THEN
    // ****

    protected void then_NestedReversedLinkedListWithArrayHasTheCorrectValues() {
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

    protected void then_ReversedLinkedListWithArrayHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(3).getData());
        assertEquals(2, linkedList.getNodeAtIndex(2).getData());
        assertEquals(3, linkedList.getNodeAtIndex(1).getData());

        Object[] intArr = {5, 4};
        assertEquals(Arrays.toString(intArr), Arrays.toString((Object[]) linkedList.getNodeAtIndex(0).getData()));
    }

    protected void then_ReversedLinkedListConstructorHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(2).getData());
        assertEquals(2, linkedList.getNodeAtIndex(1).getData());
        assertEquals(3, linkedList.getNodeAtIndex(0).getData());
    }

    protected void then_NewLinkedListConstructorHasTheCorrectValues() {
        assertEquals(1, linkedList.getNodeAtIndex(0).getData());
        assertEquals(2, linkedList.getNodeAtIndex(1).getData());
        assertEquals(3, linkedList.getNodeAtIndex(2).getData());
    }
}