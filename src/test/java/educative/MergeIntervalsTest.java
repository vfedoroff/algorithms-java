package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MergeIntervalsTest {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;
        Collections.sort(intervals, (a,b)-> Integer.compare(a.start,b.start));
        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;
        while (iterator.hasNext()) {
            interval = iterator.next();
            System.out.println(interval.start + "=>" + interval.end);
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            } else { // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    @Test
    void testMerge(){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        List<Interval> actual = merge(input);
        //[[1,5], [7,9]]
        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,5));
        expected.add(new Interval(7,9));
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
        Assertions.assertTrue(actual.containsAll(expected));
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Interval person = (Interval) o;
        // field comparison
        return Objects.equals(start, person.start)
                && Objects.equals(end, person.end);
    }
};