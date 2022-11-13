package helpers;

import com.project.exceptions.ParseIntException;
import com.project.node.Node;
import com.project.randomdatagenerator.RandomDataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NodeUnitTestHelper {

    // **************
    // PRIVATE FIELDS
    // **************

    private static final List<Node> NODES_WITH_RANDOM_DATA = new ArrayList<>();
    private static final RandomDataGenerator RANDOM_DATA_GENERATOR = new RandomDataGenerator();

    // ***********
    // CONSTRUCTOR
    // ***********

    private NodeUnitTestHelper() {
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private static void createNodesWithRandomData(int numOfNodes, boolean withArrays) throws ParseIntException {
        for (int i = 0; i <= numOfNodes; i++) {

            Integer randomSeed = (Integer) new RandomDataGenerator().generateRandomData();
            Integer secondRandomSeed = (Integer) new RandomDataGenerator().generateRandomData();

            if (randomSeed > secondRandomSeed) {
                NODES_WITH_RANDOM_DATA.add(new Node(RANDOM_DATA_GENERATOR.generateRandomData(1)));
            } else if (withArrays) {
                NODES_WITH_RANDOM_DATA.add(new Node(RANDOM_DATA_GENERATOR.generateArrayOf(1, 5)));
            } else {
                NODES_WITH_RANDOM_DATA.add(new Node(RANDOM_DATA_GENERATOR.generateRandomData("1")));
            }

        }
    }

    // **************
    // PUBLIC METHODS
    // **************

    public static List<Node> getNodesWithRandomData(int numOfNodes, boolean withArrays) throws ParseIntException {
        if (NODES_WITH_RANDOM_DATA.isEmpty()) {
            createNodesWithRandomData(numOfNodes, withArrays);
        }

        return NODES_WITH_RANDOM_DATA;
    }

    public static List<Node> getNodesWithOrderedData() {
        Node thirdNode = new Node(3);
        Node secondNode = new Node(2, thirdNode);
        Node node = new Node(1, secondNode);

        return Arrays.asList(node, secondNode, thirdNode);
    }

    public static List<Node> getNodesWithOrderedDataWithoutNext() {
        Node thirdNode = new Node(3);
        Node secondNode = new Node(2);
        Node node = new Node(1);

        return Arrays.asList(node, secondNode, thirdNode);
    }

}
