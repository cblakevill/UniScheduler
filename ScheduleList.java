/**************************************************************************
 * Public Class ScheduleList
 * Stores the events created by the user in a array of type ISchedule
 * A Maximum of 10 events can be stored before an exception is thrown.
 * Also prints all the events or alerts in the array.
 **************************************************************************/
public class ScheduleList
{
	//eventCounter initialised outside of addEVent otherwise it will
	//reset to zero each time addEvent is called
	private static int eventCounter = 0;
	private static ISchedule eventArray[] = new ISchedule[10];
	
	//Public addEvent
	//IMPORT:
	//EXPORT:
	//When an ISchedule object is parsed to this submodule, it is added to 
	//the eventArray if there is available space.
	public static void addEvent(ISchedule inEventItem)
	{
		if(eventCounter < 10)
		{
			eventArray[eventCounter] = inEventItem;
			eventCounter++;
		}
		else 
			throw new ArrayIndexOutOfBoundsException("Error: too many items "+  
												     "in event list");
	}
	
	//Public displayEvents
	//IMPORT: None
	//EXPORT: None
	//Prints all the events upcoming events in the array
	public static void displayEvents()
	{
		if(eventArray[0] == null)
		{
			System.out.println("---------------------------");
			System.out.println("No events to display");
		}
		else
		{
			System.out.println("---------------------------");
            System.out.println("Your currently scheduled events:");
            System.out.println("---------------------------");
			for(int i = 0; i < 10; i++)
			{
				if(eventArray[i] instanceof TutorialEvent)
				{
					eventArray[i] = (TutorialEvent)eventArray[i];
					System.out.println(eventArray[i].toString());	
				}
				else if(eventArray[i] instanceof LectureEvent)
				{
					eventArray[i] = (LectureEvent)eventArray[i];
					System.out.println(eventArray[i].toString());
					
				}
			}
		}		
	}
	
	//Public printAlert
	//IMPORT: None
	//EXPORT: None
	//Prints the time remaining for each event to commence
	public static void printAlert()
	{
		if(eventArray[0] == null)
		{
			System.out.println("---------------------------");
			System.out.println("No alerts to display");
		}
		else
		{
			System.out.println("---------------------------");
            System.out.println("Your upcoming events:");
            System.out.println("---------------------------");
			for(int i = 0; i < 10; i++)
			{
				if(eventArray[i] instanceof TutorialEvent)
				{
					eventArray[i] = (TutorialEvent)eventArray[i];
					eventArray[i].printAlert();	
				}
				else if(eventArray[i] instanceof LectureEvent)
				{
					eventArray[i] = (LectureEvent)eventArray[i];
					eventArray[i].printAlert();
				
				}
			}
		}
	}
	
}	

