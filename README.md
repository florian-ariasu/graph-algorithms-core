## 🎯 Advanced Graph Algorithms Implementation Suite

### 🌟 Project Overview
This repository contains powerful implementations of sophisticated graph algorithms solving three distinct computational problems. The solutions are implemented in Java, emphasizing efficiency and clean code practices.

### 🚀 Problem Solutions

#### 1. Common Elementary Paths Counter (Numarare) 🔍
##### Algorithm Overview
- **Core Concept**: Dynamic Programming with Graph Intersection
- **Implementation Details**:
  - 📊 Constructs two directed acyclic graphs (DAGs) from input
  - 🔄 Identifies common edges between both graphs
  - 💡 Uses DP to count common paths from source to destination
  - 🧮 Maintains modulo arithmetic (10^9 + 7) for large numbers
- **Time Complexity**: O(V + E), where V is number of vertices and E is number of edges
- **Space Complexity**: O(V + E)

#### 2. Maximum Cities Path Finder (Trenuri) 🚂
##### Algorithm Overview
- **Core Concept**: Topological Sort with Path Length Maximization
- **Implementation Details**:
  - 🗺️ Converts city names to indices using HashMap for efficient lookup
  - 📈 Implements topological sorting to respect DAG properties
  - 🎯 Calculates maximum possible path length using dynamic programming
  - 🛤️ Maintains path lengths through graph traversal
- **Time Complexity**: O(V + E)
- **Space Complexity**: O(V)

#### 3. Minimum Cost Multi-Source Paths (Drumuri) 🌐
##### Algorithm Overview
- **Core Concept**: Modified Dijkstra's Algorithm with Multiple Sources
- **Implementation Details**:
  - 🔍 Implements three Dijkstra searches (from x, y, and reversed from z)
  - ⚡ Uses Priority Queue for efficient minimum distance calculation
  - 🎯 Combines distances to find optimal meeting point
  - 🛡️ Handles edge cases with INF value checks
- **Time Complexity**: O((V + E) log V)
- **Space Complexity**: O(V + E)

### 🛠️ Technical Implementation Details

#### Data Structures Used
- **Priority Queue** 📊: For efficient minimum distance calculations in Dijkstra's algorithm
- **ArrayList** 📝: For adjacency list representation of graphs
- **HashMap** 🗃️: For mapping city names to indices
- **Arrays** 📊: For dynamic programming and distance storage

#### Code Organization
- ✨ Each solution is encapsulated in its own class
- 🎯 Utilizes Java's record feature for efficient pair storage
- 📁 Implements clean file I/O with BufferedReader/BufferedWriter
- 📏 Follows Google Java Style Guide conventions

### ⚡ Performance Considerations
- 🚀 All solutions are optimized to meet the time constraints specified in the problem statements
- 💾 Memory usage is kept efficient through appropriate data structure choices
- 🛡️ Edge cases are handled gracefully with proper boundary checking

### 🔨 Building and Running
# Compile all source files
```
make build
```

# Run individual solutions
```
make run-p1
```
```
make run-p2
```
```
make run-p3
```

> [!IMPORTANT]
> Ensure that input files are created in advance

> [!TIP]
> You may consider adding new rules in the Makefile to automate the creation and removal of required input/output files

### 🧪 Testing
The solutions have been tested against the provided test cases and pass all performance requirements:
- ⏱️ Numarare: 2s (C/C++), 3s (Java)
- ⏱️ Trenuri: 3s (C/C++), 4s (Java)
- ⏱️ Drumuri: 2.5s (C/C++), 3.5s (Java)

### 🔮 Future Improvements
- 🔄 Potential optimization of space complexity in Trenuri solution
- ⚡ Possible parallelization of Dijkstra searches in Drumuri
- 🎯 Implementation of more efficient data structures for graph representation

---
#### 🌟 Contributing
Feel free to open issues and pull requests for any improvements you think would benefit this project!

#### 📜 License
This project is licensed under the MIT License - see the LICENSE file for details
