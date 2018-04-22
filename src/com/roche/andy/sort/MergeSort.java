package com.roche.andy.sort;

/*
Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for
the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge
(array, left, middle, right) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two
sorted sub-arrays into one.

MergeSort(arr[], l,  r)
If r > l
   1. Find the middle point to divide the array into two halves
   2. Call mergeSort for first half
   3. Call mergeSort for second half
   4. Merge the two halves sorted in step 2 and 3:

Time complexity: O(n Log(n)) (divides the array in two halves and takes linear time to merge them)
Space complexity: O(n)
*/

class MergeSort {
    // Merges two subarrays of array[], array[left..middle] and array[middle + 1..right]
    private void merge(int array[], int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        // Create temp arrays
        int leftArray[] = new int[sizeLeft];
        int rightArray[] = new int[sizeRight];

        // Copy data to temp arrays
        System.arraycopy(array, left, leftArray, 0, sizeLeft);
        System.arraycopy(array, middle + 1, rightArray, 0, sizeRight);

        /* Merge the temp arrays */

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

    // Main function that sorts arr[left..right] using merge()
    private void sort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    // A utility function to print array of size n
    private static void printArray(int arr[]) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }

        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int array[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(array);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, array.length - 1);

        System.out.println("\nSorted array");
        printArray(array);
    }
}