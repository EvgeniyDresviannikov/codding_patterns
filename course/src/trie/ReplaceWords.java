package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceWords {

    public static void main(String[] args) {
        System.out.println(replaceWords("where there is a will there is a way", List.of("wi", "wa", "w")));
    }

    public static String replaceWords(String sentence, List<String> dictionary) {

        TrieNode1 root = buildTrie(dictionary);

        List<String> result = new ArrayList<>();

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            result.add(getPrefixIfExists(root, words[i]));
        }

        return result.stream().collect(Collectors.joining(" "));
    }

    private static String getPrefixIfExists(TrieNode1 root, String word) {
        StringBuilder sb = new StringBuilder();
        TrieNode1 node = root;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (node.children[(int)c - 97] != null) {
                sb.append(c);
            } else {
                return word;
            }
            node = node.children[(int)c - 97];
            if (node.isEOW) return sb.toString();

        }
        return word;
    }

    private static TrieNode1 buildTrie(List<String> dictionary) {
        int shift = 97;

        TrieNode1 root = new TrieNode1();

        for (int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            TrieNode1 currentNode = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (currentNode.children[(int)c - shift] != null) {
                    currentNode = currentNode.children[(int)c - shift];
                } else {
                    TrieNode1 newNode = new TrieNode1();
                    currentNode.children[(int)c - shift] = newNode;
                    currentNode = newNode;
                }
            }
            currentNode.isEOW = true;
        }
        return root;
    }
}


class TrieNode1 {
    public static final int SIZE = 26;
    TrieNode1[] children = new TrieNode1[SIZE];
    boolean isEOW;
}