package com.project.algorithms;

public final class MergeSort {

    private MergeSort() {
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private static void merge(Integer[] reference, Integer[] leftHalf, Integer[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0; // left index
        int j = 0; // right index
        int k = 0; // reference index

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                reference[k] = leftHalf[i];
                i++;
            } else {
                reference[k] = rightHalf[j];
                j++;
            }

            k++;
        }

        cleanUp(reference, leftHalf, leftSize, i, k);
        cleanUp(reference, rightHalf, rightSize, j, k);
    }

    private static void cleanUp(Integer[] reference, Integer[] half, int halfSize, int i, int k) {
        while (i < halfSize) {
            reference[k] = half[i];
            i++;
            k++;
        }
    }

    private static Integer[] getLeftHalf(Integer[] reference, int midIndex) {
        Integer[] leftHalf = new Integer[midIndex];
        System.arraycopy(reference, 0, leftHalf, 0, midIndex);

        return leftHalf;
    }

    private static Integer[] getRightHalf(Integer[] reference, int midIndex) {
        Integer[] rightHalf = new Integer[reference.length - midIndex];

        if (reference.length - midIndex >= 0) {
            System.arraycopy(reference, midIndex, rightHalf, 0, reference.length - midIndex);
        }

        return rightHalf;
    }

    // **************
    // PUBLIC METHODS
    // **************

    public static void mergeSort(Integer[] intArr) {
        int arrLength = intArr.length;

        if (arrLength < 2) return; // base case: there is only one element left

        int midIndex = arrLength / 2;
        Integer[] leftHalf = getLeftHalf(intArr, midIndex);
        Integer[] rightHalf = getRightHalf(intArr, midIndex);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(intArr, leftHalf, rightHalf);
    }
}
