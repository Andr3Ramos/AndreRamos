# Java and OOP II

## The Java Lamp

### **Goal**

Create a Java program that follows the OOP paradigm and a set of clearly defined client requirements, by applying inheritance and polymorphism in order to reuse code efficiently.

### By doing this assignment you will

- Become familiar with using Enums in your projects
- Create Java classes using composition
- Use the concept of inheritance and its mechanisms to improve the reusability of your code
- Utilize the `super` keyword to refer to superclasses
- Apply the concept of polymorphism
- Get a notion of how the principles of OOP help simplify code maintenance

### Instructions

As a software developer, you need to comply with client requirements when creating a piece of software.

Your client is a fan of the “Arabian Nights” books who asked you to create a software version of a Magic Lamp. Here are the requirements they gave you:

*Magic Lamp*

- Releases a new genie every time it is rubbed
- When enchanted, or instantiated, the maximum number of genies is set
- Genies can be Friendly (even) or Grumpy (odd)
- When the number of genies is exhausted, the lamp releases a demon
- Has the ability to recharge itself by recycling a demon or a Grumpy Genie
- Has a maximum amount of times it can be recharged
- Your program needs to be able produce more than one lamp and compare the lamps
- The lamps may be compared according to their capacity, the number of remaining genies, and the number of times they have been recharged
- Important: the Magic Lamp should not have any property references to any Genie or its subclasses!

*WishType*

- WishType must be an Enum
- There’s a possibility of being granted one of the following wishes: WEALTH, FAME, LUCK, POOR, SICKNESS, BADLUCK
- Each of these WishTypes needs to have an associated description that will be printed when the wish is granted

*FriendlyGenie*

- When released from the lamp, or instantiated, the maximum number of wishes is set
- It can only grant one wish at a time
- It can only grant good wishes
- It can grant a wish if the maximum has not been reached

*GrumpyGenie*

- When released from the lamp, or instantiated, the maximum number of wishes is set
- It can only grant one wish at a time
- Grants *only one* wish in total, even if the maximum has not been reached
- It can recharge a magic lamp if recycled but has a 50% chance to destroy the lamp
- It can grant good or bad wishes, and the probability of either should be 50%
- It will not grant any more wishes after being recycled
- It can only be recycled once

*Demon*

- When released from the lamp, or instantiated, the maximum number of wishes is set
- It can only grant one wish at a time
- Grants *all* wishes, even if the maximum has already been reached
- It can recharge the magic lamp if recycled
- It will not grant any more wishes after being recycled
- It only grants bad wishes
- It can only be recycled once

### Submitting your assignment

NOTE: If you need instructions for forking a repository and setting up remotes, please consult the README.md file on [GitHub](https://github.com/the-studio-room-to-learn-it/).

1. Pull the latest changes from upstream into your local repository
    
    Before you start making any changes to your local files, it’s good practice to first synchronise your local repository with the project repository.
    
    Use `git pull upstream main` to pull any changes from the main branch of the upstream into your local repository:
    
    ```bash
    git pull upstream main
    ```
    
2. Create a new branch
    
    Create a new branch where you’ll be working and then immediately switch to it. You should use `git checkout -b yourname-week-05-assignment`, where `yourname` is replaced by your first and last name. For instance, if your name is IO and you are working on this week’s assignment, you would write:
    
    ```bash
    git checkout -b io-week-05-assignment
    ```
    
3. Work on your assignment and make changes
    
    Inside the local repository on your machine, move to `assignments/week-05`, and create a new directory named with your first and last name:
    
    ```bash
    cd assignments/week-05
    mkdir gustavo-carvalho
    ```
    
4. To complete the assignment, create a new IntelliJ project and work from scratch.
5. Commit your changes
    
    After you make a set of changes, stage them:
    
    ```bash
    git add .
    ```
    
    Write a message describing your changes to commit them:
    
    ```bash
     git commit -m "message describing the changes"
    ```
    
6. Push your changes to your fork
    
    When you are done making all of your changes, upload these changes to your fork:
    
    ```bash
    git push origin <branch_name>
    ```
    
    For example:
    
    ```bash
    git push origin io-week-05-assignment
    ```
    
7. Begin the pull request
    
    Return to your fork on GitHub, and refresh the page. In the highlighted area on top of it, click the green ”Compare & pull request” button to begin the pull request.
    
8. Create the pull request
    
    Write a descriptive title for your PR, and then include more relevant details in the body. When you’re done, submit the pull request.
