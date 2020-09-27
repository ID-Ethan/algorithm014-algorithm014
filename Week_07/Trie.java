/**
 * Q208 Trie
 *
 * @author huangtao
 * @date 2020/9/26
 */
public class Trie {
	Trie[] links;
	boolean isEnd;

	/** Initialize your data structure here. */
	public Trie() {
		links = new Trie[26];
		isEnd = false;
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie node = this;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.links[index] == null) {
				node.links[index] = new Trie();
			}
			node = node.links[index];
		}
		node.isEnd = true;
	}

	private Trie searchPrefix(String prefix) {
		Trie node = this;
		for (char ch : prefix.toCharArray()) {
			int index = ch - 'a';
			if (node.links[index] == null) {
				return null;
			}
			node = node.links[index];
		}
		return node;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie node = searchPrefix(word);
		return node != null && node.isEnd ;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		Trie node = searchPrefix(prefix);
		return node != null;
	}
}
