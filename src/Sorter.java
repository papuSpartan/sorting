import java.util.Stack;

public class Sorter {
    private Integer[] nums;
    private boolean TESTING = true;

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

    private void swap(Integer[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
        //    if (greater != null && nums[lower] > nums[pivot]) greater = lower;
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

    public Integer[] insertionOnR(Integer[] arr, int startI, int endI) {
        //assume first element to be sorted and start trying to find an element greater than it, starting at element 2

        for(int i = startI + 1; i <= endI; i++) {

//            if(TESTING)System.out.println("is "+arr[i]+" less than "+arr[i - 1]+"?");
            if (arr[i] < arr[i - 1]) {

                int shift = 0;
                //first operand of && ensures we do not cause an indexoutofbounds exception by going negative
                //second operand of && ensures that we are not yet done moving the value to be inserted
                while ((i - 1 - shift) >= 0 && arr[i - shift] < arr[i - 1 - shift]) {
 //                   if(TESTING)System.out.println(arr[i - shift] + " is < " + arr[i - 1 - shift] + ": swapping");

                    swap(arr, (i - shift), (i - 1 - shift));
                    shift++;
                }

            }
        }

        return arr;
    }

    public Integer[] insertion(Integer[] arr) {
        insertionOnR(arr, 0, arr.length - 1);
        return arr;
    }

    public Integer[] shell(Integer[] arr) {

        //once gap reaches 1 we are just doing an insertion sort so just call insertion()
        for(int gap = arr.length/2; gap > 1; gap /= 2) {
            System.out.println("gap: "+gap);
            for (int i = 0; i < arr.length; i++) {
                if((i + gap) < arr.length && arr[i] > arr[i + gap]) {
                    System.out.println("swapping "+arr[i]+" with "+arr[i + gap]);
                    swap(arr, (i), (i + gap));
                }
            }
        }
        //once we are at a gap of 1 do insertion sort (on "gap" of 1)
        insertion(arr);

        return arr;
    }
}