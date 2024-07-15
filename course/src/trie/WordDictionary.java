package trie;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {

    TrieNode2 root = new TrieNode2();

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("daddy");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.getWords());

        System.out.println(wordDictionary.search("mad"));
        System.out.println(wordDictionary.search("..d"));

    }

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode2 node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[(int)c - 97] == null) {
                TrieNode2 newNode = new TrieNode2();
                node.children[(int)c - 97] = newNode;
                node = newNode;
            } else {
                node = node.children[(int)c - 97];
            }
        }
        node.complete = true;
    }

    public boolean search(String word) {
        return dfsSearch(root ,word);
    }



    public List<String> getWords() {
        List<String> result = new ArrayList<>();
        dfsAllWords(root, new StringBuilder(), result);
        return result;
    }

    private void dfsAllWords(TrieNode2 node, StringBuilder currentString, List<String> result) {

        if (node.complete) result.add(currentString.toString());

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                char c = (char) (97 + i);
                dfsAllWords(node.children[i], new StringBuilder(currentString).append(c), result);
            }
        }
    }

    private boolean dfsSearch(TrieNode2 node, String substring) {
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            if (c == '.') {
                for (int j = 0; j < node.children.length; j++) {
                    if (node.children[j] != null) {
                        if (dfsSearch(node.children[j], substring.substring(i+1))) return true;
                    }
                }
                return false;
            } else if (node.children[(int)c - 97] == null) {
                return false;
            } else {
                node = node.children[(int)c - 97];
            }
        }

        return node.complete;
    }
}

 class TrieNode2 {

    public TrieNode2[] children;
    public boolean complete;

    public TrieNode2() {
        // Create 26 child nodes for each letter of alphabet
        children = new TrieNode2[26];
        // False indicates this node is not the end of a word
        complete = false;
    }
}


