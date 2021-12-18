# Iterable Stack Implementation & Game Logic

## Overview
A Java-based simulation of a tile-matching game built entirely on a custom Stack Abstract Data Type (ADT). This project demonstrates how to engineer fundamental LIFO (Last-In, First-Out) data structures from scratch using singly-linked nodes, while fully integrating standard Java interfaces to allow seamless iteration over custom collections.

## Technical Concepts Demonstrated
* **Stack Abstract Data Type (ADT):** Engineered a custom `TileStack` utilizing manual pointer management and linked nodes to enforce strict O(1) LIFO operations (`push`, `pop`, `peek`).
* **Iterator Design Pattern:** Implemented the `java.lang.Iterable` and `java.util.Iterator` interfaces, creating a custom `TileListIterator` to allow safe, sequential traversal of the stack's internal state without exposing the underlying node architecture or breaking encapsulation.
* **Algorithmic State Management:** Developed a game engine (`TileMatchingGame`) that dynamically manages arrays of custom stacks, processing complex object-matching logic and state resets across multiple columns simultaneously.
* **Polymorphic Equality:** Overrode the standard `Object.equals()` method within the `Tile` class to ensure robust, value-based comparison logic using custom Enum states.