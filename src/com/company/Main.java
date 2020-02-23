package com.company;

import com.company.calendar.Calendar_;
import com.company.calendar.MonthEnum;
import com.company.calendar.TimezoneEnum;
import com.company.calendar.Week_;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        p("CalendarsProgram:");

        //Create application
        //set time zone to pacific time
        //Application application = new Application(TimezoneEnum.PST);
        Application application = Application.getInstance(TimezoneEnum.PST);

        //display main page
        displayMainPage(application);

    }

    //static methods

    public static void displayMainPage(Application application){

        p("");
        p("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        p("$                                                   $");
        p("$     WELCOME TO THE CALENDAR PROGRAM               $");
        p("$     (Assignment 2)                                $");
        p("$     By: Roman Geluz                               $");
        p("$     INF 122: Software Design II                   $");
        p("$                                                   $");
        p("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        p("");
        p("");
        p("*****************************************************");
        p("** 1) Login      //can use \"defaultUser\" account.   ");
        p("** 2) Create a User");
        p("** 3) Display list of Users");
        p("** 4) Exit ");
        p("*****************************************************");
        p("Please enter a menu option: ");
        User user = null;

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        /*if(input == 1){
            user = displayLogin(application);
        } else if(input == 2){
            displayCreateNewUser(application);
        } else if(input == 3){
            displayListOfUsers(application);
        } else if (input == 4) {
            exit();
        }*/

        switch(input) {
            case 1:
                user = displayLogin(application);
                break;
            case 2:
                displayCreateNewUser(application);
                break;
            case 3:
                displayListOfUsers(application);
                break;
            case 4:
                exit();
            default:
                break;
        }

        //display user main menu
        //if(user!=null){
        if(!user.isNull() ) {
            application.setUsernameLoggedOn(user.getUsername());
            displayUserMenu(user, application);
        }

    }

    //TODO finish later
    //prompt user to login
    private static User displayLogin(Application application){
        clearScreen();
        p("");
        p("");
        p("*****************************************************");
        p("  Login       (enter \"exit\" to return to main menu)");
        p("*****************************************************");
        p("(can enter \"defaultUser\" to log in.)");

        Scanner sc = new Scanner(System.in);
        String input = "";
        String username = "";
        //User user = null;
        User user;

        do {
            p("Please enter Username:");
            input = sc.next();
            username = input;

            user = checkIfUserExistInUserList(application, username);


            if (username.equals("exit")) {
                //display main page
                displayMainPage(application);

            //} else if(user!=null){
            } else if(!user.isNull()) {
                //TODO
                p("");
                p("");
                p("Logging into the Calendar Program.");
                return user; //User is logged in
            } else {
                p("");
                p("");
                p("Username \""+ username + "\" does not exist.");
            }
        } while(!username.equals("exit"));

        if(username.equals("exit")){
            //display main page
            displayMainPage(application);
        }
        //return null;
        return user;
    }

    //TODO finish later
    private static void displayCreateNewUser(Application application){
        clearScreen();
        p("");
        p("");
        p("*****************************************************");
        p("  Create New User   (enter \"exit\" to return to main menu)");
        p("*****************************************************");

        //Username fields
        String username = "";
        String firstname = "";
        String lastname = "";

        Scanner sc = new Scanner(System.in);

        boolean reprompt = false;
        do{
            p("");
            p("");
            p("Enter a new username:");
            username = sc.next();

            if(username.equals("exit")) {
                //display main page
                displayMainPage(application);
            }

            p("Enter a firstname:");
            firstname = sc.next();

            p("Enter a lastname:");
            lastname = sc.next();

            String answer = "";
            p("Do you wish to create this user? (Y/N)");
            p("     username: " + username);
            p("     firstname: " + firstname);
            p("     lastname: " + lastname);
            p("");
            answer = sc.next();
            if(answer.toLowerCase().equals("y")){
                p("");
                p("creating new user " + "\"" + username + "\"" + ".");
                User newuser = new User(username, firstname, lastname);
                application.addNewUser(newuser);
                p("");
                p("");
                p("do you wish to create another user? (Y/N)");
                answer = sc.next();
                if(answer.toLowerCase().equals("y")){
                    reprompt = true;
                }
                else{
                    reprompt = false;
                }

            } else {
                p("");
                p("");
                p("do you wish to create new user? (Y/N)");
                answer = sc.next();
                if(answer.toLowerCase().equals("y")){
                    reprompt = true;
                }
                else{
                    p("");
                    p("returning to main menu.");
                    reprompt = false;
                }
            }
        } while (reprompt);

        //display main page
        clearScreen();
        displayMainPage(application);

    }

    private static void displayListOfUsers(Application application){
        clearScreen();
        p("");
        p("");
        p("*****************************************************");
        p("  List of all users: ");
        p("*****************************************************");
        int index = 0;

        List<User> userList = application.getUserList();

        if(userList.size()==0){
            p("There are no users. Need to create new users.");
        } else {
            for(User user :  userList){
                p(index + ") " + user.getUsername());
                index++;
            }
        }


        p("*****************************************************");

        //display main page
        clearScreen();
        displayMainPage(application);
    }

    //TODO finish later
    private static void displayUserMenu(User user, Application application){
        p("*****************************************************");
        p("");
        p("         USER MENU:                                  ");
        p("         User: " + user.getUsername());
        p("         " + getDateAndTime());
        p("");
        p("*****************************************************");
        p("");
        p("");
        p("*****************************************************");
        p("** 1) Open a Calendar");
        p("** 2) Display all Calendars");
        p("** 3) Add a new Calendar");
        p("** 4) Logout of Calendar Program");
        p("*****************************************************");
        p("Please enter a menu option: ");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch(input) {
            case 1:
                //Todo
                openCalendar(user, application);
            case 2:
                //Todo
                displayAllCalendars(user, application);
            case 3:
                //todo
                addNewCalendar(user, application);

            case 4:
                //todo
                logOutUser(application);
            default:

        }
    }

    private static void openCalendar(User user, Application application) {
        p("*****************************************************");
        p("");
        p("         Choose A Calendar to View                   ");
        p("         User: " + user.getUsername());
        p("         " + getDateAndTime());
        p("");
        p("*****************************************************");
        p("");
        p("");
        p("*****************************************************");
        showAllCalenders(user);
        p("*****************************************************");
        p("Enter the name of the calendar you wish to view:");
        Scanner sc = new Scanner(System.in);
        String calendarName = sc.nextLine();

        boolean doesExist = false;
        List<Calendar_> calendars = user.getCalendarsOwned();
        Calendar_ calendarToOpen = null;
        for(Calendar_ calendar : calendars){
            if(calendar.getCalendarName().equals(calendarName)){
                calendarToOpen = calendar;
                doesExist=true;
            }
        }

        //display calendar menu
        if(doesExist){
            calendarMenu(user, calendarToOpen, application);
        } else {
            p("calendar name " + calendarName + " does not exist.");
            openCalendar(user, application); //reprompt the user open calendar menu
        }



    }

    private static void displayAllCalendars(User user, Application application){

        clearScreen();
        p("");
        p("");
        p("*****************************************************");
        p("    List of Calendars owned by " + user.getUsername() + ": ");
        p("*****************************************************");
        showAllCalenders(user);
        p("*****************************************************");

        //display User main menu
        clearScreen();
        displayUserMenu(user, application);

    }

    private static void showAllCalenders(User user) {
        int index = 0;
        List<Calendar_> calendars = user.getCalendarsOwned();

        if( calendars == null || calendars.size()==0) {
            p("There are no calenders owned by " + user.getUsername() + ".");
            p("Need to add new calendar(s).");
        } else {
            for(Calendar_ calendar : calendars){
                p("     " + index + ") " + calendar.getCalendarName() );
                index++;
            }
        }
    }

    private static void addNewCalendar(User user, Application application) {
        clearScreen();
        p("");
        p("");
        p("*****************************************************");
        p("    Add a new Calendar for " + user.getUsername() + ": ");
        p("*****************************************************");
        p("Enter the name of the new calendar:");

        Scanner sc = new Scanner(System.in);
        String calendarName = sc.nextLine();

        p("Enter a description for the new calendar: ");
        String description = sc.nextLine();

        //Create calendar
        user.createCalendar(calendarName, description);


        //display User main menu
        clearScreen();
        displayUserMenu(user, application);
    }

    //Calendar page
    private static void calendarMenu(User user, Calendar_ calendarToOpen, Application application){
        p("*****************************************************");
        p("");
        p("         CALENDAR MENU                ");
        p("         Calendar: " + calendarToOpen.getCalendarName());
        p("         User: " + user.getUsername());
        p("         " + getDateAndTime());
        p("");
        p("*****************************************************");
        p("** 1) Display Yearly View");
        p("** 2) Display Monthly View");
        p("** 3) Display Weekly View");
        p("** 4) Display Daily View");
        p("** 5) Exit CALENDAR MENU");
        p("*****************************************************");
        p("Please enter a menu option: ");


        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch(input){
            case 1:
                //todo
                displayYearlyView(calendarToOpen);
                break;
            case 2:
                //todo
                displayMonthView(calendarToOpen);
                break;
            case 3:
                //todo
                displayWeeklyView(calendarToOpen);
                break;
            case 4:
                //todo
                displayDailyView(calendarToOpen);
                break;
            case 5:
                //todo
                p("Feature not finished");
                clearScreen();
                displayUserMenu(user, application);
                break;
            default:
                break;



        }

        //
        p("");
        p("Return to Calendar Menu? (Y/N)");
        String returnToMenu = sc.next();
        if(returnToMenu.toLowerCase().equals("y")) {
            calendarMenu(user, calendarToOpen, application);
        } else if(returnToMenu.toLowerCase().equals("n")){

        }


    }

    //methods for Calender Menu
    private static void displayYearlyView(Calendar_ calendarToOpen){
        //calendarToOpen.getYear().displayYearView();
        calendarToOpen.getYear().displayView();
    }

    private static void displayMonthView(Calendar_ calendarToOpen){
        p("*****************************************************");
        p("Enter the month for calendar");
        p("(January, February, March, April, June, July, etc.)");
        p("*****************************************************");
        Scanner sc = new Scanner(System.in);
        String month = sc.next();

        boolean foundMonth = false;
        for(MonthEnum monthEnum : MonthEnum.values()){
            if(month.equals(monthEnum.name())){
                foundMonth= true;
            }
        }
        if(foundMonth) {
            /*calendarToOpen
                    .getYear()
                    .getMonth(month)
                    .displayMonthView();*/
            calendarToOpen
                    .getYear()
                    .getMonth(month)
                    .displayView();
        } else {
            p("The month " + month + " does not exist");
            displayMonthView(calendarToOpen);
        }



    }
    private static void displayWeeklyView(Calendar_ calendarToOpen){

        p("Feature not finished");

        p("*****************************************************");
        p("Enter the month for calendar");
        p("(January, February, March, April, June, July, etc.)");
        p("*****************************************************");
        Scanner sc = new Scanner(System.in);
        String month = sc.next();
        //display month
        boolean foundMonth = false;
        for(MonthEnum monthEnum : MonthEnum.values()){
            if(month.equals(monthEnum.name())){
                foundMonth= true;
            }
        }
        if(foundMonth) {
            //calendarToOpen.getYear().getMonth(month).displayMonthView();
            calendarToOpen.getYear().getMonth(month).displayView();
        } else {
            p("The month " + month + " does not exist");
            displayMonthView(calendarToOpen);
        }


        p("*****************************************************");
        p("Enter the week of the month");
        p("1,2,3,4,etc.)");
        int weekNum = sc.nextInt();
        Week_ week_ = calendarToOpen
                            .getYear()
                            .getMonth(month)
                            .getWeek(weekNum);

        if(week_==null){
            p("week number " + weekNum + " does not exist");
        }

        //week_.displayWeekView();
        week_.displayView();


    }
    private static void displayDailyView(Calendar_ calendarToOpen){
        p("Feature not finished");
    }

    private static void logOutUser(Application application){
        //TODO
        displayMainPage(application);
    }




    //helper methods

    private static User checkIfUserExistInUserList(Application application, String username){
        //check if username exist
        List<User> userList = application.getUserList();
        for(User user : userList) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        //return null;
        return new NullUser("", "", "");
    }

    private static void exit(){
        p("Exiting Calendar Application.");
        System.exit(0);
    }


    //wrapper for println
    public static void p(String message){
        System.out.println(message);
    }

    //clear console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //get date and time
    //https://mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
    public static String getDateAndTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return dateFormat.format(date);
    }

}
