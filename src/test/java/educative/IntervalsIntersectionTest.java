package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalsIntersectionTest {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0, j=0;
        while (i < arr1.length && j < arr2.length){
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                    || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                // store the intersection part
                intervalsIntersection.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            // move next from the interval which is finishing first
            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    @Test
    void testMerge(){
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] actual = merge(input1, input2);
        //[2, 3], [5, 6], [7, 7]
        Interval[] expected = new Interval[]{
                new Interval(2,3),
                new Interval(5,6),
                new Interval(7,7)
        };
        Assertions.assertArrayEquals(expected, actual);
    }
}
