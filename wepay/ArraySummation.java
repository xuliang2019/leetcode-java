// two sum + hashSet

class Solution {
    // my answer
    public boolean arraySummation(List<Integer> inputs, List<Integer> tests) {
        Set<Integer> set = new HashSet<>();
        int num = inputs.size();
        for (int t = 0; t < num; t++) {
            int target = tests.get(t);
            for (int i = 0; i < num; i++) {
                int remain = target - inputs.get(i);
                if (set.contains(remain)) {
                    return true;
                }
                set.add(inputs.get(i));
            }
        }

        return false;
    }
}
// sample answer
class Solution {
    public boolean arraySummation(List<Integer> inputs, List<Integer> tests) {
        Set<Integer> set = new HashSet<>(tests);
        int num = inputs.size();
        for (int i = 0; t < num; i++) {
            for (int j = 0; j < i; j++) {
                int sum = inputs.get(i) + inputs,get(j);
                if (set.contains(sum)) {
                    return true;
                }
            }
        }
        return false;
    }
}