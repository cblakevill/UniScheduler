/**************************************************************************
 * Public Abstract Class UniEvents (Parent Class)
 * Child Classes: Tutorial Event, Lecture Event
 * Serves as the parent class for Tutorial and Lecture events
 **************************************************************************/
import java.util.GregorianCalendar;

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
      GregorianCalendar dateTimeTemp;
      inMonth = inMonth - 1;  //decrement by 1 as month index starts from 0 
      dateTimeTemp = new GregorianCalendar(inYear, inMonth, inDay,
                                           inHour, inMinute);
      if (inUnit == null)
      {
         throw new IllegalArgumentException("invalid unit");
      }
      if(!validateTime(dateTimeTemp))
      {
         throw new IllegalArgumentException("Date cannot be set in the past"); 
      }
      unit = new String(inUnit);
      dateTimeEvent = dateTimeTemp;         
   }
   
   //Copy Constructor
   //IMPORT: inEvent (UniEvent Object)
   public UniEvents(UniEvents inEvent)
   {
      unit = inEvent.getUnit();
      dateTimeEvent = (GregorianCalendar) inEvent.getDateTime();
   }
   
   //Mutators
   
   //Mutator setUnit
   //IMPORT: inUnit (string)
   //EXPORT: None
   public void setUnit(String inUnit)
   {
      if (inUnit == null)
      {
         throw new IllegalArgumentException("invalid unit");
      }
      unit = new String(inUnit);
   }
   
   //Mutator setTime
   //IMPORT: inDateTime (GregorianCalendar object)
   //EXPORT: None
   public void setTime(GregorianCalendar inDateTime)
   {
      if(validateTime(inDateTime))
      {
         throw new IllegalArgumentException("invalid date");
      }   
      dateTimeEvent = (GregorianCalendar) inDateTime.clone();     
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
   
   //Accessor equals
   //IMPORT: inObject (Object object)
   //EXPORT: isEqual (boolean)
   //determines if two UniEvents have the same time and and unit name
   @Override
   public boolean equals(Object inObject)
   {
      boolean isEqual = false;
      UniEvents inEvent;
      if(inObject instanceof UniEvents)
      {  
         inEvent = (UniEvents) inObject; 
         if(dateTimeEvent.equals(inEvent.getDateTime()) &&
            unit.equals(inEvent.getUnit()))
         {
            isEqual = true;
         }
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
      String outString = "";
      int days, hours, minutes;
      days = (int)timeRemaining / (60 * 24);  
      hours = ((int)timeRemaining % (60 * 24)) / 60;  
      minutes = (int)timeRemaining - (days * (60 * 24)) - (hours * 60);
      
      if(days != 0)
      {
         outString += days + " days, ";
      }
      if(hours != 0)
      {
         outString += hours + " hours, ";
      }
      outString += minutes + " minutes";
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
      long eventTime;

      if(inTime == null)
      {
         throw new IllegalArgumentException("invalid date");
      }

      eventTime = inTime.getTimeInMillis();
      if(eventTime > currentTime)
      {
         isValid = true;
      }
      return isValid;
   }
}

