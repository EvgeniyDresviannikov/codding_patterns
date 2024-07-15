package trie;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("cap"));
        System.out.println(trie.searchPrefix("ca"));
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // inserting string in trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                node.children.put(c, newNode);
                node = newNode;
            } else {
                node = node.children.get(c);
            }
        }
        node.isWord = true;
    }

    // searching for a string
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            } else {
                node = node.children.get(c);
            }
        }
        return node.isWord;
    }

    // searching for a prefix
    public boolean searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            } else {
                node = node.children.get(c);
            }
        }
        return true;
    }
}
