import java.util.Arrays;

public class MettingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // edge case
        if (intervals.length <= 1) { return true; }
        // sort intervals with intervals[0][0] then intervals[0][1]
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] > curr[0]) {
                return false;
            }
            prev = curr;
        }
        return true;

    }
}