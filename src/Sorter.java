import java.util.Stack;

public class Sorter {
    private Integer[] nums;

    Sorter(Integer[] nums) {
        this.nums = nums;
    }

    private boolean sorted() {
        for (int i = 0; i < (nums.length - 2); i++) {
            if (nums[i] > nums[i + 1]) return false;
        }

        return true;
    }


    //swaps given index with element one index to the right
    private void swap(int index) {
        int temp = nums[index];
        nums[index] = nums[index + 1];
        nums[index + 1] = temp;
    }

    public Integer[] bubble() {
        boolean swapped = false;

        for (int i = 0; i < (nums.length - 1); i++) {
            if (nums[i] > nums[i + 1]) {
                swap(i);
                swapped = true;
            }

        }

        if (swapped) bubble();

        return nums;
    }


    public Integer[] quick() {
        return quick_r(0);
    }

    //pivot param is an index not value
    public Integer[] quick_r(int pivot) {
        Integer less = null;
        boolean swapped = false;

        System.out.println("using '" + nums[pivot] + "' as pivot");

        //upperbound/pointer for reverse accesses
        int upper = nums.length - 1;
        for (int lower = 0; lower < nums.length - 1; lower++) {
            if (greater != null && nums[lower] > nums[pivot]) greater = lower;
            if (nums[upper] < nums[pivot]) {
                int temp = nums[upper];
                nums[upper] = nums[lower];
                nums[lower] = temp;
            }
        }

        quick_r(pivot++);
        return nums;
    }

    public Integer[] selection() {
        //index of minimum element for this iteration
        Integer min = 0;
        Integer nextunsorted = 0;

        for (Integer x : nums) {
            //start 1 ahead of current perceived min and check for smaller element in array
            min = nextunsorted;

            for (int i = nextunsorted + 1; i < nums.length; i++) {
                if (nums[i] < nums[min]) {
                    min = i;
                }
            }
                //swap element at next unsorted position (starting from the beginning) with the element we-
                //-know to belong at that index (the min)
                int temp = nums[nextunsorted];
                nums[nextunsorted] = nums[min];
                nums[min] = temp;
                nextunsorted++;
            }

        return nums;
    }

    public Integer[] insertion() {
        //assume first element to be sorted and start trying to find an element greater than it, starting at element 2

        for(int i = 1; i < nums.length; i++) {

        }

        return nums;
    }

    public Integer[] mergeSort(Integer[] arr) {
        mergeSort_r(arr);
        return arr;
    }

    private void mergeSort_r(Integer[] arr) {
        int midpoint = (arr.length / 2);
        Integer[] left = new Integer[midpoint];
        Integer[] right = new Integer[arr.length - midpoint];

        if (arr.length < 2) {
            return;
        }

        //populate left and right subarrays
        for (int i = 0; i < midpoint; i++) {
            left[i] = arr[i];
        }
        for (int i = midpoint; i < arr.length; i++) {
            right[i - midpoint] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);

    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        //get remaining elements if done with left subarray
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public

}