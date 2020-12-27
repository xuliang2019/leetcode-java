// test data
//  int thread = 50;
//  int[] cpu = new int[]{10, 60, 40, 80, 45, 75, 20, 30, 40, 21, 90, 23, 12, 43};
// expect output: 13

public class UtilizationChecks {
    public int numThread(int thread, int[] cpu) {
        int n = cpu.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count > 0) {
                count -= 1;
                continue;
            }

            if (cpu[i] < 25) {
                // round up
                if (thread % 2 != 0) {
                    thread = (++thread) / 2;
                }
                else {
                    thread /= 2;
                }
                count = 10;
            }
            if (cpu[i] > 60) {
                thread *= 2;
                count = 10;
            }
        }
        return thread;
    }
}