# Java Data Structures & Software Architecture Portfolio

## Overview
A comprehensive, curated collection of core computer science fundamentals implemented entirely from scratch in Java. This repository demonstrates a clear progression from basic memory allocation to advanced Object-Oriented Programming (OOP) architectures, algorithmic time complexity analysis, and custom data structure engineering.

## Core Implementations & Technical Concepts

### `Priority-Queue-Min-Heap` (Min-Heap & State Machines)
* Engineered a custom `AssignmentQueue` that dynamically enforces Min-Heap invariants (percolate up/down) without utilizing `java.util.PriorityQueue`, guaranteeing strict O(log N) complexity for enqueuing and dequeuing.
* Designed an advanced Command-Line Interface using a Java `Enum` to act as a robust state machine, safely routing user inputs and managing application transitions.

### `Binary-Search-Tree` (Hierarchical Sorting & Recursion)
* Built a custom Binary Search Tree (BST) architecture using generic `TreeNode<T>` classes to execute efficient logarithmic O(log N) searches and insertions.
* Implemented complex recursive logic to handle in-order tree traversals, dynamic node insertions, and deep queries across nested subtrees based on polymorphic Enum attributes.

### `Iterable-Stack-Implementation` (Stack ADT & Iterators)
* Engineered a custom `TileStack` utilizing manual pointer management and linked nodes to enforce strict O(1) LIFO operations (`push`, `pop`, `peek`).
* Implemented the standard `java.lang.Iterable` and `java.util.Iterator` interfaces, creating a custom iterator to allow safe, sequential traversal of the stack's internal state without breaking encapsulation.

### `Singly-Linked-List` (Custom Data Structures & Sorting)
* Engineered a generic `LinkedNode<T>` class to handle manual memory pointer allocation without relying on standard Java Collections.
* Implemented an in-place insertion sort algorithm capable of dynamically reorganizing the linked list based on polymorphic Enum attributes.

### `Recursive-File-Explorer` (Recursion & File I/O)
* Built a recursive directory crawler utilizing `java.io.File` to navigate deeply nested file structures.
* Implemented custom search filters to parse and return files based on specific byte-size thresholds, keyword substrings, and exact naming conventions.

### `Algorithm-Benchmarking` (Big-O Complexity Profiling)
* Developed an automated benchmarking suite to measure and compare the CPU execution time (in milliseconds) of different cryptographic search algorithms.
* Demonstrated the physical performance differences between constant time O(1) direct-access and exponential time O(10^N) brute-force methodologies.

### `Polymorphic-GUI-Simulation` (Interfaces & Inheritance)
* Engineered a unified `TankListener` interface, allowing a core rendering loop to autonomously manage an unbounded `ArrayList` of diverse objects without explicit type-checking.
* Designed a robust class hierarchy utilizing super-classes and specialized sub-classes to significantly reduce code duplication while enabling unique entity logic.

### `Object-Oriented-Simulation` (Encapsulation & State Management)
* Decoupled a main rendering engine from graphical entities, allowing for independent state management of multiple on-screen objects.
* Implemented asynchronous rendering loops that dynamically calculate velocity vectors and hit-box collisions concurrently.

### `Exception-Handling-Validation` (Defensive Programming)
* Enforced strict input validation protocols to verify alphanumeric formatting and array boundary constraints before executing state changes.
* Utilized custom runtime exceptions to gracefully catch and report data corruption instead of allowing system crashes, backed by an automated unit testing suite.

### `Interactive-GUI` (Event-Driven Programming)
* Implemented active event listeners to trigger asynchronous state changes based on user keyboard and mouse interrupts.
* Utilized a third-party graphics library (`processing.core`) to manage continuous visual rendering loops and asset environments.

### `Static-Arrays` (Data Parsing & State Management)
* Engineered algorithms to parse alphanumeric string inputs, validate formatting, and execute mathematical moving averages based on dynamic historical subsets.
* Designed text-based histograms to map frequency distributions across shifting data arrays.