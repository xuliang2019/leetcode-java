import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        // prefill candies array, scan from left to right to check right neighbor
        // scan from right to left to check left neighbor
        int size = ratings.length;
        int[] candies = new int[size];
        // prefill candies with 1
        Arrays.fill(candies, 1);

        // scan from left to right, make sure right higher rated child has 1 more candy
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        // scan from right to left, make sure left higher rated child has 1 more candy
        for (int i = size - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int sum = 0;
        for (int n: candies) {
            sum += n;
        }
        return sum;
    }
}
