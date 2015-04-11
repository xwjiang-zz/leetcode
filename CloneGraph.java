public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode front = queue.poll();
            for (UndirectedGraphNode adj : front.neighbors) {
                if (!map.containsKey(adj)) {
                    queue.add(adj);
                    map.put(adj, new UndirectedGraphNode(adj.label));
                }
                map.get(front).neighbors.add(map.get(adj));
            }
        }
        return map.get(node);
    }
}
