import java.util.*;

class RandomizedSet<T> extends HashSet<T> {
    private final Random random;

    public RandomizedSet() {
        super();
        random = new Random();
    }

    // Method to get a random element from the set
    public T getRandom() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }

        // Convert set to an array for random access
        int index = random.nextInt(this.size());
        Iterator<T> iterator = this.iterator();
        int currentIndex = 0;

        while (iterator.hasNext()) {
            T element = iterator.next();
            if (currentIndex == index) {
                return element;
            }
            currentIndex++;
        }

        // This point should not be reached
        return null;
    }

    public static void main(String[] args) {
        RandomizedSet<Integer> set = new RandomizedSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        System.out.println("Random element: " + set.getRandom());
        System.out.println("Random element: " + set.getRandom());
        System.out.println("Random element: " + set.getRandom());
    }
}
