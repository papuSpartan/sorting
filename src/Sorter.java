import java.util.Stack;

public class Sorter {
    private Integer[] nums;

    Sorter(Integer[] nums) {
        this.nums = nums;
    }

    private boolean sorted() {
        for(int i = 0; i < (nums.length-2); i++) {
            if(nums[i] > nums[i+1]) return false;
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
                if (nums[i] > nums[i+1]) {
                    swap(i);
                    swapped = true;
                }

            }

            if(swapped) bubble();

        return nums;
    }

    public Integer[] quick() {
        return quick_r(0);
    }


    //pivot param is an index not value
    public Integer[] quick_r(int pivot) {
        Integer greater = null;
        Integer less = null;
        boolean swapped = false;

        System.out.println("using '"+nums[pivot]+"' as pivot");

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

    public Integer[] mergeSort(Integer[] arr) {
        mergeSort_r(arr, 0, (arr.length - 1));

        return arr;
    }

    public void merge(Integer[] arr, int beg, int midpoint, int end) {
        //for every integer in arr, if arr <= midpoint: add to first temp array
        //if greater then add to second temporary array
        Integer[] tempa = new Integer[(midpoint - beg) + 1];
        Integer[] tempb = new Integer[end - midpoint];
        int ainc = 0;
        int binc = 0;

        int len = ((end - beg) + 1);
        for(int i = beg; i < len; i++) {
           if(i <= midpoint) {
                   tempa[ainc] = arr[i];
                   ainc++;
            } else {
               tempb[binc] = arr[i];
               binc++;
            }
        }

        System.out.println("tempa: ");
        for(Integer i : tempa) {
            System.out.println(i+" ");
        }

    }

    public void mergeSort_r(Integer[] arr, int beg, int end) {
        //split given array until smallest array(s) is of size 1

        //if length of array is 1 then it must already be split
        int len = ((end - beg) + 1);
        int midpoint = ((end + beg) / 2);

        if(len == 1) return;
        else {
            mergeSort_r(arr, beg, midpoint);
            mergeSort_r(arr, (midpoint + 1), end);
            merge(arr, beg, midpoint, end);
            }


        }


}
