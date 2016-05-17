/**************************************************************************
 * Public Class Menu
 * Serves as the user interface and directs inputs to be constructed
 * as ISchedule objects. 
 * Also puts constructed ISchedule objects into the ScheduleList array 
 **************************************************************************/
import java.util.*;

public class Menu
{
	
   //Public mainMenu
   //IMPORT: None
   //EXPORT: None
   //displays the main menu for the program
   public static void mainMenu()
	{
		int selectAction;
      
      System.out.println("---------------------------");
		System.out.println("Uni Event Scheduler - Select an option");
		System.out.println("1. Add event");
		System.out.println("2. Display events");
		System.out.println("3. Print alert");
		System.out.println("4. Exit");
      System.out.println("---------------------------");
	
      selectAction = selectInput(1, 4, "menuTypeMain");
		
      switch(selectAction)
      {
         case 1:
            addEventMenu();
            break;
         case 2:
            ScheduleList.displayEvents();
            mainMenu();
            break;
         case 3:
            ScheduleList.printAlert();
            mainMenu();
            break;
         case 4:
            break;
      }	
   
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
		
      selectAction = selectInput(1, 3, "menuTypeAdd");
		
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
      boolean errorFlag = false;
      LectureEvent event;
   	Scanner sc = new Scanner(System.in);
      
		System.out.println("Enter the Unit");
		inUnit = sc.nextLine();
		System.out.println("Enter the lecture hall");
		inLectureHall = sc.nextLine();
		System.out.println("Enter the time");
      System.out.println("Eg: 16/5/2016 5:30PM entered as: " +
                         "16 5 2016 17 30");
      //check to see if vaild date is given
      //invalid input causes an exception and returns user to the
      //add event menu
		try
		{
			inDay = sc.nextInt();
			inMonth = sc.nextInt();
			inYear = sc.nextInt();
			inHour =  sc.nextInt();
			inMinute = sc.nextInt();
			event = new LectureEvent(inUnit, inLectureHall, inDay, inMonth, 
                                  inYear, inHour,inMinute);
         updateArray((ISchedule)event);
		}
		catch(IllegalArgumentException e)
		{
         errorFlag = true;
         System.out.println("---------------------------");
			System.out.println("Error: Invalid input");
         System.out.println("Date cannot be set in the past");
         addEventMenu();
		}
      catch(InputMismatchException e)
      {
         errorFlag = true;
         System.out.println("---------------------------");
			System.out.println("Error: Invalid input");
         System.out.println("Invalid character detected");
         addEventMenu();
      }
      
      //return to the add event menu if event is successfully added
      //errorFlag ensures this code isnt exectuted if an exception was caught
      if(!errorFlag)
      {
         System.out.println("---------------------------");
         System.out.println("Lecture event successfully added");
         addEventMenu();
      }
	}
	
   //private addTutorial
   //IMPORT: None
   //EXPORT: None
   //sub module for getting input from the user to add a tutorial event
	private static void addTutorial()
	{
		
		String inUnit;
		int inClassroom = 0, inDay = 0, inMonth = 0, inYear = 0; 
		int inHour = 0, inMinute = 0;
      boolean errorFlag = false;
		TutorialEvent event;
      Scanner sc = new Scanner(System.in);
      
		System.out.println("Enter the Unit");
		inUnit = sc.nextLine();
		
	   //check to see if vaild date and classroom is given
      //invalid input causes an exception and returns user to the
      //add event menu
		try
		{
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
         event = new TutorialEvent(inUnit, inClassroom, inDay,
                                   inMonth, inYear, inHour, inMinute);
         updateArray((ISchedule)event);
		}
		catch(IllegalArgumentException e)
		{
         errorFlag = true;
         System.out.println("---------------------------");
			System.out.println("Error: Invalid input");
         System.out.println("Classroom must be between 1 and 400 (inclusive)");
         System.out.println("Date cannot be set in the past");
         addEventMenu();
		}
      catch(InputMismatchException e)
      {
         errorFlag = true;
         System.out.println("---------------------------");
			System.out.println("Error: Invalid input");
         System.out.println("Invalid character detected");
         addEventMenu();
      }

      //return to the add event menu if event is successfully added
      //errorFlag ensures this code isnt exectuted if an exception was caught
      if(!errorFlag)
      {
         System.out.println("---------------------------");
         System.out.println("Tutorial event successfully added");
         addEventMenu();
      }
      
	}
   
   //Private selectInput
   //IMPORT: lowerBound, upperBound, menuType
   //EXPORT: selectAction
   //Catches exceptions for when illegal selections are made
   //User is returned to their previous menu if an exception is caught
   private static int selectInput(int lowerBound, int upperBound, 
											 String menuType)
   {
      int selectAction = 0;
      Scanner sc = new Scanner(System.in);
      
      try
      {
         selectAction = sc.nextInt();
         if(selectAction < lowerBound || selectAction > upperBound)
         {
            System.out.println("Error: Invaild selection");
				if(menuType.equals("menuTypeMain"))
					mainMenu();
				else if(menuType.equals("menuTypeAdd"))
					addEventMenu();
         }
      }
      catch(InputMismatchException e)
      {
         System.out.println("Error: Invaild selection");
         if(menuType.equals("menuTypeMain"))
					mainMenu();
				else if(menuType.equals("menuTypeAdd"))
					addEventMenu();
      }
      return selectAction;
   }
	
   //Private updateArray
   //IMPORT: event (ISchedule object)
   //EXPORT: None
   //Attempts to add events to ScheduleList array
   //If no space is available, user is returned to main menu
   private static void updateArray(ISchedule event)
   {
      try
      {
         ScheduleList.addEvent(event);
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
         System.out.println("---------------------------");
         System.out.println("Error: Already 10 items in the list");
         mainMenu();
      }
   }
   
}

