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
	private GregorianCalendar dateTimeEvent;
	
	//Constructors
	
   //Default Constructor
   //IMPORT: None
	public UniEvents()
	{
		unit = "";
		dateTimeEvent = new GregorianCalendar();
	}
   
   //Alternate Constructor
   //IMPORT: inUnit, inMinute, inHour, inDay, inMonth, inYear (integers)
   public UniEvents(String inUnit, int inMinute, int inHour, int inDay, 
                         int inMonth, int inYear)
   {
      unit = inUnit;
      inMonth = inMonth - 1;  //decrement by 1 as month index starts from 0 
      GregorianCalendar dateTimeTemp = 
      new GregorianCalendar(inYear, inMonth, inDay, inHour, inMinute); 
      if(validateTime(dateTimeTemp)) 
      {
         dateTimeEvent = dateTimeTemp;
      }
      else
         throw new IllegalArgumentException("Error: invalid date given"); 
   }
   
   //Copy Constructor
   //IMPORT: inEvent (UniEvent Object)
   public UniEvents(UniEvents inEvent)
   {
      unit = inEvent.getUnit();
      dateTimeEvent = (GregorianCalendar) inEvent.getDateTime().clone();
   }
   
   //Mutators
   
   //Mutator setUnit
   //IMPORT: inUnit (string)
   //EXPORT: None
   public void setUnit(String inUnit)
   {
      unit = inUnit;
   }
   
   //Mutator setTime
   //IMPORT: inDateTime (GregorianCalendar object)
   //EXPORT: None
   public void setTime(GregorianCalendar inDateTime)
   {
      if(validateTime(inDateTime))
      {
         dateTimeEvent = inDateTime;
      }
   }
 
	//Accessors
	
   //Accessor getUnit
   //IMPORT: None
   //EXPORT: copy of unit
   public String getUnit()
   {
      return new String(unit);
   }
   
   //Accessor getDateTime
   //IMPORT: None
   //EXPORT: copy of dateTimeEvent
   public GregorianCalendar getDateTime()
   {	
		GregorianCalendar outDateTime = (GregorianCalendar) dateTimeEvent.clone();
      return outDateTime;
   }
   
   //Abstract equals
   //IMPORT: inEvent (UniEvent object)
   //EXPORT: isEqual (boolean)
   //determines if two events are equal
   public abstract boolean equals(Object inObject);
   
   //Protected equals
   //IMPORT: inUniEvent (UniEvent object)
   //EXPORT: isEqual (boolean)
   //determines if two events have the same time and and unit name
   protected boolean equals(UniEvents inUniEvent)
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
   //EXPORT: outString (string)
   //calculates time until an event begins using Unix epoch time
   protected String timeTilEvent()
   {
      String outString; 
      long currentTemp = new GregorianCalendar().getTimeInMillis();
      long eventTemp = dateTimeEvent.getTimeInMillis();
      //convert epoch time from milliseconds to minutes
      long currentMinute = currentTemp / 60000L;    
      long eventMinute = eventTemp / 60000L;      
      long timeRemaining = eventMinute - currentMinute;
      outString = convertTime(timeRemaining);
      return outString;
   }
   
   //Private
   
   //Private convertTime
   //IMPORT: timeRemaining (integer)
   //EXPORT: outString (string)
   //converts timeTilEvent calculated time to a more readable form
   private String convertTime(long timeRemaining)
   {
      String outString;
      int days, hours, minutes;
      days = (int)timeRemaining / (60 * 24);  
      hours = ((int)timeRemaining % (60 * 24)) / 60;  
      minutes = (int)timeRemaining - (days * (60 * 24)) - (hours * 60);
      outString = (days + " days, " + hours +" hours, " + minutes+ " minutes");
      return outString;
   }
   
   //Private validateTime
   //IMPORT: inTime (GregorianCalendar object)
   //EXPORT: isValid (boolean)
   //determines if dateTimeEvent is a time after initialision 
   private boolean validateTime(GregorianCalendar inTime)
   {
      boolean isValid = false;
      long currentTime = new GregorianCalendar().getTimeInMillis();
      long eventTime = inTime.getTimeInMillis();
      if(eventTime > currentTime)
      {
         isValid = true;
      }
      return isValid;
      
   }
}

