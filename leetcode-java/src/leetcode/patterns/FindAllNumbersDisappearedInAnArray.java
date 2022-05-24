package leetcode.patterns;

import java.util.ArrayList;
import java.util.List;

// [4,3,2,7,8,2,3,1]
// [5,6]
// [1,1]
// [2]
public class FindAllNumbersDisappearedInAnArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int cur = 0;
        while (cur < nums.length) {
            int index = nums[cur] - 1;
            if (index != cur && nums[index] != nums[cur]) {
                int tmp = nums[cur];
                nums[cur] = nums[index];
                nums[index] = tmp;
            } else {
                cur++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
