import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName ThreeSum.java
 * @Description 三数之和（15）
 * @createTime 2020年08月26日 20:27:00
 */
public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        // 先排序
//        Arrays.sort(nums);
//        Set<List<Integer>> set = new LinkedHashSet<>();
//        // 暴力破解
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if (sum != 0) continue;
//                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                }
//            }
//        }
//        return new ArrayList<>(set);
//    }

    /**
     * 排序+双指针 O(nLogn)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        // 双指针
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else {
                    resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[k] == nums[--k]) ;
                    while (j < k && nums[j] == nums[++j]) ;
                }
            }
        }
        return resultList;
    }
}
