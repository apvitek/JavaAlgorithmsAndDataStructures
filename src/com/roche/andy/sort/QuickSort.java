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

 Runtime: O(n)
*/

class QuickSort {
    /*
    This function takes last element as pivot, places the pivot element at its correct position in sorted array,
    and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    */
    private int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /*
    The main function that implements QuickSort()
    array[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index
    */
    private void sort(int array[], int low, int high) {
        if (low < high) {
            // partitionIndex is partitioning index, array[partitionIndex] is now at right place
            int partitionIndex = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            sort(array, low, partitionIndex - 1);
            sort(array, partitionIndex + 1, high);
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

    // Driver program
    public static void main(String args[]) {
        int array[] = {10, 7, 8, 9, 1, 5};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);

        System.out.println("sorted array");
        printArray(array);
    }
}