# Recursive File Explorer & CLI

## Overview
A Java-based recursive directory crawler and Command-Line Interface (CLI) utility. This project demonstrates deep file system traversal, custom search algorithms, and robust exception handling by dynamically parsing directory trees utilizing standard `java.io` components.

## Technical Concepts Demonstrated
* **Recursive File Traversal:** Navigates deeply nested directory structures utilizing recursive algorithms to identify, categorize, and extract file metadata without hard-coding path depth.
* **File I/O Search Algorithms:** Implements search filters to query the file system based on exact string names, keyword substrings, and physical byte size boundaries.
* **Interactive CLI Interface:** Designed an active, real-time command-line prompt using `Scanner` to receive and process user inputs against the local file system. 
* **Custom Exception Handling:** Employs defensive programming and `try/catch` blocks to gracefully handle restricted environments, deliberately throwing and managing `NotDirectoryException` and `NoSuchElementException` when paths are invalid.