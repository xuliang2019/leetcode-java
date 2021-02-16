public static void main(String[] args) {
        int[] arrival1 = {1,3,3,5,7};
        int[] duration1 = {2,2,1,2,1};
        System.out.println(maxEvents(arrival1, duration1));
        int[] arrival2 = {1,3,3,5,7, 6, 9};
        int[] duration2 = {2,2,1,2,1, 10, 2};
        System.out.println(maxEvents(arrival2, duration2));
        }

private static int maxEvents(int[] arrival, int[] duration) {
        int[][] events = new int[arrival.length][2];
        for(int i=0;i<arrival.length;i++) {
        events[i] = new int[] {arrival[i], arrival[i] + duration[i]};
        }
        Arrays.sort(events, (a, b)->(a[1] - b[1])); // notice here, sort events with ending time
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
        int[] first = events[0];
        for(int i=1;i<events.length;i++) {
        int[] cur = events[i];
        if(cur[0] < first[1])
        minHeap.offer(cur);
        else {
        first[1] = events[i][1];
        }
        }
        return arrival.length - minHeap.size();
        }