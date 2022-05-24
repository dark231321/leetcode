package leetcode.patterns;

import java.util.Arrays;

public class SortColors {

    /**
     * 1 4 0 2 5 2
     *
     * */
    public static void mergeSort(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;


        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = nums[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            System.out.println();
            for (int i = l; i <= r; i++) {
                System.out.print(nums[i] + " ");
            }
            var m = l + (r - l) / 2;

            sort(nums, l, m);
            sort(nums, m + 1, r);

            mergeSort(nums, l, m, r);
        }
    }

    public static void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sortColorsInPlace(int[] nums) {
        int k = 0, j = 0, m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            } else if (nums[i] == 1) {
                j++;
            } else {
                m++;
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < j; i++) {
            nums[i + k] = 1;
        }
        for (int i = 0; i < m; i++) {
            nums[i + k + j] = 2;
        }
    }

    public static void main(String[] args) {
        var res = new int[]{0, 2, 1, 0, 2, 1};
        sortColorsInPlace(res);
        System.out.println(Arrays.toString(res));
    }
}
