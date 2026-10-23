# PROG209 Swing Assignment: Basic Interactive GUI

![Java](https://img.shields.io/badge/Java-Swing-orange)
![Module](https://img.shields.io/badge/Module-PROG209-blue)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)

A basic interactive desktop application built with **Java Swing** for **PROG209 Event Driven Programming** at Limkokwing University of Creative Technology, Sierra Leone. It demonstrates a `JFrame`, `JPanel` and `JLabel`, inheritance, constructors and event handling.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Wireframe](#wireframe)
- [Screenshot](#screenshot)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [How It Works](#how-it-works)
- [Concepts Demonstrated](#concepts-demonstrated)
- [Author](#author)
- [References](#references)

## Overview

The application opens a single window with a heading, a custom-drawn logo and a welcome message. Two buttons let the user interact with the interface: one changes the label text and the other changes the panel background colour.

## Features

- Window titled **"Java Swing Assignment"** that closes the program when the close button is clicked
- `JFrame` variable `frame`, `JPanel` variable `panel` and `JLabel` variable `label`
- Original application icon and logo drawn with Java 2D (no external image file needed)
- **Change Text** button that cycles through the label messages
- **Change Background** button that cycles through the panel colours
- Components created on the Event Dispatch Thread using `SwingUtilities.invokeLater`

## Wireframe

The interface was planned as a wireframe before coding.

![alt text](<Figma .png>)

## Screenshot

> Add a screenshot of the running application as `docs/screenshot.png`, then it will appear below.

![Application screenshot]
![alt text](<Screenshot 1.png>)
![alt text](<Screenshot 2.png>)
![alt text](<Screenshot 3.png>)
## Project Structure

```
PROG209-SwingAssignment/
├── SwingAssignment.java   # Source code
├── README.md              # Project documentation
└── docs/
    ├── wireframe.png      # Interface wireframe
    └── screenshot.png     # Screenshot of the running app
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Any terminal, IntelliJ IDEA or VS Code with the Java extensions

### Run from the command line

```bash
cd PROG209-SwingAssignment
javac SwingAssignment.java
java SwingAssignment
```

### Run in IntelliJ IDEA or VS Code

1. Open the project folder.
2. Open `SwingAssignment.java`.
3. Click **Run** next to the `main` method.

## How It Works

| Class | Extends | Role |
|-------|---------|------|
| `SwingAssignment` | `Object` | Builds the frame, panel, label and buttons and handles events |
| `WelcomePanel` | `JPanel` | Main panel with padding and a `changeBackground` method |
| `LogoPanel` | `JComponent` | Draws the logo and supplies the window icon image |

Each button has an `ActionListener`. When a button is clicked, the listener moves to the next item in an array (messages or colours) and wraps back to the start after the last item.

## Concepts Demonstrated

- **Inheritance**: `WelcomePanel extends JPanel`, `LogoPanel extends JComponent`
- **Constructors**: each class sets itself up in its own constructor
- **Event handling**: `ActionListener` on `JButton` components
- **Layout managers**: `BorderLayout`, `BoxLayout` and `FlowLayout`
- **Custom painting**: overriding `paintComponent` with `Graphics2D`

## Author

**Mariama Seray Bah**
Student ID: 90500544
Bachelor of Information Technology, Limkokwing University of Creative Technology, Sierra Leone

**Module:** PROG209 Event Driven Programming
**Examiner:** Amandus Benjamin Coker
**Assignment:** Individual Assignment 1, Basic Interactive GUI (10%)

## References

- Oracle (n.d.) *Trail: Creating a GUI with Swing. The Java Tutorials.* Available at: https://docs.oracle.com/javase/tutorial/uiswing/ (Accessed: 21 October 2026).
- Oracle (n.d.) *How to make frames (main windows). The Java Tutorials.* Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html (Accessed: 21 October 2026).
- Oracle (n.d.) *How to use panels. The Java Tutorials.* Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html (Accessed: 21 October 2026).
- Oracle (n.d.) *How to use labels. The Java Tutorials.* Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/label.html (Accessed: 21 October 2026).
- Oracle (n.d.) *Lesson: Writing event listeners. The Java Tutorials.* Available at: https://docs.oracle.com/javase/tutorial/uiswing/events/index.html (Accessed: 21 October 2026).
- GitHub (n.d.) *About READMEs.* Available at: https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes (Accessed: 21 October 2026).
