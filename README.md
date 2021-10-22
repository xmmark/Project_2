# CS321 Project 2
This is the repository of CS321 Software Engineering Project 2: Pair-programming on GitHub (Assembler in Java). The goal of this project is to practice using Git/GitHub to develop software in a team environment, expecially pair programming. The software we implemented is an assembler that converts an infix mathematical expression into assembly code. More details about the project can be found in [CS321 Project 2 Description](https://docs.google.com/document/d/1pngkLQGdk40lHuySPPmggnYO-CiJHQOOXoAOj9tVAWY/edit#heading=h.9s61wjb7uuw7).

## Description
Before starting the actual coding, we spent significant amount of time reviewing Java, learning Git and getting used to using GitHub Projects when commiting. Below are the three increments of the coding portion.

### Increment one: Stack using Linked List
A generic linked list stack class is created in *LinkedStack.java*. Its functionalites are tested with the main function of the class.

### Increment two: Infix to Postfix
A class Postfix is created in *Postfix.java*. Postfix uses linked list stacks to convert infix expressions from a file to postfix expressions and write them into a file/display postfix expressions on terminal. Command line interface follows the format: java postfix input [output], where output is optional. The class is tested with data3-1.txt.

### Increment three: Infix/Postfix to Assembly
A class assembler is created in *assembler.java*. assembler incorporates both Postfix and LinkedStack to convert infix expressions in a file to assembly language in specified format. evaluate() produces the assembly and temporary memory locations. assembly() uses evaluate() to read infix expressions input using Postfix and store assembly into an ArrayList as. writeFile() writes infix expressions, postfix expressions, and assembly in one file. Command line interface follows the same format as Increment two. The file is tested with data3-2-1.txt and data3-1.txt.


## Extension
### 1. Create a UML class diagram before writing the code


### 2. Manage the team using Scrum (GitHub projects)
We used GitHub Projects from the beginning of the project to track what we want to do, what we are doing and what we have done. When we were creating a file, we added the event though "Issues" in the menu bar, assigned the mission to a person or both of us, categorize the event (enhancement/documentation/bug), and initialized the work in Projects with a card in the "To do" column. When we finished the work and commited with specific commit messages (closes #), GitHub Projects automatically moved the card to where it should be, "In progress" or "Done". Details can be found in "Projects" session.


## Author and Acknowledgement
Team 9: Xavier Markowitz, Di Luo.
Thanks to Prof. Al Madi for his interpretation on assembler language.
