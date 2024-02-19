# Labyrinth.Solver.Algorithm


<p align="center">
  <a href="https://github.com/cagatay-softgineer">
    <img width="100%" src="https://i.hizliresim.com/op3dmaj.png" alt="@softgineer's Portfolio">
  </a>
  <br>
  <a href="#-what-does-it-include">
    📚 What Does It Include
  </a>
  <h1></h1>
  <a href="#-project-tree">
    🌲 Project Tree
  </a>
  <h1></h1>
  <a href="#-screenshots">
    📸 Screenshots
  </a>
</p>

---


## 📚 **What does it include?**

<a href="https://www.javatpoint.com/bfs-algorithm-in-java">
    <img src="https://i.hizliresim.com/rio2zjm.png" alt="@BFS Vizulate With Graph"/>
</a>

What is BFS?

Breadth-first search (BFS) is an algorithm that traverses a graph or tree data structure in a breadth-first manner, meaning that it explores all the nodes at the current depth level before moving on to the nodes at the next depth level. BFS is often used for finding the shortest path between two nodes in a graph, as well as for other tasks such as traversing a graph to find connected components, testing for bipartite graphs, and finding the shortest path in a maze.

Here is a high-level summary of the BFS algorithm:

   1. Initialize a queue and a set to store visited nodes.
   
   2. Add the starting node to the queue and the set of visited nodes.
   
   3.While the queue is not empty:
         
         1.Remove the first node from the queue.
         
         2.Mark the node as visited.
         
         3.Add all of the unvisited neighbors of the node to the queue.
         
         4.Repeat this process until the queue is empty.

BFS is implemented using a queue data structure, which allows us to store the nodes that are waiting to be explored. The algorithm works by starting at the root node and adding all of its children to the queue. It then removes the first node from the queue and marks it as visited, and adds all of its unvisited children to the queue. This process is repeated until the queue is empty.

BFS has a time complexity of O(V+E), where V is the number of nodes and E is the number of edges in the graph. This makes it suitable for use on large graphs, as it will not take too long to traverse the entire graph. However, BFS may use a large amount of memory, as it needs to store the entire breadth of the search tree at any given point in time.[Learn more with the BFS Algorithm](https://www.javatpoint.com/bfs-algorithm-in-java) Additionally, watch *[this video](https://www.youtube.com/watch?v=pcKY4hjDrxk)* to see **what is bfs algorithm and dfs algorithm** to obtain some extra information.

---

BFS Algorithm Example With Java:

```java
// Java program to print BFS traversal from a given source
// vertex. BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency
// list representation
class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w) { adj[v].add(w); }
 
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue
            = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
 
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
 
            // Get all adjacent vertices of the dequeued
            // vertex s If a adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
 
    // Driver method to
    public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Breadth First Traversal "
            + "(starting from vertex 2)");
 
        g.BFS(2);
    }
}
```

Output:

    Following is Breadth First Traversal (starting from vertex 2) 
    
    2 0 3 1 
    
---
    
### 🌲 **Project tree**

```text
.
├── .idea
│   │   ├── .gitignore
│   │   ├── misc.xml
│   │   ├── modules.xml
│   │   ├── uiDesigner.xml
│   │   └── vcs.xml
├── out
│   ├── production
│   │   ├── Algoritma Labirent Solver
│   │   │   ├── CozumAlgoritmasi.class
│   │   │   ├── Kordinat.class
│   │   │   ├── Labirent.class
│   │   │   ├── labirent.txt
│   │   │   └── labirent1.txt
├── src
│   │   ├── CozumAlgoritmasi.java
│   │   ├── Kordinat.java
│   │   ├── Labirent.java
│   │   ├── labirent.txt
│   │   └── labirent1.txt
├── Algoritma Labirent Solver.iml
└── README.md
3 directories, 17 files
```

---

## 📸 **Screenshots**

### Labyrinth:

<p align="center">
  <img src="https://i.hizliresim.com/q9w1yy2.png" alt="Labyrinth">
</p>

### Output:

<p align="center">
  <img src="https://i.hizliresim.com/d68lmne.png" alt="Labyrinth Solver Algorithm Output">
</p>
