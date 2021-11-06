public class Driver {

    public static void main(String[] args) {
//        Integer[] nums = {-2, 45, 0, 11, -9};
        Integer[] nums = {67,35,44,30,94,7,25,9,83,82,92,8,2,64,56,46,72,63,98,17,53,80,60,59,65,21,55,66,73,68,93,78,22,96,41,74,31,11,14,16,33,3,12,15,48,95,54,88,51,81,100,70,97,89,79,24,45,86,37,26,47,13,19,36,1,58,71,32,76,61,91,28,90,52,87,5,62,77,27,50,4,43,49,23,85,40,39,42,20,10,69,38,84,18,57,75,34,29,99,6};
        Sorter test = new Sorter(nums);

        System.out.print("original:");
        for(Integer i : nums){
            System.out.print(i+" ");
        }
        System.out.println();

        for(Integer i : test.shell(nums)) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
