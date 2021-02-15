import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
        //     public int compare(int[] a, int[] b) {return a[1] - b[1];}
        // });
        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(intervals[0]);

        for (int i = 1; i < n; i++) {
            // get the meeting room that finishes earliest
            int[] prev = minHeap.poll();
            int[] curr = intervals[i];
            // no time conflict -> share one room
            if (prev[1] <= curr[0]) {
                // merge ending time
                prev[1] = curr[1];
            }
            // time conflict, needs a new room
            else {
                minHeap.offer(curr);
            }
            // don't forget to put the meeting room back
            minHeap.offer(prev);
        }
        return minHeap.size();

    }
}