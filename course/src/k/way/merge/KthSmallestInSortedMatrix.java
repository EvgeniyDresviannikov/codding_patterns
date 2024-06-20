package k.way.merge;

import java.util.Comparator;
import java.util.PriorityQueue;

class Item {
    int val;
    int i;
    int j;

    public Item(int val, int i, int j) {
        this.val = val;
        this.i = i;
        this.j = j;
    }
}

public class KthSmallestInSortedMatrix {

    public static void main(String[] args) {
        System.out.println(kthSmallestElement(new int[][]{
                {1, 5, 9},
                {10, 11,13},
                {12, 13, 15}
        }, 8));
    }


    public static int kthSmallestElement(int[][] matrix, int k) {

        PriorityQueue<Item> minHeap = new PriorityQueue<>(Comparator.comparingInt(item -> item.val));

        for (int i = 0; i < matrix.length; i++) {
            Item item = new Item(matrix[i][0], i, 0);
            minHeap.add(item);
        }

        int counter = 0;
        int val = -1;
        while(counter < k) {
            Item item = minHeap.poll();
            int i = item.i;
            int j = item.j;
            val = item.val;

            if (j < matrix.length-1) {
                minHeap.add(new Item(matrix[i][j+1], i, j+1));
            }

            counter++;
        }

        return val;
    }
}
