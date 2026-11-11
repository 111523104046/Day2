
import java.util.*;

public class Task3_Graph {

    static int n = 10;

    // Adjacency list
    static ArrayList<Integer>[] graph =
        new ArrayList[n];

    // Add route
    static void addEdge(int u, int v) {

        graph[u].add(v);
        graph[v].add(u);
    }

    // BFS - Shortest route in number of hops
    static void BFS(int start, int destination) {

        boolean visited[] = new boolean[n];

        int parent[] = new int[n];

        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == destination) {
                break;
            }

            for (int next : graph[current]) {

                if (!visited[next]) {

                    visited[next] = true;
                    parent[next] = current;

                    queue.add(next);
                }
            }
        }

        if (!visited[destination]) {
            System.out.println("No route available");
            return;
        }

        // Reconstruct shortest path
        ArrayList<Integer> path = new ArrayList<>();

        int current = destination;

        while (current != -1) {

            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);

        System.out.println("Shortest Route: " + path);

        System.out.println(
            "Number of Hops: " + (path.size() - 1));
    }

    // DFS - Find reachable hubs
    static void DFS(int current, boolean visited[]) {

        visited[current] = true;

        System.out.print(current + " ");

        for (int next : graph[current]) {

            if (!visited[next]) {

                DFS(next, visited);
            }
        }
    }

    public static void main(String args[]) {

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add 10 hubs and their routes
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 5);
        addEdge(2, 6);
        addEdge(3, 7);
        addEdge(4, 7);
        addEdge(5, 8);
        addEdge(6, 9);
        addEdge(8, 9);

        // Display adjacency list
        System.out.println("LOGISTICS NETWORK");

        for (int i = 0; i < n; i++) {

            System.out.println(
                "Hub " + i + " : " + graph[i]);
        }

        // BFS
        System.out.println("\nBFS - SHORTEST ROUTE");

        BFS(0, 9);

        // DFS
        System.out.println("\nDFS - REACHABLE HUBS");

        boolean visited[] = new boolean[n];

        System.out.print("From Central Depot (0): ");

        DFS(0, visited);

        System.out.println();
    }
}
