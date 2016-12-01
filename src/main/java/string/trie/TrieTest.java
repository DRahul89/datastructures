package main.java.string.trie;

public class TrieTest {

	public static void main(String[] args) {
		String[] inputs = { "the", "a", "there", "answer", "any", "by", "bye",
				"their" };
		Trie trie = new Trie();
		for (int i = 0; i < inputs.length; i++) {
			trie.insertNodeInTrie(inputs[i]);
		}
		printResult(trie);

		System.out.println("search aa in trie "
				+ trie.searchMaxPrefixStringInTrie("by"));
	}

	private static void printResult(Trie trie) {
		System.out.println("search there in trie "
				+ trie.searchNodeInTrie("there"));
		System.out
				.println("search the in trie " + trie.searchNodeInTrie("the"));
		System.out.println("search answer in trie "
				+ trie.searchNodeInTrie("answer"));
		System.out
				.println("search any in trie " + trie.searchNodeInTrie("any"));
		System.out.println("search by in trie " + trie.searchNodeInTrie("by"));
		System.out
				.println("search bye in trie " + trie.searchNodeInTrie("bye"));
		System.out
				.println("search bya in trie " + trie.searchNodeInTrie("bya"));
		System.out.println("search their in trie "
				+ trie.searchNodeInTrie("their"));
		System.out.println("search a in trie " + trie.searchNodeInTrie("a"));
		System.out.println("search aa in trie " + trie.searchNodeInTrie("aa"));
	}
}
