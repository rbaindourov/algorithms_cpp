import java.util.*;

class RandomizedSet<T> {
    private final List<T> list;          // To store elements
    private final Map<T, Integer> map;   // To store element to index mapping
    private final Random random;         // For generating random indices

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    // Add an element to the set, if not present. O(1) time complexity.
    public boolean add(T element) {
        if (map.containsKey(element)) {
            return false; // Element already present
        }
        map.put(element, list.size());
        list.add(element);
        return true;
    }

    // Remove an element from the set, if present. O(1) time complexity.
    public boolean remove(T element) {
        if (!map.containsKey(element)) {
            return false; // Element not found
        }

        // Get the index of the element to remove
        int index = map.get(element);

        // Move the last element to the place of the element to be removed
        T lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element from the list and map
        list.remove(list.size() - 1);
        map.remove(element);

        return true;
    }

    // Get a random element from the set in O(1) time complexity.
    public T getRandom() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet<Integer> set = new RandomizedSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        System.out.println("Random element: " + set.getRandom());
        System.out.println("Random element: " + set.getRandom());

        set.remove(20);
        System.out.println("Random element: " + set.getRandom());
    }
}
