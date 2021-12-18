# Exception Handling & Data Validation: Climbing Tracker

## Overview
A robust Java utility designed to process, track, and analyze bouldering statistics. This module builds upon basic array manipulation by introducing strict data validation, defensive programming techniques, and comprehensive error handling to ensure system stability against malformed or out-of-bounds inputs.

## Technical Concepts Demonstrated
* **Defensive Programming & Validation:** Enforces strict input validation protocols to verify alphanumeric formatting and array boundary constraints before executing state changes.
* **Robust Exception Handling:** Utilizes standard and custom exceptions (`IllegalArgumentException`, `DataFormatException`, `RuntimeException`) to gracefully catch and report data corruption or invalid operations instead of allowing system crashes.
* **Automated Edge-Case Testing:** Includes a comprehensive unit testing suite designed to intentionally trigger failures, verifying that exceptions are thrown correctly and predictably under boundary conditions.