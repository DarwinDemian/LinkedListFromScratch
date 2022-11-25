package linkedlist;

import com.project.exceptions.ParseIntException;
import com.project.node.Node;
import com.project.node.list.LinkedList;
import com.project.node.list.utils.LinkedListUtils;
import helpers.NodeUnitTestHelper;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    protected void given_LinkedListIsConstructedWithUnorderedData() throws ParseIntException {
        // 1 2 3
        Integer[] intArr = { 1, 3, 2};
        // 4 5 6
        linkedList = new LinkedList(6, 4, 5);
        linkedList.add(intArr);
        // 7 8 9
        linkedList.add(new LinkedList(9, 7, 8));
    }


    protected void given_LinkedListIsConstructedWithNValues() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
    }

    protected void given_LinkedListIsConstructedWithNValuesWithArray() {
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

    protected void when_LinkedListIsOrdered() {
        this.linkedList = LinkedListUtils.getOrderedLinkedList(this.linkedList);
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

    protected void then_LinkedListWithRandomDataHasDistinctValues() {
        for (int i = 0; i < linkedList.getSize(); i++) {
            Object thisNode = linkedList.getNodeAtIndex(i).getData();
            Object nextNode = linkedList.getNodeAtIndex(i + 1).getData();

            assertNotEquals(thisNode, nextNode);
        }
    }

    // as of right now, I'm not going to worry about sorting Strings
    // string sorting should be:
    // ints -> strings (alphabetical order)
    protected void then_LinkedListWithUnorderedDataIsOrdered() {

        assertEquals(1, linkedList.getNodeAtIndex(0).getData());
        assertEquals(2, linkedList.getNodeAtIndex(1).getData());
        assertEquals(3, linkedList.getNodeAtIndex(2).getData());

        Integer[] intArr = (Integer[]) linkedList.getNodeAtIndex(3).getData();
        assertEquals(4, intArr[0]);
        assertEquals(5, intArr[1]);
        assertEquals(6, intArr[2]);

        LinkedList nestedLinkedList = (LinkedList) linkedList.getNodeAtIndex(4).getData();

        assertEquals(7, nestedLinkedList.getNodeAtIndex(0).getData());
        assertEquals(8, nestedLinkedList.getNodeAtIndex(1).getData());
        assertEquals(9, nestedLinkedList.getNodeAtIndex(2).getData());
    }

    // TODO: randomly ordered linked list
    protected void assertRandomOrderedContent(LinkedList linkedList) {
        for (int i = 0; i < linkedList.getSize(); i++) {
            Object thisNode = linkedList.getNodeAtIndex(i).getData();
            Object nextNode = linkedList.getNodeAtIndex(i + 1).getData();

            if (thisNode instanceof LinkedList) {
                assertRandomOrderedContent((LinkedList) thisNode);
            } else if (thisNode.getClass().isArray()) {
                assertRandomOrderedIntArray((Integer[]) thisNode);
            } else {
                assertTrue((Integer) thisNode >= (Integer) nextNode);
            }
        }
    }

    protected void assertRandomOrderedIntArray(Integer[] objArr) {
        for (int i = 0; i < objArr.length - 1; i++) {
            assertTrue(objArr[i] >= objArr[i + 1]);
        }
    }


}