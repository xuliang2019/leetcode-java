import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // sort intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        //extrac the first element and add it to res
        // if can merge, change the prev[1]
        // otherwise, assign curr to prev and add prev to res
        int[] prev = intervals[0];
        res.add(prev);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // overlaps
            if (prev[1] >= curr[0]) {
                // get the right bound
                prev[1] = Math.max(prev[1], curr[1]); // notice here, prev[1] value also changes at res list
            }
            // no overlaps, add prev
            else {
                prev = curr;
                res.add(prev);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}