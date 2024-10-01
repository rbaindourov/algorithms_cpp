class Solution {
  class Node {
	List<Node> child;
	int val;
	Node(int v) {
		child = new ArrayList<>();
		val = v;
	}
}

int res;
private int solve(Node root, Node parent) {
	if(root == null) return 0;

	int ct = -1, total = 0;
	boolean flag = true;

	for(Node c : root.child) {
		if(c == parent) continue;
		int top = solve(c, root);
		total += top;

		if(ct == -1) {
			ct = top;
		} else if(ct != top){
			flag = false;
		}
	}

	if(flag) {
		res++;
	}
	return total+1;
}

public int countGoodNodes(int[][] edges) {
	Map<Integer, Node> map = new HashMap<>();
	map.put(0, new Node(0));

	for(int[] edge: edges) {
		int u = edge[0], v = edge[1];
		if(!map.containsKey(u)) map.put(u, new Node(u));
		if(!map.containsKey(v)) map.put(v, new Node(v));

		Node p = map.get(u), c = map.get(v);
		p.child.add(c);
		c.child.add(p);
	}

	res = 0;
	solve(map.get(0), null);
	return res;
}
}
