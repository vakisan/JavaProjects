# Print Initials Program README - 31 May 2020

This readme was generated using Bash Command Line and modified using NANO editor in Command Line

## Program Structure

This program has a Name class which stores the name of the user into two instance fields.
The name class implements two interfaces which ensure that the class of Name contains methods that get and set First and Last Names.

The Initial class is a child of the Name class, while strictly speaking Initials are not names in real world terms, it made sense to reuse the superclasse's constructor when instantiating Initial. if we did not have a name we couldn't compute the initials. This program could have been much shorter in that I could have used procedural programming to keep code more sequential in nature. however, I wanted to practice Object Oriented Style to Achieve a similar result to make code and perhaps reuse code for future projects.

## Functionality

this program can be instantiated with either the Name object in Main.java or Initials Objects. the former will only ask for the name, while the latter will compute the initials also.
To handle the input and output exceptions of the program, i initialy added a custom RuntimeError class to catch if user confirmed by replying only yes or no. This was sucessful but it made code less readable, i removed this but the file is still included in this folder. It made more sense to prevent the error from occuring by simply enforcing user to input yes or no repeatedly while the input was not either of these two options.

// END  

