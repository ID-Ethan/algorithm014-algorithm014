/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName MoveZeros.java
 * @Description 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @createTime 2020年08月13日 09:56:00
 */
public class MoveZeros {
    /**
     * 解法一：
     * 定义变量i = 0 ，遍历数组，每当碰到一个值为0，i自增并将nums[i]设置为非零值，当前值设置为0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;
                j++;
            }
        }
    }
}
