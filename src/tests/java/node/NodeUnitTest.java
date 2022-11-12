package tests.java.node;

import static org.junit.Assert.assertEquals;

import java.com.node.Node;
import java.util.List;

import org.junit.Test;

import tests.java.helpers.NodeUnitTestHelper;

public class NodeUnitTest {
    private List<Node> nodeList = NodeUnitTestHelper.getNodesWithOrderedData();

    private Node thirdNode = nodeList.get(2);
    private Node secondNode = nodeList.get(1);
    private Node node = nodeList.get(0);

    @Test
    public void testNodeData() {
        assertEquals(1, node.getData());
        assertEquals(2, secondNode.getData());
        assertEquals(3, thirdNode.getData());
    }

    @Test
    public void testNextNode() {
        assertEquals(secondNode, node.getNext());
        assertEquals(thirdNode, secondNode.getNext());
        assertEquals(null, thirdNode.getNext());
    }

}
