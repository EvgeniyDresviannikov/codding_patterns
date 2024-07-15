package trie;

import java.util.*;
import java.util.stream.Collectors;

public class WordSearch2 {

    static TrieNode root = new TrieNode();

    public static void main(String[] args) {
        System.out.println(findStrings(
                new char[][]{
                        {'C','S','L','I','M'},
                        {'O','I','L','M','O'},
                        {'O','L','I','E','O'},
                        {'R','T','A','S','N'},
                        {'S','I','T','A','C'}
                },
                new String[]{"SLIME","SAILOR","MATCH","COCOON"}
        ));
    }

    public static List<String> findStrings(char[][] board, String[] words){

        for (String w : words) {
            insert(w);
        }

        Set<String> res = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, new HashSet<>(), res, "");
            }
        }
        
        return new ArrayList<>(res);
    }

    private static void dfs(int row, int col, char[][] grid, TrieNode node, Set<Map.Entry> visited, Set<String> res, String sb) {
        int rLen = grid.length;
        int cLen = grid[0].length;

        if (row < 0 || col < 0 || row == rLen || col == cLen ||
                visited.contains(Map.entry(row, col)) ||
            !node.children.containsKey(grid[row][col]
        )) return ;


        visited.add(Map.entry(row, col));
        node = node.children.get(grid[row][col]);
        sb = sb + grid[row][col];
        if (node.isWord) {
            res.add(sb.toString());
        }


        dfs(row+1, col, grid, node, visited, res, sb);
        dfs(row-1, col, grid, node, visited, res, sb);
        dfs(row, col+1, grid, node, visited, res, sb);
        dfs(row, col-1, grid, node, visited, res, sb);

        visited.remove(Map.entry(row, col));

    }

    private static void insert(String word) {
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
}
