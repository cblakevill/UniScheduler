/**************************************************************************
 * Public Abstract Class UniEvents (Parent Class)
 * Child Classes: Tutorial Event, Lecture Event
 * Serves as a foundation for Tutorial and Lecture events to be constructed
 **************************************************************************/
import java.util.*;

public abstract class UniEvents
{
   //Class fields
	private String unit;
	private GregorianCalendar dateTimeEvent = new GregorianCalendar();
	
   //Default Constructor
   //IMPORT: None
	public UniEvents()
	{
		unit = "Unspecified unit";
		dateTimeEvent.getInstance();
	}
   
   //Alternate Constructor
   //IMPORT: inUnit, inMinute, inHour, inDay, inMonth, inYear
   public UniEvents(String inUnit, int inMinute, int inHour, int inDay, 
                         int inMonth, int inYear)
   {
      unit = inUnit;
      inMonth = inMonth - 1;  //decrement by 1 as months as months starts from 0  
      if(validateTime(inMinute, inHour, inDay, inMonth, inYear)) 
      {
         dateTimeEvent.set(inYear, inMonth, inDay, inHour, inMinute);
      }
      else
         throw new IllegalArgumentException("Error: invalid date given"); 
   }
   
   //Copy Constructor
   //IMPORT: inEvent (UniEvent Object)
   public UniEvents(UniEvents inEvent)
   {
      unit = inEvent.getUnit();
      dateTimeEvent = inEvent.getDateTime();
   }
   
   //Mutator setUnit
   //IMPORT inUnit
   //EXPORT: None
   //individually sets the event unit using its classfield
   public void setUnit(String inUnit)
   {
      unit = inUnit;
   }
   
   //Mutator setTime
   //IMPORT: inMinute, inHour, inDay, inMonth, inYear
   //EXPORT: None
   //indivually sets the event time using its classfieldds
   public void setTime(int inMinute, int inHour, int inDay,
                       int inMonth, int inYear)
   {
      if(validateTime(inMinute, inHour, inDay, inMonth, inYear))
      {
         dateTimeEvent.set(inYear, inMonth, inDay, inHour, inMinute);
      }
   }
   
   //Mutator setEvent
   //IMPORT: inUnit, inMinute, inHour, inDay, inMonth, inYear
   //EXPORT: None
   //simulataneously sets the event unit and time
   public void setEvent(String inUnit, int inMinute, int inHour, int inDay, 
                        int inMonth, int inYear)
   {
      unit = inUnit;
      if(validateTime(inMinute, inHour, inDay, inMonth, inYear)) 
      {
         dateTimeEvent.set(inYear, inMonth, inDay, inHour, inMinute);
      }
   }
   
   //Accessor getUnit
   //IMPORT: None
   //EXPORT: unit
   public String getUnit()
   {
      return unit;
   }
   
   //Accessor getDateTime
   //IMPORT: None
   //EXPORT: dateTimeEvent
   public GregorianCalendar getDateTime()
   {
      return dateTimeEvent;
   }
   
   //Abstract eventLocation
   //IMPORT: None
   //EXPORT location of event as a string
   //accounts for LectureEvent & TutorialEvent differences in location datatypes
   //both event locations are reutrned as a string
   public abstract String eventLocation();
   
   //Abstract equals
   //IMPORT: inEvent (UniEvent object)
   //EXPORT: isEqual
   //determines if two UniEvents are equal
   //abstract method required as both classes use abstract method eventLocation
   public abstract boolean equals(UniEvents inEvent);
   
   //Protected equalUnitAndTime
   //IMPORT: inUniEvent (UniEvent object)
   //EXPORT: isEqual
   //determines if two events have the same time and and unit name
   protected boolean equalUnitAndTime(UniEvents inUniEvent)
   {
      boolean isEqual = false;
      if(dateTimeEvent.equals(inUniEvent.getDateTime()) &&
         unit.equals(inUniEvent.getUnit()))
      {
         isEqual = true;
      }
      return isEqual;
   }
   
   //Protected timeTilEvent
   //IMPORT: None
   //EXPORT: outString
   //calculates time until an event begins using Unix epoch time
   protected String timeTilEvent()
   {
      String outString; 
      long currentTemp = new GregorianCalendar().getTimeInMillis();
      long eventTemp = getDateTime().getTimeInMillis();
      //convert epoch time from milliseconds to minutes
      long currentMinute = currentTemp / 60000L;    
      long eventMinute = eventTemp / 60000L;      
      long timeRemaining = eventMinute - currentMinute;
      outString = convertTime(timeRemaining);
      return outString;
   }
   
   //Private convertTime
   //IMPORT: timeRemaining (in minutes)
   //EXPORT: outString
   //converts timeTilEvent calculated time to a more readable form
   private String convertTime(long timeRemaining)
   {
      String outString;
      int days, hours, minutes;
      days = (int)timeRemaining / 1440;   //1440 = No. of minutes in 1 day
      hours = ((int)timeRemaining % 1440) / 60; //60 = No. of minutes in 1 hour 
      minutes = (int)timeRemaining - days*1440 - hours*60;
      outString = (days + " days, " + hours +" hours, " + minutes+ " minutes");
      return outString;
   }
   
   //Private validateTime
   //IMPORT: inMinute, inHour, inDay, inMonth, inYear
   //EXPORT: isValid
   //determines if dateTimeEvent is a time after initialision 
   private boolean validateTime(int inMinute, int inHour, int inDay,
                                int inMonth, int inYear)
   {
      boolean isValid = false;
      long currentTime = new GregorianCalendar().getTimeInMillis();
      long eventTime = new GregorianCalendar(inYear, inMonth, inDay, inHour,
                                             inMinute).getTimeInMillis();
      if(eventTime > currentTime)
      {
         isValid = true;
      }
      return isValid;
      
   }
}
