package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ConflictingAppointmentsTest {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a.start,b.start));
        for (int i=1; i < intervals.length; ++i){
            if (intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }

    @Test
    void testCanAttendAllAppointments(){
        Assertions.assertFalse(canAttendAllAppointments(new Interval[]{
                new Interval(1,4),
                new Interval(2,5),
                new Interval(7,9)
        }));
    }
}
