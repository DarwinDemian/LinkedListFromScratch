package linkedlist;

import com.project.exceptions.ParseIntException;
import org.junit.jupiter.api.Test;

public class LinkedListUnitTest extends LinkedListSteps {

    // ********************
    // STANDARD LINKED LIST
    // ********************

    @Test
    public void test_LinkedListConstructorWithNNodes() {
        given_LinkedListIsConstructedWithNNodes();
        then_NewLinkedListConstructorHasTheCorrectValues();
    }

    @Test
    public void test_LinkedListConstructorWithNValues() {
        given_LinkedListIsConstructedWithNValues();
        then_NewLinkedListConstructorHasTheCorrectValues();
    }

    // ******************
    // REVERT LINKED LIST
    // ******************

    @Test
    public void test_LinkedListConstructorWithNValuesReversed() {
        given_LinkedListIsConstructedWithNValues();
        when_LinkedListIsReversed();
        then_ReversedLinkedListConstructorHasTheCorrectValues();
    }

    // ***************************
    // REVERT LINKED LIST W/ ARRAY
    // ***************************

    @Test
    public void test_LinkedListWithArrayWithNValuesReversed() {
        given_LinkedListIsConstructedWithNValuesWithArray();
        when_LinkedListIsReversed();
        then_ReversedLinkedListWithArrayHasTheCorrectValues();
    }

    // **********************************
    // REVERT NESTED LINKED LIST W/ ARRAY
    // **********************************

    @Test
    public void test_NestedLinkedListWithArrayWithNValuesReversed() {
        given_NestedLinkedListIsConstructedWithNValuesWithArray();
        when_LinkedListIsReversed();
        then_NestedReversedLinkedListWithArrayHasTheCorrectValues();
    }

    // **************************
    // LINKED LIST W/ RANDOM DATA
    // **************************

    @Test
    public void test_LinkedListWithRandomData() throws ParseIntException {
        given_LinkedListIsConstructedWithRandomData();
        then_LinkedListWithRandomDataHasDistinctValues();
    }

    @Test
    public void test_LinkedListWithRandomDataWithArrays() throws ParseIntException {
        given_LinkedListIsConstructedWithRandomDataWithArrays();
        then_LinkedListWithRandomDataHasDistinctValues();
    }

}
