public class Driver {

    public static void main(String[] args) {
        Integer[] nums = {-2, 45, 0, 11, -9};
        Sorter test = new Sorter(nums);

        System.out.print("original:");
        for(Integer i : nums){
            System.out.print(i+" ");
        }
        System.out.println();

        for(Integer i : test.quick()) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
