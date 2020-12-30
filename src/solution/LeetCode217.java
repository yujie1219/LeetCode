package solution;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
       return  nums.length !=  Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();
    }
}
