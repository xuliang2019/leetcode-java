import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    private Queue<Long> small;  // store the smaller half numbers, all values are negative
    private Queue<Long> large;  // store the larger half numbers, all values are positive

    public FindMedianFromDataStream() {
        this.small = new PriorityQueue<>();
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());  // add number negatively, so !(small queue) becomes max heap
        // make sure large.size() is larger or equal to small.size()
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        // two cases: large.size() > small.size() or they are equal.
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream median = new FindMedianFromDataStream();
        median.addNum(1);
        median.addNum(5);
        median.addNum(4);
        System.out.println(median.findMedian());
    }
}
