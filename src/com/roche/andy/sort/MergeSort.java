package com.roche.andy.sort;

/*
Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for
the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge
(array, left, middle, right) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two
sorted sub-arrays into one.

MergeSort(array[], left,  right)
If right > left
   1. Find the middle point to divide the array into two halves
   2. Call mergeSort for first half
   3. Call mergeSort for second half
   4. Merge the two halves sorted in step 2 and 3:

Time complexity: O(n log(n)) (divides the array in two halves and takes linear time to merge them)
Space complexity: Depends
*/

import static com.roche.andy.sort.BubbleSort.printArray;

public class MergeSort {
    // Merges two subarrays of array[], array[left..middle] and array[middle + 1..right]
    private static void merge(int array[], int left, int middle, int right) {
        // 1. Find sizes of two subarrays to be merged
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        // 2. Create temp arrays
        int leftArray[] = new int[sizeLeft];
        int rightArray[] = new int[sizeRight];

        // 3. Copy data to temp arrays
        System.arraycopy(array, left, leftArray, 0, sizeLeft);
        System.arraycopy(array, middle + 1, rightArray, 0, sizeRight);

        // 4. Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;

            } else {
                array[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < sizeLeft) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < sizeRight) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts array[left..right] using merge()
    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Driver method
    public static void main(String args[]) {
        int array[] = {12, 11, 13, 5, 6, 7};

        System.out.print("Original array: ");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.print("Sorted array: ");
        printArray(array);
    }
}