/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName SearchMatrix.java
 * @Description TODO
 * @createTime 2020年09月06日 17:58:00
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (midElement == target)
                return true;
            else if (midElement > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{1}, {3}};
        boolean res = searchMatrix(matrix, 2);
        System.out.println(res);
    }
}
