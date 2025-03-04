package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class FutureExperiment {

    CompletableFuture<String> fetchUserData(int userId) {
        // Simulate fetching user data asynchronously
        return CompletableFuture.supplyAsync(() -> {
            // Simulate some delay
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (userId % 2 == 0) {
                return "User Data for " + userId;
            } else {
                throw new RuntimeException("User data not found for " + userId);
            }
        });
    }

    CompletableFuture<String> fetchUserPreferences(int userId) {
        // Simulate fetching user preferences asynchronously
        return CompletableFuture.supplyAsync(() -> {
            // Simulate some delay
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (userId % 3 == 0) {
                return "User Preferences for " + userId;
            } else {
                throw new RuntimeException("User preferences not found for " + userId);
            }
        });
    }

    CompletableFuture<CombinedUserResult> fetchCombinedUserData(int userId) {
        CompletableFuture<String> userDataFuture = fetchUserData(userId);
        CompletableFuture<String> userPreferencesFuture = fetchUserPreferences(userId);

        return userDataFuture.thenCombine(userPreferencesFuture, CombinedUserResult::new)
                .exceptionally(ex -> {
                    System.err.println("Error fetching user data for user: " + userId + " - " + ex.getMessage());
                    return new CombinedUserResult(null, null); // Or handle the error as needed.
                });
    }

    static class CombinedUserResult {
        String userData;
        String userPreferences;

        public CombinedUserResult(String userData, String userPreferences) {
            this.userData = userData;
            this.userPreferences = userPreferences;
        }

        @Override
        public String toString() {
            return "CombinedUserResult{" +
                    "userData='" + userData + '\'' +
                    ", userPreferences='" + userPreferences + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        FutureExperiment userServices = new FutureExperiment();
        int userId1 = 6; // Should succeed
        int userId2 = 7; // Should fail for userData
        int userId3 = 5; // should fail user preferences

        CompletableFuture<CombinedUserResult> combinedResult1 = userServices.fetchCombinedUserData(userId1);
        CompletableFuture<CombinedUserResult> combinedResult2 = userServices.fetchCombinedUserData(userId2);
        CompletableFuture<CombinedUserResult> combinedResult3 = userServices.fetchCombinedUserData(userId3);

        try {
            System.out.println("Combined result for user " + userId1 + ": " + combinedResult1.get());
            System.out.println("Combined result for user " + userId2 + ": " + combinedResult2.get());
            System.out.println("Combined result for user " + userId3 + ": " + combinedResult3.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}