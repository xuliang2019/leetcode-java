public class MusicPairs {
    public int numPairsDivisibleBy60(int[] time) {
        // (t + x) % 60 == 0, reduced to two sum question
        // convert to : x % 60 = (60 - t % 60)
        // above formula not applied to edge case when both x % 60 and t % 60 = 0
        // x % 60 = (3600 - t) % 60
        // t % 60 can have reminders from 0 to 59
        int[] reminder = new int[60];
        int res = 0;

        for (int t: time) {
            res += reminder[(3600 - t) % 60];
            reminder[t % 60] += 1;
        }
        return res;
    }
}