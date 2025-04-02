//-----------------------------------------------------
// Title: Graph Implementation with Bag Structure
// Author: Ahmet Orkun Yılmaz
// ID: 15100024924
// Section: 3
// Assignment: 1
// Description: This class implements an undirected graph using
//              a Bag data structure and provides BFS-based
//              functionality to determine valid new edges.
//-----------------------------------------------------

import java.util.*;

class Graph {
    private final int V; // Number of vertices
    private int E; // Number of edges
    private Bag<Integer>[] adj; // Adjacency list using Bag structure

    // Constructor: Initializes a graph with V vertices
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    // Adds an edge between two vertices
    //--------------------------------------------------------
    // Summary: Adds an undirected edge between v and w.
    // Precondition: v and w are valid vertex indices.
    // Postcondition: Edge (v, w) is added to the graph.
    //--------------------------------------------------------
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    // Returns adjacent vertices of v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // Returns number of vertices
    public int V() {
        return V;
    }

    // Returns number of edges
    public int E() {
        return E;
    }

    // Performs BFS to find the shortest distance between start and target
    //--------------------------------------------------------
    // Summary: Uses BFS to compute the shortest path from start to target.
    // Precondition: start and target are valid vertex indices.
    // Postcondition: Returns the shortest distance from start to target.
    //--------------------------------------------------------
    public int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[V];
        Arrays.fill(dist, -1); // Initialize distances as unreachable (-1)
        
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj[node]) {
                if (dist[neighbor] == -1) { // If not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return dist[target]; // Return shortest distance from start to target
    }

    // Finds valid new edges that do not reduce the X -> Y shortest path
    //--------------------------------------------------------
    // Summary: Identifies all possible edges that can be added without
    //          decreasing the shortest path distance between X and Y.
    // Precondition: X and Y are valid vertex indices.
    // Postcondition: Returns a list of valid new edges.
    //--------------------------------------------------------
    public List<String> findValidNewEdges(int X, int Y) {
        int originalDistance = bfs(X, Y);
        List<String> newEdges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (!isConnected(i, j)) {
                    // Temporarily add the edge and check the new shortest path
                    addEdge(i, j);
                    int newDistance = bfs(X, Y);
                    removeEdge(i, j);

                    if (newDistance == originalDistance) {
                        newEdges.add((char) ('a' + i) + " " + (char) ('a' + j));
                    }
                }
            }
        }
        return newEdges;
    }

    // Checks if two vertices are connected
    private boolean isConnected(int v, int w) {
        for (int neighbor : adj[v]) {
            if (neighbor == w) return true;
        }
        return false;
    }

    // Removes an edge (used for temporary testing)
    //--------------------------------------------------------
    // Summary: Removes the edge (v, w) from the graph.
    // Precondition: Edge (v, w) exists.
    // Postcondition: Edge (v, w) is removed.
    //--------------------------------------------------------
    private void removeEdge(int v, int w) {
        adj[v].items.remove((Integer) w);
        adj[w].items.remove((Integer) v);
        E--;
    }
}
