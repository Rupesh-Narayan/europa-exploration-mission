# Europa Exploration Mission Navigation Module

## Project Overview

This project implements a navigation module for NASA's Europa Exploration Mission. It simulates the movement of robots on a grid-based plateau, allowing them to explore the terrain based on given commands.

---

## Prerequisites

- **Java 17** – Required for compilation and execution.
- **Maven** – Used to build and run the project.

---

## Running the Project

- Clone the repository:
    - git clone git@github.com:Rupesh-Narayan/europa-exploration-mission.git
- cd europa-exploration-mission

- Build the project
  - mvn compile

- Run the project
  - mvn exec:java -Dexec.mainClass=com.maxhome.europa.EuropaMain


You can provide input directly via the console or redirect input from a file.

---

## Input Format

- Line 1: Plateau dimensions (e.g., 5 5)
- Line 2: First robot's initial position (e.g., 1 2 N)
- Line 3: Movement instructions (e.g., LMLMLMLMM)
- Line 4: Second robot's initial position
- Line 5: Movement instructions
...

---

## Output Format

Each robot's final position and orientation will be printed to the console:

1 3 N\
5 1 E

---

## Notes

- Input must follow the exact format shown above.
- Each robot processes its commands sequentially, one after another.
- Edge cases such as invalid commands are handled gracefully.
- Out-of-bounds movements are ignored, and the robot remains in its current position.

---

## Technologies Used

- Java 17
- Maven
- SLF4J + Lombok (for logging and boilerplate reduction)


