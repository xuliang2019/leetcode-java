//static int solution(List intList) {
//
//        int sum = 0;
//
//        if(intList == null || intList.size() == 0)return sum;
//
//        while(intList.size() > 1){
//        Collections.sort(intList);
//        sum += add2Smallest(intList);
//        }
//        return sum;
//    }
//
//static int add2Smallest(List<Integer> arrList){
//        int arr_size = arrList.size();
//
//        /* There should be at least two elements */
//        if (arr_size < 2)
//        {
//        return 0;
//        }
//        int first = arrList.get(0);
//        int second = arrList.get(1);
//
//        arrList.add(first+second);
//        // remove  added two smallest elements
//        arrList.remove(0);
//        arrList.remove(0);
//        return first + second;
//    }

import java.util.PriorityQueue;

public class FulfillmentBuilder {
    public static void main(String[] args) {
        int[] parts = new int[]{1, 2, 3, 4};
        System.out.println(fill(parts));
    }

    public static int fill(int[] parts) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(); // default is ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return a - b;});
        int res = 0;
        for (int p : parts) {
            pq.offer(p);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            res += first + second;
            pq.offer(first + second);
        }
        return res;
    }
}
