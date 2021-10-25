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

}
