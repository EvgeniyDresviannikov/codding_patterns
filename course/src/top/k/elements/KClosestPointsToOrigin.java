package top.k.elements;


import java.util.*;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        System.out.println(kClosest(new Point[]{new Point(-1, -3), new Point(-4, -5), new Point(-2, -2), new Point(-2, -3)}, 2));
    }

    public static List<Point> kClosest(Point[] points, int k) {

        int len = points.length;
        if (len == k) return Arrays.asList(points);
        if (len < k) return new ArrayList<>();

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((o1, o2) -> getSquare(o2.x, o2.y) - getSquare(o1.x, o1.y));

        int counter = 0;

        while (counter < k) {
            Point item = points[counter];
            maxHeap.add(item);

            counter++;
        }

        while (counter < points.length) {
            Point currItem = points[counter];
            Point popItem = maxHeap.peek();
            if (getSquare(currItem.x, currItem.y) < getSquare(popItem.x, popItem.y)) {
                maxHeap.poll();
                maxHeap.add(currItem);
            }
            counter++;
        }

        return new ArrayList<>(maxHeap);
    }


    private static int getSquare(int x, int y) {
        return x*x + y*y;
    }
}




class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    // Write your code here
}
