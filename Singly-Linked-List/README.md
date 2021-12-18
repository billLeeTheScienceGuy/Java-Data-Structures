# Custom Singly Linked List & Insertion Sort

## Overview
A Java-based implementation of a generic Singly Linked List built entirely from scratch without utilizing standard Java Collections. This project demonstrates core memory management, node traversal, and dynamic sorting algorithms by organizing complex objects based on variable criteria.

## Technical Concepts Demonstrated
* **Custom Data Structures & Generics:** Engineered a generic `LinkedNode<T>` class to handle manual memory pointer allocation and linear structural logic.
* **Algorithmic Sorting:** Implemented an in-place insertion sort algorithm capable of dynamically reorganizing the linked list without allocating auxiliary arrays.
* **Polymorphic Comparison:** Utilized Java Enums and a custom `compareTo` architecture to allow nodes to be sorted interchangeably by different data types (e.g., Integer IDs, String titles, numeric page limits).
* **Robust Object-Oriented Design:** Strictly encapsulated internal node pointers to ensure list integrity, forcing all structural interactions to occur safely through public wrapper methods.