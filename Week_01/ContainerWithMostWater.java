/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName ContainerWithMostWater.java
 * @Description https://leetcode-cn.com/problems/container-with-most-water/
 * @createTime 2020年08月14日 14:35:00
 */
public class ContainerWithMostWater {

//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[i], height[j]);
//                max = Math.max(area, max);
//            }
//        }
//        return max;
//    }


    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i != j; ) {
            // 每次都移动高度较小的一端
            int h = height[i] > height[j] ? height[j--] : height[i++];
            max = Math.max(max, (j - i + 1) * h);
        }
        return max;
    }

//    public int maxArea(int[] height) {
//
//    }
}
