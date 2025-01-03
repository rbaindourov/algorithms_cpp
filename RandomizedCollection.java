import java.util.*;

class RandomizedCollection<T> {
    private final List<T> list;              // To store elements (including duplicates)
    private final Map<T, Set<Integer>> map;  // To map elements to a set of indices
    private final Random random;             // For generating random indices

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    // Add an element to the collection. O(1) time complexity.
    public boolean add(T element) {
        boolean isNewElement = !map.containsKey(element);
        
        map.computeIfAbsent(element, k -> new HashSet<>()).add(list.size());
        list.add(element);

        return isNewElement; // Return true if it was a new element
    }

    // Remove one occurrence of the element from the collection. O(1) time complexity.
    public boolean remove(T element) {
        if (!map.containsKey(element) || map.get(element).isEmpty()) {
            return false; // Element not found
        }

        // Get an index of one occurrence of the element
        int indexToRemove = map.get(element).iterator().next();

        // Move the last element to the place of the element to be removed
        T lastElement = list.get(list.size() - 1);
        list.set(indexToRemove, lastElement);

        // Update the map
        map.get(lastElement).add(indexToRemove); // Update index of the last element
        map.get(lastElement).remove(list.size() - 1); // Remove old index of the last element

        // Remove the last element from the list
        list.remove(list.size() - 1);
        map.get(element).remove(indexToRemove);

        // Clean up the map if there are no more occurrences of the element
        if (map.get(element).isEmpty()) {
            map.remove(element);
        }

        return true;
    }

    // Get a random element from the collection. O(1) time complexity.
    public T getRandom() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Collection is empty");
        }
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedCollection<Integer> collection = new RandomizedCollection<>();
        collection.add(10);
        collection.add(20);
        collection.add(20);
        collection.add(30);

        System.out.println("Random element: " + collection.getRandom());
        System.out.println("Random element: " + collection.getRandom());

        collection.remove(20);
        System.out.println("Random element: " + collection.getRandom());
    }
}
