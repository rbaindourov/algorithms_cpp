import java.util.Arrays;
import java.util.Comparator;



public class SortArray {

    static class User {
        private String firstName;
        private String lastName;
    
        // Constructor
        public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    
        // Getter for lastName
        public String getLastName() {
            return lastName;
        }
    
        // Override toString for better output readability
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        User[] users = {
            new User("John", "Doe"),
            new User("Jane", "Smith"),
            new User("Alice", "Johnson")
        };


        User[] users2 = {
            new User("Action", "Jackson"),
            new User("Robert", "Bain"),
            new User("Walter", "Penrose"),
            new User("Jane", "Smith"),
            new User("Alice", "Johnson")
        };



        User[] users3 = {
            new User("Action", "Ackson"),
            new User("Robert", "Bain"),
            new User("Walter", "Penrose"),
            new User("Jane", "Doe"),
            new User("Alice", "Johnson")
        };


        User[] sortedUsers = Arrays.stream(users)
                                    .sorted(Comparator.comparing(User::getLastName))
                                    .toArray(User[]::new);


        // Sort users by last name using a lambda expression
        Arrays.sort(users2, (u1, u2) -> u1.getLastName().compareTo(u2.getLastName()));
                            
        // Sort users by last name
        Arrays.sort(users, Comparator.comparing(User::getLastName));

        // Sort the array by last name using a custom Comparator
        Arrays.sort(users3, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareTo(user2.getLastName());
            }
        });

        // Print sorted users
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("++++++++");

        // Print sorted users
        for (User user : sortedUsers) {
            System.out.println(user);
        }

        System.out.println("++++++++");

        // Print sorted users
        for (User user : users2) {
            System.out.println(user);
        }

        System.out.println("++++++++");

        // Print sorted users
        for (User user : users3) {
            System.out.println(user);
        }
    }
}
