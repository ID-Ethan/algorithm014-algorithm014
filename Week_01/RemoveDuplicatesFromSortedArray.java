/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName RemoveDuplicatesFromSortedArray.java
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @createTime 2020年09月06日 14:47:00
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        /**
         * 删除排序数据中的重复元素非常简单，只需遍历一次数组；
         * 定义变量cur记录最终数组的长度（长度即不重复元素的个数）
         * 定义变量ahead递增用于遍历数组
         * 每次比较出现不重复值，cur+1
         * */
        int cur = 0, ahead = 1;
        while (ahead < nums.length) {
            if (nums[cur] != nums[ahead]) {
                nums[++cur] = nums[ahead];
            }
            ahead++;
        }
        return cur + 1;
    }
}
