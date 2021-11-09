package leecode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LoggerRateLimiter {
    class Logger {

        class Pair<U, V> {
            public U first;
            public V second;

            public Pair(U first, V second) {
                this.first = first;
                this.second = second;
            }
        }



        private Deque<Pair> queue;
        Set<String> set;


        public Logger() {
            queue = new LinkedList<>();
            set = new HashSet<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            // Clean Up.
            while (!queue.isEmpty()) {
                Pair<Integer, String> pair = queue.getFirst();
                if (timestamp - pair.first >= 10) {
                    queue.remove(pair);
                    set.remove(pair.second);
                } else {
                    break;
                }
            }
            if (!set.contains(message)) {
                Pair<Integer, String> newEntry = new Pair<>(timestamp,message);
                queue.addLast(newEntry);
                set.add(message);
                return true;
            }
            return false;
        }
    }

    @Test
    void testShouldPrintMessage(){
        boolean actual;
        Logger logger = new Logger();
        actual = logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        Assert.assertTrue(actual);
        actual =logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        Assert.assertTrue(actual);
        actual = logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
        Assert.assertFalse(actual);
        actual = logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
        Assert.assertFalse(actual);
        actual = logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
        Assert.assertFalse(actual);
        actual = logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
        Assert.assertTrue(actual);
    }

}
