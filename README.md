# Performance Comparison of Adjacency List and Adjacency Matrix using BFS and Dijkstra's Algorithm in an Intelligent Route System

![Java](https://img.shields.io/badge/Java-Latest-orange)
![Course](https://img.shields.io/badge/Course-Data%20Structures-blue)
![Status](https://img.shields.io/badge/Status-Completed-green)

---

## Project Overview

This repository contains the source code, datasets, benchmarking files, and report for a Data Structures final project that compares the performance of:

- Adjacency List
- Adjacency Matrix

using:

- Breadth-First Search (BFS)
- Dijkstra's Algorithm

The project evaluates:

- BFS execution time
- Dijkstra execution time
- Memory usage
- Scalability on sparse graphs
- Scalability on dense graphs
- Theoretical complexity vs practical performance

---

## Team Members

| Name | Student ID |
|--------|--------|
| Kevin Alexander Kosuma | 2902708344 |
| Rhandy Ryffat Ravello | 2902717582 |
| Jordan Tommy Gazali | 2902709151 |

---

## Project Background

Route planning systems such as GPS navigation, logistics management, and transportation applications rely heavily on graph data structures.

This project investigates how graph representation affects algorithm performance by implementing an Intelligent Route System using:

- Adjacency List
- Adjacency Matrix

and comparing their behavior when running BFS and Dijkstra's Algorithm.

---

## Data Structures Used

### Adjacency List

Adjacency List stores only existing connections between vertices.

Advantages:

- Efficient memory usage for sparse graphs
- Faster traversal performance
- Complexity: O(V + E)

Disadvantages:

- Edge lookup requires traversing neighbor lists
- Less efficient for dense graphs

---

### Adjacency Matrix

Adjacency Matrix stores graph connections in a 2D array.

Advantages:

- Constant-time edge lookup O(1)
- Simple implementation

Disadvantages:

- High memory consumption
- Space complexity O(V²)

---

## Algorithms Used

### Breadth-First Search (BFS)

Applications:

- Route exploration
- Connectivity checking
- Shortest path in unweighted graphs

Complexity:

- Adjacency List: O(V + E)
- Adjacency Matrix: O(V²)

---

### Dijkstra's Algorithm

Applications:

- GPS navigation
- Logistics optimization
- Network routing

Complexity:

- Adjacency List + Priority Queue:
  O((V + E) log V)

- Adjacency Matrix:
  O(V²)

---

## Intelligent Route System

The program allows users to:

- Load graph datasets
- View available cities
- Select source and destination cities
- Find shortest routes using Dijkstra's Algorithm
- Traverse graphs using BFS
- Run performance benchmarks

The application runs in a terminal-based interface.

---

## Dataset Configuration

### Sparse Graphs

| Dataset | Vertices | Edges |
|----------|----------|----------|
| Small | 100 | 300 |
| Medium | 500 | 1500 |
| Large | 1000 | 3000 |

### Dense Graphs

| Dataset | Vertices | Edges |
|----------|----------|----------|
| Small | 100 | 4000 |
| Medium | 500 | 50000 |
| Large | 1000 | 200000 |

Datasets are generated automatically using `DatasetGenerator.java`.

---

## Benchmark Methodology

For every dataset:

1. Load graph into Adjacency List
2. Load graph into Adjacency Matrix
3. Measure memory usage
4. Execute BFS 100 times
5. Execute Dijkstra 100 times
6. Repeat benchmark 3 times
7. Use the third benchmark result for analysis

Execution time is measured using:

```java
System.nanoTime()
```

---

## Complexity Comparison

| Operation | Adjacency List | Adjacency Matrix |
|------------|------------|------------|
| Edge Lookup | O(degree) | O(1) |
| BFS | O(V + E) | O(V²) |
| Dijkstra | O((V + E) log V) | O(V²) |
| Memory Usage | O(V + E) | O(V²) |

---

## Key Findings

### Sparse Graphs

- Adjacency List consistently achieved lower runtime.
- Adjacency List consumed less memory.
- Better scalability for large sparse datasets.

### Dense Graphs

- Adjacency Matrix achieved lower runtime.
- Adjacency Matrix consumed less memory.
- Better performance for highly connected graphs.

### Overall

The best graph representation depends on graph density:

- Sparse Graph → Adjacency List
- Dense Graph → Adjacency Matrix

---

## Running the Program

Compile:

```bash
javac *.java
```

Run:

```bash
java Main
```

---

## Project Structure

```text
Main.java

GraphList.java
GraphMatrix.java

BFSList.java
BFSMatrix.java

DijkstraList.java
DijkstraMatrix.java

BenchmarkList.java
BenchmarkUtils.java

DatasetGenerator.java

datasets/
├── sparse_small.csv
├── sparse_medium.csv
├── sparse_large.csv
├── dense_small.csv
├── dense_medium.csv
└── dense_large.csv
```

---

## References

- GeeksforGeeks – BFS for Graph
- GeeksforGeeks – Dijkstra Algorithm
- Programiz – Graph Data Structure
- Abdul Bari Graph Representation Series
- William Fiset Graph Theory Series

---

---
## Raw Benchmark Result
https://docs.google.com/spreadsheets/d/1v8N2hkcq3Z54z4txBK31Ok1nGC2qL4GRzNdC94-uAyM/edit?gid=0#gid=0

---

## Repository

GitHub Repository:

https://github.com/rhandy59/data-structure-final-project-repository
