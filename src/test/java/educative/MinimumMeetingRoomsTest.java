package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRoomsTest {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        int rooms = 0;
        PriorityQueue<Meeting> queue =
                new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        for(Meeting meeting : meetings ){
            while (!queue.isEmpty() && meeting.start >= queue.peek().end)
                queue.poll();
            queue.offer(meeting);
            rooms = Math.max(rooms, queue.size());
        }
        return rooms;
    }


    @Test
    void testFindMinimumMeetingRooms(){
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        Assertions.assertEquals(2, findMinimumMeetingRooms(input));
    }

    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };
}
