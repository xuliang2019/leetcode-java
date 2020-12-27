import java.util.LinkedList;

public class RoboticChallenge {
    public int calPoints(String[] ops) {
        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (String s: ops) {
            if (s.equals("C")) {
                res -= list.removeLast();
            }
            else if (s.equals("D")) {
                int value = 2 * list.peekLast();
                list.add(value);
                res += list.peekLast();
            }
            else if (s.equals("+")) {
                int value = list.peekLast() + list.get(list.size() - 2);
                list.add(value);
                res += list.peekLast();
            }
            else {
                int value = Integer.parseInt(s);
                list.add(value);
                res += list.peekLast();
            }
        }
        return res;
    }
}