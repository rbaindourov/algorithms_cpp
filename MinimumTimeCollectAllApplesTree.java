/*

Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

 

Example 1:


Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 2:


Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 3:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0
*/
import java.util.*;




class MinimumTimeCollectAllApplesTree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(0, -1, graph, hasApple); 
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        int totalTime = 0;
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue;
            int childTime = dfs(child, node, graph, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        
        
        //Map<String, Integer> stringLength = new HashMap<>();
        //System.out.println(stringLength.get("John"));
        //System.out.println(stringLength.computeIfAbsent("John", s -> s.length()));
           
        
        MinimumTimeCollectAllApplesTree solution = new MinimumTimeCollectAllApplesTree();
        
        // Test case 1
        int n1 = 7;
        int[][] edges1 = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple1 = Arrays.asList(false,false,true,false,true,true,false);
        System.out.println(solution.minTime(n1, edges1, hasApple1)); // Output: 8

        // Test case 2
        int n2 = 7;
        int[][] edges2 = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple2 = Arrays.asList(false,false,true,false,false,true,false);
        System.out.println(solution.minTime(n2, edges2, hasApple2)); // Output: 6
        
        // Test case 3
        int n3 = 7;
        int[][] edges3 = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple3 = Arrays.asList(false,false,false,false,false,false,false);
        System.out.println(solution.minTime(n3, edges3, hasApple3)); // Output: 0
        
    }
}
