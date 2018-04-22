package com.roche.andy.sort;

/*
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is
picked and moved to the sorted subarray.

Runtime: O(n^2) (two nested loops)
Space complexity: O(1)
*/

class SelectionSort {
    private void selectionSort(int array[], int arrayLength) {
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

    // Prints the array
    private void printArray(int arr[]) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }

        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[]) {
        SelectionSort selectionSort = new SelectionSort();
        int arr[] = {64, 25, 12, 22, 11};

        selectionSort.selectionSort(arr, arr.length);
        System.out.println("Sorted array");
        selectionSort.printArray(arr);
    }
}
