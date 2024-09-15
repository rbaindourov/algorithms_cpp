import java.util.HashMap;

class FrequentUser {
    public static void main(String[] args) {
        FrequentUser frequentUser = new FrequentUser();

        int[] visits1 = {1,2,3,1,2,3,1,2,3,1};
        int frequentUser1 = frequentUser.frequentUser(visits1);
        System.out.println("Frequent User: " + frequentUser1);  // Expected output: 1

        int[] visits2 = {5,0,5,0,5,0,5,0,1,1,1,1,1};
        int frequentUser2 = frequentUser.frequentUser(visits2);
        System.out.println("Frequent User: " + frequentUser2);  // Expected output: 5

        int[] visits3 = {3,2,2,1,3,2,3,0,0,1,4,1};
        int frequentUser3 = frequentUser.frequentUser(visits3);
        System.out.println("Frequent User: " + frequentUser3);  // Expected output: -1
    }

    public int frequentUser(int[] visits) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int frequentVisitThreshold = visits.length / 4;

        for(int visit : visits){
            if( visit!=0 ){
                countMap.computeIfAbsent(visit, (k) -> 1);
                countMap.computeIfPresent(visit, (k, v) -> v + 1);
            }
        }

        for(int key : countMap.keySet()){
            if(countMap.get(key) > frequentVisitThreshold){
                return key;
            }
        }
        return -1;
    }
}