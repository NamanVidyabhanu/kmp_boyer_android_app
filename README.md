# Problem Statement
Android application for simulation of kmp and boyer moore pattern matching algorithms

Detailed description:
This project contains the android application to display the simulation of kmp and boyer moore algorithms with the help of step-by-step animations, which would work successfully in all android versions (from lollipop to oreo).

# Key Functionalities
1. Dynamic Pattern matching based on users choice of algorithm and pattern.
2. Animations to show the step-by-step simulation of 'how the algorithm works'.
3. Dynamic counter that displays the number of times the pattern has been matched.
4. Runtime termination and refresh features provided.

# Technology Stack
The logical component has been coded in java and the GUI component has been coded in xml. Android Studio 3.2 has been used to develop the project.

# MainActivity.java
This file contains the java source code for kmp and boyer moore algorithms, which are run in the background thread using the Asynctask class in java.

# GUI.xml
This file contains xml code for the graphical components like textviews , buttons etc.

# Animations
The two features used for animation are:
1. Spannable class in java (to update the GUI dynamically based on match or mismatch)
2. Thread.sleep() method in java (to slow down the updation process so that the changes are visible to user in the form of animation)
