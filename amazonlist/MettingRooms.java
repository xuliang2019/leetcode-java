import java.util.Arrays;

public class MettingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // edge case
        if (intervals.length <= 1) { return true; }
        // sort intervals with intervals[0][0] then intervals[0][1]
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));

        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] > intervals[i][0]) {
                return false;
            }
            temp = intervals[i];
        }
        return true;

    }
}