package org.example.leetcode.patterns;

public class MajorityElement {
    public int majorityElementFi(int[] nums) {
        var res = 0;
        var count = 0;
        for (var tmp: nums) {
            if (count == 0) {
                res = tmp;
            }
            count = (res == tmp) ? count + 1 : count - 1;
        }
        return res;
    }

    public static class Binary {
        public int countOfRange(int[] nums, int lo, int hi, int num) {
            var count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        public int majorityElement(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return nums[lo];
            }
            var mid = lo + (hi - lo) / 2;

            var lf = majorityElement(nums, lo, mid);
            var rt = majorityElement(nums, mid + 1, hi);

            if (lf == rt) {
                return lf;
            }

            var cntLf = countOfRange(nums, lo, hi, lf);
            var cntRt = countOfRange(nums, lo, hi, rt);

            return cntLf > cntRt ? lf : rt;
        }

        public int majorityElement(int[] nums) {
            return majorityElement(nums, 0, nums.length - 1);
        }
    }

}
