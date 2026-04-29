import java.util.*;

public class Everypath {
    static class Edge {
        char to;
        Edge(char to) {
            this.to = to; }
    }

    static Map<Character, List<Edge>> adjList = new HashMap<>();

    public static void main(String[] args) {

        addEdge('A', 'B');
        addEdge('B', 'C');
        addEdge('C', 'D');
        addEdge('D', 'A');
        addEdge('A', 'C');


        char[] nodes = {'A', 'B', 'C', 'D'};

        for (char startNode : nodes) {
            // i use the startNode as a 'minimum' to avoid printing the same cycle 4 times
            dfs(startNode, startNode, 0, "" + startNode, new HashSet<>(), startNode);
        }
    }

    static void addEdge(char u, char v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v));
    }

    static void dfs(char start, char current, int edges, String path, Set<Character> visited, char minNode) {
        if (edges == 4) {
            if (current == start) {
                System.out.println(path);
            }
            return;
        }

        if (adjList.containsKey(current)) {

            for (Edge edge : adjList.get(current)) {

                // To avoid duplicate 'rotated' cycles, I only start cycles from the smallest node
                if (edge.to == start || (!visited.contains(edge.to) && edge.to > minNode)) {
                    visited.add(current);
                    dfs(start, edge.to, edges + 1, path + " -> " + edge.to, visited, minNode);
                    visited.remove(current);
                }
            }
        }
    }
}
