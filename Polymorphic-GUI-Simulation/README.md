# Polymorphic GUI Simulation: Advanced Interface Design

## Overview
An interactive graphical simulation that utilizes advanced Object-Oriented Programming principles to manage a highly dynamic ecosystem of interactive entities. This project demonstrates the power of Polymorphism and Interfaces by abstracting distinct graphical components (UI Buttons, static environment objects, dynamic AI entities) into a unified rendering and event pipeline.

## Technical Concepts Demonstrated
* **Polymorphism & Interface Architecture:** Engineered a unified `TankListener` interface, allowing the core rendering loop to autonomously manage an unbounded `ArrayList` of diverse objects without requiring explicit type-checking.
* **Inheritance Hierarchies:** Designed a robust class hierarchy where specialized sub-classes (`BlueFish`, `BlackFish`, `AddBlueFishButton`) extend base behaviors from super-classes (`Fish`, `Button`), significantly reducing code duplication while enabling unique movement and interaction logic.
* **Advanced State Interactions:** Implemented spatial tracking allowing entities to mathematically calculate distances and interact dynamically with other independent objects in the environment (e.g., entities calculating vectors to travel between moving targets).