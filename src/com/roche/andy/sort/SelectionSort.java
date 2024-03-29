package com.roche.andy.sort;

/*
The selection quickSort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array:
    1) The subarray which is already sorted.
    2) Remaining subarray which is unsorted.

In every iteration of selection quickSort, the minimum element (considering ascending order) from the unsorted subarray is
picked and moved to the sorted subarray.

Following example explains the above steps:

arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64

Time complexity: O(n^2) (two nested loops)
Space complexity: O(1)
*/

import static com.roche.andy.sort.BubbleSort.printArray;

class SelectionSort {
    public static void selectionSort(int[] array, int arrayLength) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arrayLength - 1; i++) {
            // Find the minimum element in unsorted array
            int indexOfMinElement = i;

            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < array[indexOfMinElement]) {
                    indexOfMinElement = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = array[indexOfMinElement];
            array[indexOfMinElement] = array[i];
            array[i] = temp;
        }
    }

    // Driver code to test above
    public static void main(String[] args) {
        int[] array = { 64, 25, 12, 22, 11 };

        System.out.print("Original array: ");
        printArray(array);

        selectionSort(array, array.length);

        System.out.print("Sorted array: ");
        printArray(array);
    }
}
