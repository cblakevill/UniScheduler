/**************************************************************************
 * Public Class ScheduleList
 * Stores the events created by the user in a array of type ISchedule
 * A Maximum of 10 events can be stored before an exception is thrown.
 * Also prints all the events or alerts in the array.  
 **************************************************************************/
public class ScheduleList
{
   private static int eventCounter = -1;
   private static ISchedule eventArray[] = new ISchedule[10];

   //Public addEvent
   //IMPORT:
   //EXPORT:
   //When an ISchedule object is parsed to this submodule, it is added to 
   //the eventArray if there is available space.
   public static void addEvent(ISchedule inEventItem)
   {
      eventCounter++;
      eventArray[eventCounter] = inEventItem;
   }

   //Public displayEvents
   //IMPORT: None
   //EXPORT: None
   //Prints all the upcoming events in the array
   public static void displayEvents()
   {
      if(eventCounter == -1)
      {
         System.out.println("---------------------------");
         System.out.println("No events to display");
      }
      else
      {
         System.out.println("---------------------------");
         System.out.println("Your currently scheduled events:");
         System.out.println("---------------------------");
         for(int i = 0; i <= eventCounter; i++)
         {
            System.out.println(eventArray[i].toString());
         }
      }
   }
   
   //Public printAlert
   //IMPORT: None
   //EXPORT: None
   //Prints the time remaining for each event to commence
   public static void printAlert()
   {
      if(eventCounter == -1)
      {
         System.out.println("---------------------------");
         System.out.println("No alerts to display");
      }
      else
      {
         System.out.println("---------------------------");
         System.out.println("Your upcoming events:");
         System.out.println("---------------------------");
         for(int i = 0; i <= eventCounter; i++)
         {
            System.out.println(eventArray[i].printAlert());
         }
      }
   }
}


