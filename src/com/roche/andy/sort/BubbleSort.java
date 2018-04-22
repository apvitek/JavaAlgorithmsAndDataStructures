package com.roche.andy.sort;

// Runtime: O(n^2), even if the array is sorted

// Java program for implementation of Bubble Sort
class BubbleSort {
    private void bubbleSort(int array[]) {
        int arrayLength = array.length;

        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap temp and array[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /* Prints the array */
    private void printArray(int array[]) {
        for (int element : array) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[]) {
        BubbleSort bubbleSort = new BubbleSort();
        int array[] = {64, 34, 25, 12, 22, 11, 90};

        bubbleSort.bubbleSort(array);
        System.out.println("Sorted array");
        bubbleSort.printArray(array);
    }
}