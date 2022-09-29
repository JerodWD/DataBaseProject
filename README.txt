*******************************************************************************
DatabaseProject

I made this project in my Database class in college. I used JavaFX and MongoDB;
this programs' database holds airport flight information and allows the user to
modify this with a UI.
*******************************************************************************
Files
.idea
	Brainstorming file (ignore)

Final Project
	This file has everthing necessary to run the project

Final Project -> Datbase Diagram.drawio.png
	This is a file that has or UML for the program

Final Project -> FlightDatabase.sql
	This file is our SQL for our database (used in MongoDB)

Final Project -> Runner.java
	This is our backend that we connect to the database and use JavaFX to create
	a GUI.

Final Project -> insertNew
	This is just a class that belongs in the 'Runner.java' (should be on line 520)

*******************************************************************************
To Run this program, you have ot set up a local host with MongoDB. Leave both
as 'root' and 'root' for the names (this is how the connection string is set up
in the Runner.java. Now insert the SQL code fom FlightDatabase.sql and run. 
Start up the Runner.java (with the local host MongoDB running). 