package helpers;

import com.project.node.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NodeUnitTestHelper {
    private static final List<Node> nodesWithRandomData = new ArrayList<>();

    private NodeUnitTestHelper() {
    }

    private static void createNodesWithRandomData(int numOfNodes) {
        for (int i = 0; i <= numOfNodes; i++) {
            nodesWithRandomData.add(new Node());
        }
    }

    public static List<Node> getNodesWithRandomData(int numOfNodes) {
        if (nodesWithRandomData.isEmpty()) {
            createNodesWithRandomData(numOfNodes);
        }

        return nodesWithRandomData;
    }

    public static List<Node> getNodesWithOrderedData() {
        Node thirdNode = new Node(3);
        Node secondNode = new Node(2, thirdNode);
        Node node = new Node(1, secondNode);

        return Arrays.asList(node, secondNode, thirdNode);
    }

}
