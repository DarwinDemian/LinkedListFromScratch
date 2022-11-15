package node;

import com.project.node.Node;
import helpers.NodeUnitTestHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeUnitTest {
    private final List<Node> nodeList = NodeUnitTestHelper.getNodesWithOrderedData();
    private final Node thirdNode = nodeList.get(2);
    private final Node secondNode = nodeList.get(1);
    private final Node node = nodeList.get(0);

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
        assertNull(thirdNode.getNext());
    }

}
