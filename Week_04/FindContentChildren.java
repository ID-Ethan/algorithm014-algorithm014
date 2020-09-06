import java.util.Arrays;

/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName FindContentChildren.java
 * @Description TODO
 * @createTime 2020年09月06日 17:59:00
 */
public class FindContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] s = new int[]{1, 2};
        int[] g = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
}
