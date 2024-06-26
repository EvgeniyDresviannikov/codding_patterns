package top.k.elements;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{5, 12, 9, 0, 6, 7, 1, 8, 4, 9}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }


        return minHeap.peek();
    }
}
