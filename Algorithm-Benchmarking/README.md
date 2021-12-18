# Algorithm Benchmarking: Performance & Complexity Analysis

## Overview
A Java-based benchmarking suite designed to measure and compare the CPU execution times of different cryptographic search algorithms. This project demonstrates a practical understanding of algorithmic time complexity (Big-O notation) by physically profiling the performance differences between direct access and brute-force methods.

## Technical Concepts Demonstrated
* **Time Complexity Analysis:** Implemented and profiled two distinct algorithms: a constant time `O(1)` direct-access decryption and an exponential time `O(10^N)` brute-force generator.
* **Performance Profiling:** Developed a custom benchmarking harness utilizing system clock cycles (`System.currentTimeMillis()`) to accurately measure execution times in milliseconds across multiple averaged runs.
* **State Encapsulation:** Engineered a secure `LockBox` object that encapsulates its internal state, forcing external classes to interact with it exclusively through proper authentication pipelines.