package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.node.Node;

public final class NodeUnitTestHelper {
    private NodeUnitTestHelper() {}

    private static List<Node> nodesWithRandomData = new ArrayList<>();

    private static void createNodesWithRandomData(int numOfNodes) {
        for (int i = 0; i <= numOfNodes; i++) {
            nodesWithRandomData.add(new Node());
        }
    }

    public static final List<Node> getNodesWithRandomData(int numOfNodes) {
        if (nodesWithRandomData == null) {
            createNodesWithRandomData(numOfNodes);
        }

        return nodesWithRandomData;
    }

    public static final List<Node> getNodesWithOrderedData() {
        Node thirdNode = new Node(3);
        Node secondNode = new Node(2, thirdNode);
        Node node = new Node(1, secondNode);

        return Arrays.asList(node, secondNode, thirdNode);
    }

}
