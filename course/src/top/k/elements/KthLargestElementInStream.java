package top.k.elements;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(5, new int[]{4, 2, 1, 3, 5});
        System.out.println(kthLargest.add(8));
        System.out.println(kthLargest.add(9));

    }
}


class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    // constructor to initialize topKHeap and add values in it
    public KthLargest(int k, int[] nums) {
        this.k = k;

        int i = 0;
        while (i < nums.length) {
           add(nums[i]);
           i++;
        }

    }

    // adds element in the topKHeap
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else {
            int currMin = minHeap.peek();
            if (currMin < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }

        return minHeap.size() == k ? minHeap.peek() : -1;

    }

}