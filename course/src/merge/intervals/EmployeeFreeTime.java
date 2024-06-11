package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

    public static void main(String[] args) {
        List<Interval> res = employeeFreeTime(List.of(
                List.of(new Interval(1,3), new Interval(5,6), new Interval(9,10)),
                List.of(new Interval(2,4), new Interval(7,8)),
                List.of(new Interval(8,11), new Interval(12,14))
                )
        );

        res.forEach(System.out::println);
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> ans = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < schedule.size(); i++) {
            size += schedule.get(i).size();
        }

        Interval[] sorted = new Interval[size];
        int cnt = 0;

        for (int i = 0; i < schedule.size(); i++) {
            for (int j = 0; j < schedule.get(i).size(); j++) {
                int start = schedule.get(i).get(j).start;
                int end = schedule.get(i).get(j).end;
                sorted[cnt] = new Interval(start, end);
                cnt++;
            }
        }

        Arrays.sort(sorted, Comparator.comparingInt(o -> o.start));

        int previousEnd = sorted[0].end;

        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i].start > previousEnd) {
                ans.add(new Interval(previousEnd, sorted[i].start));
            }

            previousEnd = Math.max(previousEnd, sorted[i].end);
        }


        return ans;
    }
}

class Interval{
    int start;
    int end;
    boolean closed;
    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    // set the flag for closed/open
    public void setClosed(boolean closed)
    {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}