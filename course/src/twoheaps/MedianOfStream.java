package twoheaps;


import java.util.PriorityQueue;

public class MedianOfStream {

    private PriorityQueue<Integer> smallestMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> largestMinHeap = new PriorityQueue<>();
    private int size = 0;



    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.insertNum(1);
        medianOfStream.insertNum(2);
        medianOfStream.insertNum(3);

        System.out.println(medianOfStream.findMedian());
    }

    public MedianOfStream() {

    }

    public void insertNum(int num) {
        size++;

        if (largestMinHeap.isEmpty() && smallestMaxHeap.isEmpty()) {
            largestMinHeap.add(num);
            return;
        }

        int middle = largestMinHeap.peek();

        if (num < middle) {
            smallestMaxHeap.add(num);
        } else {
            largestMinHeap.add(num);
        }

        // re-balance
        if (largestMinHeap.size() > smallestMaxHeap.size() + 1) {
            int top = largestMinHeap.poll();
            smallestMaxHeap.add(top);
        } else if (smallestMaxHeap.size() > largestMinHeap.size()) {
            int top = smallestMaxHeap.poll();
            largestMinHeap.add(top);
        }

    }

    public double findMedian() {

        if (size == 0) return 0;
        if (size == 1) return largestMinHeap.peek();

        int maxFromSmallHeap = smallestMaxHeap.peek();
        int minFromLargeHeap = largestMinHeap.peek();

        if (size % 2 == 0) {
            return (double) (maxFromSmallHeap + minFromLargeHeap) / 2;
        } else {
            return minFromLargeHeap;
        }
    }
}
