# 2D Maze Game

A 2D maze game developed entirely in Java using Java Swing. The game features a player-controlled character navigating through a maze, with wall collision detection and custom maze layouts loaded from external files.

## Features

- **2D Gameplay:** Navigate through a maze using keyboard controls.
- **Character Movement:** Control a character with sprite-based animations.
- **Collision Detection:** Prevent the player from moving through maze walls.
- **Custom Maze Layouts:** Maze structures are stored in external files, allowing different maze designs by modifying the corresponding files without changing the game logic.
- **Tile-Based Rendering:** Build the game environment using individual wall and floor textures.
- **Java Swing Interface:** Render the game and handle user interactions using Java Swing.

## Technologies

- Java
- Java Swing
- Java AWT
- 2D Graphics and Rendering
- Sprite-Based Animation
- File Handling

## How It Works

The maze is represented through external files that define its layout. These files determine the placement of walls and walkable paths.

The game reads the maze data and renders the corresponding environment. The player can navigate through the maze using keyboard input, while collision detection ensures that the character cannot pass through walls.

Because maze layouts are stored separately from the game logic, different maze designs can be created simply by modifying the corresponding files.

## Project Structure

The project consists of the following main components:

- **Game Logic:** Handles player movement, collision detection and game mechanics.
- **Maze Data:** External files containing the maze layouts.
- **Character Sprites:** Image assets used for the player character and animations.
- **Game Rendering:** Responsible for displaying the maze, character and game environment.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Eclipse IDE or another Java IDE

### Running the Game

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
   ```

2. Import the project into your Java IDE.
3. Make sure the image assets and maze data files are located in their expected directories.
4. Run the main Java class to start the game.

## Screenshot

![2D Maze Game](screenshots/maze-game.png)

## Author

Developed as a personal Java programming project.

---

*Built with Java Swing.*

<img width="1441" height="794" alt="grafik" src="https://github.com/user-attachments/assets/90b8e66a-98c0-41c2-b172-824381960f4f" />
