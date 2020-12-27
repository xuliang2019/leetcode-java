public class RoverControl {
    public static void main(String[] args) {

        String[] str = {"R", "U", "D", "L", "D", "D"};
        System.out.println(roverMove(str, 4));
    }

    public static int roverMove(String[] st, int n) {
        if (st.length == 0) {
            return 0;
        }
        int pos = 0;
        for (String s : st) {
            int currRow = pos / n;
            if (s.equals("R")) {
                // right boundary: (currRow + 1) * n) - 1
                if (pos < ((currRow + 1) * n) - 1) {
                    pos++;
                }
            } else if (s.equals("L")) {
                // left boundary: currRow * n
                if (pos > (currRow * n)) {
                    pos--;
                }
            } else if (s.equals("U")) {
                // top boundary
                if (currRow > 0) {
                    pos = pos - n;
                }
            } else {
                // bottom boundary
                if (currRow < n - 1) {
                    pos = pos + n;
                }
            }
        }

        return pos;
    }
}