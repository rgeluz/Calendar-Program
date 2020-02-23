# Calendar-Program
Assignment for "INF 122 Software Design: Structure and Implementation". The assignment demonstrates the ability to implement the object-oriented design from a previously created UML Class Diagram, all written in Java and with built-in Java Libraries. Also to identify areas for improvement in the code base and to apply two common design patterns and two refactoring methods to the project.

  *Design Patterns Implemented:
    1. Singleton Pattern
    2. Template Method Pattern
  *Refactoring Methods Implemented:
    1. Introduce Null Object
    2. Encapsulate Collection


#To run CalendarProgram
Open project in IDE.
Build a Jar file
Open a command line terminal
  run the command "java -jar [path to jar file] "


  In main menu, enter 1 for login

  enter "defaultUser" for username

  enter 1 for "Open a Calendar"

  enter "defaultCal" to view

  enter 1 for "display yearly view"
  enter 2 for "display monthly view"
  enter 3 for "display weekly view"
  enter 4 for "display daily view"

  choose 3 for "display weekly view"

  enter "January" to see the weekly view for the month of January

  enter "1" for the first week of January (there are pre-populated events in that week)

  //didn't finish fixing the formatting. But the events belong to Wednesday.  



//////////////////////////////////////////////////////
From Assignment Prompt:

Below are the detailed requirements for Calendars. The program will be developed in Java.
Calendars Description and Requirements
1.	Calendars must support the Gregorian calendar.
2.	Each calendar in an app can have different sets of events that the user can set hours and minutes for, including starting and ending times.
3.	Calendar events can be made repeatable each week up until an end date. For example, a Calendar event starting Jan. 1, 2020 can be set to repeat every week until Mar. 17, 2020.
4.	Users can add, remove, and update Calendar events.
5.	Calendars supports multiple users each of which may have multiple calendars.
6.	Users can add, remove, and update individual calendars.
7.	Calendars supports multiple time zones. Changing time zones for the app automatically updates the time for events in a user's calendar.
8.	Calendars provides users with a choice of a dark theme or light theme.
9.	Calendars has a screen that allows the user to configure the app for a particular time zone or change the app's theme.
10.	Calendars allows users to create private and public calendars that can be shared with other users. Users can toggle between making a calendar private or public. Public calendars are available to all users of the Calendars app. Private calendars are only viewable by the user that owns the calendar.
11.	A user can share a calendar event with another user. Shared calendar events from a private calendar can only be viewed by users to which the event has been shared.
12.	Users can filter Calendars they have created to allow viewing a subset of events they are interested in.
13.	Calendars visualizes your events for a single day, an entire week, an entire month, or for the entire year.
14.	Calendars must support countdown timers that can be shown on a separate screen. For example, if I create a deadline for a research paper submission due for my class, I can see that countdown timer along with other timers in my app.
15.	A user should be able to search for calendar events that contain a particular string or substring. For example, if a user searches for "birth", events entitled "Rebirth meeting" and "Birthday party" should be returned to the user.
16.	Selecting a particular event should show details of an event, including the time it starts and ends, the title of the event, and any users the event is shared with.  
