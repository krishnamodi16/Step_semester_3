package week4.assigment_problems;
import java.util.HashMap;
import java.util.Map;
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> counts = new HashMap<>();
        counts.put(0,1);
        int sum=0, total=0;
        for (int n : nums) {
            sum += n;
            total += counts.getOrDefault(sum-k,0);
            counts.put(sum, counts.getOrDefault(sum,0)+1);
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2)); // 2
        System.out.println(subarraySum(new int[]{1,-1,0},0)); // 3
    }
}
