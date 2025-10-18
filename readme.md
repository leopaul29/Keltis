# Keltis Card Game

A Java implementation of the award-winning board game **Keltis** by Reiner Knizia. This university project recreates the strategic card game where players navigate stone paths by playing cards in ascending or descending sequences to score maximum points.

## 🎮 About the Game

Keltis is a strategic card game where players use numbered cards to move their figures along stone paths, choosing whether to play cards in ascending or descending order. The game features wishing stones and bonuses along the paths, with scoring based on how far figures advance.

Originally designed by Reiner Knizia and published by KOSMOS in 2008, Keltis won the prestigious Spiel des Jahres (Game of the Year) award and spawned numerous variants and expansions.

## 🎯 Game Objective

The goal is to score the most points by:
- Moving your playing pieces as far as possible along five colored stone paths
- Collecting wishing stones and bonus tiles along the way
- Strategic card management - deciding which paths to pursue and which to abandon
- Timing your card plays to maximize points while avoiding negative scoring zones

## 🃏 Game Mechanics

The game uses 110 cards with two cards of each value (0-10) in five different colors. Key mechanics include:

- **Path Selection**: Choose which of the five colored paths to pursue
- **Card Direction**: After playing your first card, the second card determines whether you'll play ascending or descending
- **Risk/Reward**: The first three rows of each path lose points, while advancing further earns positive points
- **Bonus Tiles**: Collect points, extra moves, or wishing stones as you advance
- **End Game Trigger**: The game ends when five figures total reach the final three rows, or when the deck runs out

## 🛠️ Technologies Used

- **Java** - Core programming language
- **Swing/JavaFX** - GUI framework (adjust based on your implementation)
- **Object-Oriented Design** - Game logic and architecture
- **MVC Pattern** - Separation of game model, view, and controller

## 📦 Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- IDE (IntelliJ IDEA, Eclipse, or NetBeans recommended)

### Running the Game

1. **Clone the repository**
   ```bash
   git clone https://github.com/leopaul29/Keltis.git
   cd Keltis
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Run the game**
   ```bash
   java -cp bin Main
   ```

   *Note: Adjust the main class name based on your project structure*

### Using an IDE

1. Open the project in your preferred Java IDE
2. Build the project
3. Run the main class to start the game

## 🎲 How to Play

1. **Setup**: Each player receives a hand of cards and places their figures at the starting position
2. **Turn Structure**: 
   - Play one card (either discard it or play it to a path)
   - If playing to a path, move your figure one space forward
   - Draw a new card from the deck or discard pile
3. **Card Sequences**: 
   - First card on a path: places your figure on that colored path
   - Second card: determines if you're playing ascending or descending
   - Subsequent cards: must follow the chosen direction
4. **Scoring**: Points are calculated based on position on paths plus collected bonuses
5. **Winning**: The player with the most points at game end wins

## 📁 Project Structure

```
Keltis/
├── src/
│   ├── model/          # Game logic and data structures
│   ├── view/           # UI components
│   ├── controller/     # Game flow control
│   └── Main.java       # Application entry point
├── resources/          # Images, sounds, and assets
├── lib/                # External libraries
└── README.md
```

*Note: Adjust structure based on your actual project organization*

## 🎓 Educational Context

This project was developed as part of university coursework to demonstrate:
- **Object-Oriented Programming** principles in Java
- **Software Design Patterns** (MVC, Factory, Observer, etc.)
- **GUI Development** and user interaction
- **Game Logic Implementation** with complex rules
- **Algorithm Design** for game AI (if implemented)
- **Testing and Debugging** strategies

## 🚀 Features

- ✅ Full implementation of Keltis card game rules
- ✅ Interactive graphical user interface
- ✅ Turn-based gameplay
- ✅ Score tracking and calculation
- ✅ Multiple player support (2-4 players)
- ⬜ AI opponent (if not yet implemented)
- ⬜ Save/Load game state (if not yet implemented)

## 🔍 Key Learning Outcomes

Through this project, I gained experience in:
- Translating board game rules into programmatic logic
- Managing complex game state and turn sequences
- Designing intuitive user interfaces for games
- Implementing event-driven programming
- Debugging multi-step game interactions
- Writing clean, maintainable Java code

## 🤝 Contributing

This is an educational project, but suggestions and improvements are welcome! Feel free to:
1. Fork the repository
2. Create a feature branch
3. Make your improvements
4. Submit a pull request

## 📜 License

This project is open source and available under the MIT License.

**Note**: Keltis is a copyrighted game by Reiner Knizia and KOSMOS. This implementation is for educational purposes only and is not affiliated with or endorsed by the original creators or publishers.

## 🙏 Acknowledgments

- **Reiner Knizia** - Original game designer
- **KOSMOS** - Original game publisher
- University professors and teaching assistants who guided this project
- The board gaming community for comprehensive rule explanations

## 📚 References

- [Keltis on BoardGameGeek](https://boardgamegeek.com/boardgame/34585/keltis)
- [Official Game Rules](https://www.ultraboardgames.com/keltis/game-rules.php)
- Knizia, R. (2008). *Keltis*. KOSMOS.

---

**Project Type**: University Assignment | **Language**: Java | **Year**: 2016

👤 **Author**: [@leopaul29](https://github.com/leopaul29)
