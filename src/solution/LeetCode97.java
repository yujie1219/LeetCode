package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode97 {
    public static void main(String[] args) {
        new LeetCode97().isInterleave("aabcc", "dbbca", "aadbcbbcac");
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        Map<Element, Boolean> cache = new HashMap<>();
        return isInterLeave(s1, s2, s3, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0, cache);
    }

    private boolean isInterLeave(String s1, String s2, String s3, List<String> fromS1, List<String> fromS2, int froms1, int s1Index, int s2Index, int s3Index, Map<Element, Boolean> cache) {
        if (s1.length() == s1Index && s2.length() == s2Index && s3.length() == s3Index) {
            return Math.abs(fromS1.size() - fromS2.size()) <= 1;
        }

        Element key = new Element(s1Index, s2Index, s3Index);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (s1.length() == s1Index) {
            if (s2.length() - s2Index != s3.length() - s3Index) {
                cache.put(key, false);
                return false;
            } else {
                if (s2.substring(s2Index).equals(s3.substring(s3Index))) {
                    boolean result = Math.abs(fromS1.size() - fromS2.size() - 1) <= 1;
                    cache.put(key, result);
                    return result;
                } else {
                    cache.put(key, false);
                    return false;
                }
            }
        }

        if (s2.length() == s2Index) {
            if (s1.length() - s1Index != s3.length() - s3Index) {
                cache.put(key, false);
                return false;
            } else {
                if (s1.substring(s1Index).equals(s3.substring(s3Index))) {
                    boolean result = Math.abs(fromS1.size() - fromS2.size() - 1) <= 1;
                    cache.put(key, result);
                    return result;
                } else {
                    cache.put(key, false);
                    return false;
                }
            }
        }

        int tempS1Index = s1Index;
        int tempS2Index = s2Index;
        int tempS3Index = s3Index;
        boolean result = false;

        if (froms1 != 1) {
            while (tempS1Index < s1.length() && tempS3Index < s3.length() && s1.charAt(tempS1Index) == s3.charAt(tempS3Index)) {
                tempS1Index++;
                tempS3Index++;
            }

            while (!result && tempS1Index != s1Index) {
                fromS1.add(s1.substring(s1Index, tempS1Index));
                result = isInterLeave(s1, s2, s3, fromS1, fromS2, 1, tempS1Index, s2Index, tempS3Index, cache);
                fromS1.remove(fromS1.size() - 1);
                tempS3Index--;
                tempS1Index--;
            }
        }

        if (froms1 != 2) {
            tempS3Index = s3Index;
            while (tempS2Index < s2.length() && tempS3Index < s3.length() && s2.charAt(tempS2Index) == s3.charAt(tempS3Index)) {
                tempS2Index++;
                tempS3Index++;
            }

            while (!result && tempS2Index != s2Index) {
                fromS2.add(s2.substring(s2Index, tempS2Index));
                result = isInterLeave(s1, s2, s3, fromS1, fromS2, 2, s1Index, tempS2Index, tempS3Index, cache);
                fromS2.remove(fromS2.size() - 1);
                tempS3Index--;
                tempS2Index--;
            }
        }

        cache.put(key, result);
        return result;
    }

    private class Element {
        private int s1;
        private int s2;
        private int s3;

        public Element(int s1, int s2, int s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public boolean equals(Object o) {
            Element element = (Element) o;

            if (element != null) {
                return this.s1 == element.s1 && this.s2 == element.s2 && this.s3 == element.s3;
            }

            return false;
        }
    }
}
