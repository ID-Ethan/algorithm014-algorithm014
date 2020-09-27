/**
 * @author huangtao
 * @date 2020/9/26
 */
public class Q547Solution {
	int count = 0;
	public int findCircleNum(int[][] M) {
		int len = M.length;
		int[] parent = new int[len];
		count = len;

		for (int i = 0; i < len; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (M[i][j] == 1) {
					union(parent, i, j);
				}
			}
		}

		return count;
	}

	private void union(int[] parent, int x, int y) {
		int rootx = find(parent, x);
		int rooty = find(parent, y);
		if (rootx != rooty) {
			parent[rootx] = rooty;
			count--;
		}
	}

	private int find(int[] parent, int x) {
		int root = x;
		while (parent[root] != root) {
			root = parent[root];
		}

		int p = x;
		while (parent[p] != root) {
			int tmp = parent[p];
			parent[p] = root;
			p = tmp;
		}
		return root;
	}
}
