public class TrapRainWater {
    public static int trap(int[] height) {
        // use two pointers to track the leftMax bar and the rightMax bar
        // Key points: and bars between leftMax and rightMax don't inlfuence the result
        // if leftMax is smaller, use the leftMax as the rim
        // otherwise, use rightMax as the rim

        int res = 0;
        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            // update
            if (leftMax < rightMax) {
                res += leftMax - height[l];
                l++;
            }
            else {
                res += rightMax - height[r];
                r--;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] height = new int[]{2, 0, 1, 0, 3, 0, 5};
        System.out.println(trap(height));
    }
}