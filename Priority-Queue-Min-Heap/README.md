# Task Scheduler: Priority Queue & Min-Heap Architecture

## Overview
A Java-based task management simulation built upon a custom Priority Queue Abstract Data Type (ADT). This project demonstrates advanced data structure engineering by implementing an array-based Min-Heap to guarantee logarithmic O(log N) insertions and extractions, ensuring tasks with the earliest deadlines are always prioritized efficiently.

## Technical Concepts Demonstrated
* **Array-Based Min-Heap:** Engineered a custom `AssignmentQueue` that dynamically enforces Min-Heap invariants (percolate up/down) without utilizing `java.util.PriorityQueue`, guaranteeing strict O(log N) complexity for enqueuing and dequeuing operations.
* **Enum-Driven State Machine:** Designed an advanced Command-Line Interface (CLI) using a Java `Enum` (`AssignmentPlannerState`) to act as a robust state machine, safely routing user inputs and managing application transitions.
* **Iterator Design Pattern:** Implemented a custom `AssignmentIterator` to allow safe, sequential, deep-copy traversals of the priority queue's internal state without exposing the underlying array structure or mutating the heap.
* **Polymorphic Equality & Comparison:** Utilized `java.lang.Comparable` and overridden `equals()` methods to ensure robust, chronological sorting based on dynamically parsed Date formats.