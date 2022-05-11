package org.example.leetcode.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IntersectionOfTwoArraysTwo {
    //1,2,2,1 : 2,2
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            count.put(nums1[i], count.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (Objects.nonNull(count.get(nums2[i])) && count.get(nums2[i]) != 0) {
                count.put(nums2[i], count.get(nums2[i]) - 1);
                res.add(nums2[i]);
            }
        }

        var arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static int[] intersectSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;

        List<Integer> res = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                res.add(nums1[i]);
                i++; j++;
            }
        }

        var arr = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            arr[k] = res.get(k);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectSort(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 2, 2, 3, 4, 5})));
    }
}
