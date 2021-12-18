# Binary Search Tree & Hierarchical Sorting

## Overview
A custom Binary Search Tree (BST) architecture built from scratch to manage and query objects based on prioritized sorting attributes. This project demonstrates proficiency in recursive algorithms and non-linear data structures, moving beyond linear arrays and linked lists to execute efficient logarithmic O(log N) searches and insertions.

## Technical Concepts Demonstrated
* **Tree Data Structures & Generics:** Engineered a generic `TreeNode<T>` class to support binary hierarchical data management and robust memory pointing without relying on the `java.util.TreeSet` library.
* **Recursive Algorithms:** Implemented complex recursive logic to handle in-order tree traversals, dynamic node insertions, and deep queries across nested subtrees.
* **Polymorphic Comparison & Sorting:** Utilized custom enumerations (`Attribute`) and an ordered attribute array to dynamically dictate BST placement, sorting nodes primarily by Author, and falling back to Page Count or ID for collision resolution.
* **Object-Oriented Encapsulation:** Protected the integrity of the binary tree structure by keeping root and branch pointers entirely private, forcing all interactions through validated public wrapper methods.