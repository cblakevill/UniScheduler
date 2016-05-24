/**************************************************************************
 * Public Class Menu
 * Serves as the user interface where the user can add an event 
 * or view upcoming events/alerts
 **************************************************************************/
import java.util.*;

public class Menu
{

   //Public mainMenu
   //IMPORT: None
   //EXPORT: exitMenu (boolean)
   //displays the main menu for the program
   public static boolean mainMenu()
   {
       int selectAction;
       boolean exitMenu = false;
      
       System.out.println("---------------------------");
       System.out.println("Uni Event Scheduler - Select an option");
       System.out.println("1. Add event");
       System.out.println("2. Display events");
       System.out.println("3. Print alert");
       System.out.println("4. Exit");
       System.out.println("---------------------------");
   
       selectAction = selectInput(1, 4);

      switch(selectAction)
      {
         case 1:
            addEventMenu();
            break;
         case 2:
            ScheduleList.displayEvents();
            break;
         case 3:
            ScheduleList.printAlert();
            break;
         case 4:
            exitMenu = true;
            break;
      }
      return exitMenu;
   }

   //private addEventMenu
   //IMPORT: None
   //EXPORT: None
   //displays the sub menu for adding events to the schedule
   private static void addEventMenu()
   {
       int selectAction;
      
       System.out.println("---------------------------");
       System.out.println("Select an event type to add");
       System.out.println("1. Lecture Event");
       System.out.println("2. Tutorial Event");
       System.out.println("3. Return to main menu");
       System.out.println("---------------------------");

       selectAction = selectInput(1, 3);

      switch(selectAction)
      {
         case 1:
            System.out.println("---------------------------");
            System.out.println("Adding a lecture event");
            System.out.println("---------------------------");
            addLecture();
            break;
         case 2:
            System.out.println("---------------------------");
            System.out.println("Adding a tutorial event");
            System.out.println("---------------------------");
            addTutorial();
            break;
         case 3:
            mainMenu();
            break;
       }
   }
 
   //private addLecture
   //IMPORT: None
   //EXPORT: None
   //sub module for getting input from the user to add a lecture event
   private static void addLecture()
   {
      String inUnit, inLectureHall;
      int inDay, inMonth, inYear, inHour, inMinute;
      LectureEvent event = null;
      boolean valid = false;
      Scanner sc = new Scanner(System.in);
      
      do
      {
         try
         { 
            System.out.println("Enter the Unit");
            inUnit = sc.nextLine();
            System.out.println("Enter the lecture hall");
            inLectureHall = sc.nextLine();
            System.out.println("Enter the time");
            System.out.println("Eg: 16/5/2016 5:30PM entered as: " +
                                "16 5 2016 17 30");
            inDay = sc.nextInt();
            inMonth = sc.nextInt();
            inYear = sc.nextInt();
            inHour =  sc.nextInt();
            inMinute = sc.nextInt();
            sc.nextLine();  //prevents scanner from reading previous line 
                            //into inUnit if exception is caught

            event = new LectureEvent(inUnit, inLectureHall, inDay, inMonth, 
                                     inYear, inHour,inMinute);
            valid = true;
         }
         catch(IllegalArgumentException e)
         {
            System.out.println("---------------------------");
            System.out.println("Error: Invalid input");
            System.out.println(e.getMessage());
            System.out.println("---------------------------");
         }
      }while(!valid);
                               
      ScheduleList.addEvent((ISchedule)event);
      System.out.println("---------------------------");
      System.out.println("Lecture event successfully added");
      addEventMenu();
   
   }

   //private addTutorial
   //IMPORT: None
   //EXPORT: None
   //sub module for getting input from the user to add a tutorial event
   private static void addTutorial()
   {

      String inUnit;
      int inClassroom, inDay, inMonth, inYear, inHour, inMinute;
      TutorialEvent event = null;
      boolean valid = false;
      Scanner sc = new Scanner(System.in);
      
      do
      {
         try
         {
            System.out.println("Enter the Unit");
            inUnit = sc.nextLine();
            System.out.println("Enter the classroom");
            inClassroom = sc.nextInt();
            System.out.println("Enter the time");
            System.out.println("Eg: 16/5/2016 5:30PM entered as: " +
                               "16 5 2016 17 30");
            inDay = sc.nextInt();
            inMonth = sc.nextInt();
            inYear = sc.nextInt();
            inHour =  sc.nextInt();
            inMinute = sc.nextInt();
            sc.nextLine();

            event = new TutorialEvent(inUnit, inClassroom, inDay,
                                      inMonth, inYear, inHour, inMinute);
            valid = true;
         }
         catch(IllegalArgumentException e)
         {
            System.out.println("---------------------------");
            System.out.println("Error: Invalid input");
            System.out.println(e.getMessage());
            System.out.println("---------------------------");
         }
      }while(!valid);
      
      ScheduleList.addEvent((ISchedule)event);
      System.out.println("---------------------------");
      System.out.println("Tutorial event successfully added");
      addEventMenu();
   }
   
   //Private selectInput
   //IMPORT: lowerBound, upperBound
   //EXPORT: selectAction
   //Checks to see if input is within a specified range
   private static int selectInput(int lowerBound, int upperBound)
   {
      int selectAction = 0;
      Scanner sc = new Scanner(System.in);

      selectAction = sc.nextInt();
      while(selectAction < lowerBound || selectAction > upperBound)
      {
         System.out.println("---------------------------");
         System.out.println("Error: Invaild selection");
         System.out.println("Valid selections between " + lowerBound + 
                            " and " + upperBound);
         System.out.println("---------------------------");
         selectAction = sc.nextInt();
      }
      return selectAction;
   }
}
