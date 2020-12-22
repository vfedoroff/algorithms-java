package leecode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

// 278. First Bad Version
// Source: https://leetcode.com/problems/first-bad-version/
class FirstBadVersionTest {

    class FirstBadVersion {

        int bad;

        public FirstBadVersion(int bad) {
            this.bad = bad;
        }

        boolean isBadVersion(int version) {
            return this.bad == version;
        }

        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;
            while (high > low) {
                int mid = (high - low) / 2 + low;
                if (isBadVersion(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return isBadVersion(low) ? low : -1;
        }
    }

    @Test
    void testFirstBadVersion() {
        class TestCase {
            public TestCase(int number, int bad, int expected) {
                super();
                this.number = number;
                this.bad = bad;
                this.expected = expected;
            }

            public final int number;
            public final int bad;
            public final int expected;
        }

        List<TestCase> cases = new ArrayList<>();

        cases.add(new TestCase(5, 4, 4));
        cases.add(new TestCase(1, 1, 1));
        for (TestCase tc : cases) {
            FirstBadVersion version = new FirstBadVersion(tc.bad);
            int actual = version.firstBadVersion(tc.number);
            assertEquals(tc.expected, actual);
        }
    }

}

