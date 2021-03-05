package solution;

import java.util.*;

public class LeetCode373 {
    public static void main(String[] args) {
        new LeetCode373().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>();

        if (k == 0 || nums1.length == 0 || nums2.length == 0) {
            return results;
        }

        Queue<Integer[]> queue = new PriorityQueue<>((indexArr1, indexArr2) -> {
            return nums1[indexArr1[0]] + nums2[indexArr1[1]] - nums1[indexArr2[0]] - nums2[indexArr2[1]];
        });

        for (int i = 0; i < nums1.length; i++) {
            Integer[] indexArr = {i, 0};
            queue.offer(indexArr);
        }

        while (results.size() < k && !queue.isEmpty()) {
            Integer[] currentIndex = queue.poll();
            Integer[] current = {nums1[currentIndex[0]], nums2[currentIndex[1]]};
            results.add(Arrays.asList(current));
            if (currentIndex[1] < nums2.length - 1) {
                queue.offer(new Integer[]{currentIndex[0], currentIndex[1] + 1});
            }
        }

        return results;
    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> results = new ArrayList<>();
//
//        if (k != 0) {
//            int[] f2s = new int[2];
//            int[] s2f = new int[2];
//            Map<Integer, List<Integer>> usedPair = new HashMap<>();
//            init(f2s, s2f);
//
//            while (results.size() < k && f2s[0] < nums1.length && f2s[1] < nums2.length && s2f[0] < nums2.length && s2f[1] < nums1.length) {
//                List<Integer> result = new ArrayList<>();
//
//                while (usedPair.get(f2s[0]) != null && usedPair.get(f2s[0]).contains(f2s[1])) {
//                    update(f2s, nums2);
//                }
//
//                while (usedPair.get(s2f[1]) != null && usedPair.get(s2f[1]).contains(s2f[0])) {
//                    update(s2f, nums1);
//                }
//
//                if (f2s[1] == s2f[0] && f2s[0] == s2f[1]) {
//                    result.add(nums1[f2s[0]]);
//                    result.add(nums2[f2s[1]]);
//                    if (!usedPair.containsKey(f2s[0])) {
//                        usedPair.put(f2s[0], new ArrayList<>());
//                    }
//                    usedPair.get(f2s[0]).add(f2s[1]);
//                    update(f2s, nums2);
//                    update(s2f, nums1);
//                } else {
//                    if (nums1[f2s[0]] + nums2[f2s[1]] <= nums2[s2f[0]] + nums1[s2f[1]]) {
//                        result.add(nums1[f2s[0]]);
//                        result.add(nums2[f2s[1]]);
//                        if (!usedPair.containsKey(f2s[0])) {
//                            usedPair.put(f2s[0], new ArrayList<>());
//                        }
//                        usedPair.get(f2s[0]).add(f2s[1]);
//                        update(f2s, nums2);
//                    } else {
//                        result.add(nums1[s2f[1]]);
//                        result.add(nums2[s2f[0]]);
//                        if (!usedPair.containsKey(s2f[1])) {
//                            usedPair.put(s2f[1], new ArrayList<>());
//                        }
//                        usedPair.get(s2f[1]).add(s2f[0]);
//                        update(s2f, nums1);
//                    }
//                }
//
//                results.add(result);
//            }
//
//            while (results.size() < k && f2s[0] < nums1.length && f2s[1] < nums2.length) {
//                List<Integer> result = new ArrayList<>();
//
//                while (usedPair.get(f2s[0]) != null && usedPair.get(f2s[0]).contains(f2s[1])) {
//                    update(f2s, nums2);
//                }
//
//                result.add(nums1[f2s[0]]);
//                result.add(nums2[f2s[1]]);
//                update(f2s, nums2);
//                results.add(result);
//            }
//
//            while (results.size() < k && s2f[0] < nums2.length && s2f[1] < nums1.length) {
//                List<Integer> result = new ArrayList<>();
//
//                while (usedPair.get(s2f[1]) != null && usedPair.get(s2f[1]).contains(s2f[0])) {
//                    update(s2f, nums1);
//                }
//
//                result.add(nums1[s2f[1]]);
//                result.add(nums2[s2f[0]]);
//                update(s2f, nums1);
//                results.add(result);
//            }
//        }
//
//        return results;
//    }
//
//    private void update(int[] pair, int[] nums) {
//        if (pair[1] + 1 == nums.length) {
//            pair[0] += 1;
//            pair[1] = 0;
//        } else {
//            pair[1]++;
//        }
//    }
//
//    private void init(int[] f2s, int[] s2f) {
//        f2s[0] = 0;
//        f2s[1] = 0;
//        s2f[0] = 0;
//        s2f[1] = 0;
//    }
}
