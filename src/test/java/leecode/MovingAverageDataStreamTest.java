package leecode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingAverageDataStreamTest {
    class MovingAverage {

        private final Queue<Integer> queue = new LinkedList<>();
        private final int size;
        private double sum;

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            queue.offer(val);
            if(queue.size() > size){
                sum -= queue.poll();
            }
            return sum/queue.size();
        }
    }

    @Test
    void testMovingAverage(){
        MovingAverage movingAverage = new MovingAverage(3);
        assertEquals(1, movingAverage.next(1));
        assertEquals((double)(1 + 10) / 2, movingAverage.next(10));
        assertEquals((double)(1 + 10 + 3) / 3, movingAverage.next(3));
        assertEquals((double)(10 + 3 + 5) / 3, movingAverage.next(5));
    }
}
