package week4.assigment_problems;
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int current = nums[0], best = nums[0];
        for (int i=1; i<nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(maxSubArray(new int[]{-3,-1,-2})); // -1
    }
}
