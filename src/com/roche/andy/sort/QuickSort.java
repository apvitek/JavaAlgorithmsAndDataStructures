package com.roche.andy.sort;

/*
QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the
picked pivot. There are many different versions of quickSort that pick pivot in different ways.
    - Always pick first element as pivot.
    - Always pick last element as pivot (implemented below)
    - Pick a random element as pivot.
    - Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as
pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put
all greater elements (greater than x) after x. All this should be done in linear time.

Time complexity: O(n log(n)) average, O(n^2) worst case
Space complexity: O(n log(n))
*/

import static com.roche.andy.sort.BubbleSort.printArray;

public class QuickSort {
    /*
    This function takes last element as pivot, places the pivot element at its correct position in sorted array,
    and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    */
    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = (left - 1); // index of smallest element

        for (int j = left; j < right; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[right] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }

    /*
    The main function that implements QuickSort()
    array[] --> Array to be sorted,
    left --> Starting index,
    right --> Ending index
    */
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // partitionIndex is partitioning index, array[partitionIndex] is now at right place
            int partitionIndex = partition(array, left, right);

            // Recursively selectionSort elements before partition and after partition
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] array = { 10, 7, 8, 9, 1, 5 };

        System.out.println("Original array: ");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: ");
        printArray(array);
    }
}

/*
Why Quick Sort is preferred over MergeSort for sorting Arrays
Quick Sort in its general form is an in-place quickSort (i.e. it does not require any extra storage) whereas merge
quickSort requires O(n) extra storage, n denoting the array size which may be quite expensive. Allocating and
de-allocating the extra space used for merge quickSort increases the running time of the algorithm. Comparing average
complexity we find that both type of sorts have O(n log(n)) average complexity but the constants differ. For arrays,
merge quickSort loses due to the use of extra O(n) storage space.

Why MergeSort is preferred over QuickSort for Linked Lists?
In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked
lists. Unlike arrays, linked list nodes may not be adjacent in memory; also, in linked list we can insert
items in the middle in O(1) extra space and O(1) time, therefore merge operation of merge quickSort can be implemented
without extra space for linked lists. Quick Sort relies heavily on random access, therefore the overhead increases for
quick quickSort, while merge quickSort accesses data sequentially and the need of random access is low.
 */