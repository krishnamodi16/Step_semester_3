package week4.class_problems;
import java.util.Arrays;
public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] out = new int[a.length + b.length];
        int i=0, j=0, k=0;
        while (i<a.length && j<b.length) {
            if (a[i] <= b[j]) out[k++] = a[i++];
            else out[k++] = b[j++];
        }
        while (i<a.length) out[k++] = a[i++];
        while (j<b.length) out[k++] = b[j++];
        return out;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1,3,5}, new int[]{2,4,6})));
    }
}
