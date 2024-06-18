package twoheaps;

import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{3,4,5,1,8,-3,5,-4}, 4)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {

        if (k == 1) return Arrays.stream(nums).asDoubleStream().toArray();

        double[] result = new double[nums.length-k+1];

        PriorityQueue<Integer> smallestHalfMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largestHalfMinHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            smallestHalfMaxHeap.add(nums[i]);
        }

        for (int i = 0; i < k/2; i++) {
            largestHalfMinHeap.add(smallestHalfMaxHeap.poll());
        }


        for (int i = k; i < nums.length; i++) {

            double currentMiddle = findMedian(k ,smallestHalfMaxHeap, largestHalfMinHeap);
            result[i-k] = currentMiddle;

            if (currentMiddle > nums[i]) {
                smallestHalfMaxHeap.add(nums[i]);
            } else {
                largestHalfMinHeap.add(nums[i]);
            }

            int removed = nums[i-k];

            if (smallestHalfMaxHeap.contains(removed)) {
                smallestHalfMaxHeap.remove(removed);
            } else {
                largestHalfMinHeap.remove(removed);
            }


            rebalanceHeaps(smallestHalfMaxHeap, largestHalfMinHeap);

        }

        double currentMiddle = findMedian(k ,smallestHalfMaxHeap, largestHalfMinHeap);
        result[result.length-1] = currentMiddle;


        return result;
    }

    private static double findMedian(int k, PriorityQueue<Integer> smallestHalfMaxHeap, PriorityQueue<Integer> largestHalfMinHeap) {

        int maxFromSmallHeap = smallestHalfMaxHeap.peek();
        int minFromLargeHeap = largestHalfMinHeap.peek();

        if (k % 2 == 0) {
            return (double) ((long)maxFromSmallHeap + minFromLargeHeap) / 2;
        } else {
            return maxFromSmallHeap;
        }
    }

    private static void rebalanceHeaps(PriorityQueue<Integer> smallestHalfMaxHeap, PriorityQueue<Integer> largestHalfMinHeap) {
        // re-balance
        if (largestHalfMinHeap.size() > smallestHalfMaxHeap.size()) {
            int top = largestHalfMinHeap.poll();
            smallestHalfMaxHeap.add(top);
        } else if (smallestHalfMaxHeap.size() > largestHalfMinHeap.size() + 1) {
            int top = smallestHalfMaxHeap.poll();
            largestHalfMinHeap.add(top);
        }
    }
}
