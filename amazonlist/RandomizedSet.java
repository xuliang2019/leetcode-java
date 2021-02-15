import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    // the idea is to use a hashmap and an arraylist
    // hashmap<value, index> is used to check whether contains or not contain current value
    // arraylist is used to store values

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // use list.remove(lastVal) to implement O(1)
        if (!map.containsKey(val)) {
            return false;
        }


        int index = map.get(val);
        if (index < list.size() - 1) {
            // overwrite the last element in the list to current index
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */