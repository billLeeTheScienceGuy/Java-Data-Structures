# Object-Oriented Simulation: Graphical Entity Management

## Overview
A real-time, interactive simulation built with Java and the Processing core library. This project demonstrates strong Object-Oriented Programming (OOP) principles by fully decoupling the main rendering engine from the graphical entities, allowing for independent state management of multiple on-screen objects.

## Technical Concepts Demonstrated
* **Encapsulation & OOP Design:** Engineered a standalone `Fish` entity class to encapsulate local state data (position, movement speed, interaction status) apart from the global application state.
* **Independent State Management:** Implemented logic allowing multiple instantiated objects to maintain independent asynchronous states (e.g., calculating individual velocity vectors and hit-box collisions concurrently).
* **Render Loop Optimization:** Managed a continuous graphical drawing loop that dynamically parses an object array to render varying asset states (swimming, dragging, idle) based on real-time user keyboard and mouse interrupts.