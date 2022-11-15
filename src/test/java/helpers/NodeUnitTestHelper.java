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

    private static List<Node> nodesWithRandomData = new ArrayList<>();
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
        nodesWithRandomData = new ArrayList<>();

        for (int i = 0; i <= numOfNodes; i++) {

            Integer randomSeed = (Integer) RANDOM_DATA_GENERATOR.generateRandomData();
            Integer secondRandomSeed = (Integer) RANDOM_DATA_GENERATOR.generateRandomData();

            decideDataTypeToGenerate(withArrays, randomSeed, secondRandomSeed);
        }
    }

    private static void decideDataTypeToGenerate(boolean withArrays, Integer randomSeed, Integer secondRandomSeed) throws ParseIntException {
        if (randomSeed % 2 == 0) {
            if (withArrays && secondRandomSeed % 2 == 0) {
                nodesWithRandomData.add(new Node(RANDOM_DATA_GENERATOR.generateArrayOf(secondRandomSeed, 3)));
            } else {
                nodesWithRandomData.add(new Node(RANDOM_DATA_GENERATOR.generateRandomData(randomSeed)));
            }
        } else {
            if (withArrays && secondRandomSeed % 2 == 0) {
                nodesWithRandomData.add(new Node(RANDOM_DATA_GENERATOR.generateArrayOf(secondRandomSeed.toString(), 3)));
            } else {
                nodesWithRandomData.add(new Node(RANDOM_DATA_GENERATOR.generateRandomData(randomSeed.toString())));
            }
        }
    }

    // **************
    // PUBLIC METHODS
    // **************

    public static List<Node> getNodesWithRandomData(int numOfNodes, boolean withArrays) throws ParseIntException {
        createNodesWithRandomData(numOfNodes, withArrays);

        return nodesWithRandomData;
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
