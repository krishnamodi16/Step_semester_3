package week4.assigment_problems;
import java.util.Arrays;
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prefix = 1;
        for (int i=0; i<nums.length; i++) { ans[i] = prefix; prefix *= nums[i]; }
        int suffix = 1;
        for (int i=nums.length-1; i>=0; i--) { ans[i] *= suffix; suffix *= nums[i]; }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
