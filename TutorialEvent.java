/**************************************************************************
 * Public Class TutorialEvent IHERITS UniEvents
 * Implements ISchedule interface, forcing methods toString & printAlert
 * Serves as a template for creating Tutorial events
 **************************************************************************/
public class TutorialEvent extends UniEvents implements ISchedule
{
   //Class fields
	private int classroom;
   
   //Constructors
   
   //Default Constructor
   //IMPORT: None
	public TutorialEvent()
	{
		super();
		classroom = 1;
	}
	
   //Alternate Constructor
   //IMPORT: inUnit, inClassRoom, inDay, inMonth, inYear, inHour, inMinute
	public TutorialEvent(String inUnit, int inClassroom, int inDay, int inMonth, 
                        int inYear, int inHour, int inMinute)
	{
		super(inUnit, inMinute, inHour, inDay, inMonth, inYear);
		if(validateClassroom(inClassroom))
		{
			classroom = inClassroom;
		}
      else
         throw new IllegalArgumentException("invalid classroom");
	}
   
   //Copy Constructor
   //IMPORT: inTutorial (TutorialEvent object)
   public TutorialEvent(TutorialEvent inTutorialEvent)
   {
      super(inTutorialEvent);
      classroom = inTutorialEvent.getClassroom();
   }
   
   //Mutators
   
   //Mutator setClassRoom
   //IMPORT: inClassRoom (integer)
   //EXPORT: None
   public void setClassroom(int inClassroom)
   {
      if(validateClassroom(inClassroom))
      {
         classroom = inClassroom;
      }
   }
   
   //Accessors
   
   //Accessor getClassRoom
   //IMPORT: None
   //EXPORT: classroom
   public int getClassroom()
   {
      return classroom;
   }
   
   //Accessor equals
   //IMPORT: inObject (Object object)
   //EXPORT: isEqual (boolean)
   public boolean equals(Object inObject)
   {
	   boolean isEqual = false;
	   TutorialEvent inTutorial = null;
	   if(inObject instanceof TutorialEvent)
      {
         inTutorial = (TutorialEvent)inObject;
         if(super.equals(inTutorial))
            if(classroom == inTutorial.getClassroom())
               isEqual = true;
      }
      return isEqual;
   }
   
   //Accessor toString
   //IMPORT: None
   //EXPORT: outString (string)
   public String toString()
   {
      String outString;
      outString = ("Tutorial for "+ getUnit() + " in classroom " + 
                   classroom + " on " + super.getDateTime().getTime()); 
      return outString;
   }
   
   //Imperatives
   
   //Imperative printAlert
   //IMPORT: None
   //EXPORT: None
   public void printAlert()
   {
      String timeRemaining = super.timeTilEvent();
      System.out.println("You have a tutorial in " + classroom +
                         " for " + getUnit() + " in " + timeRemaining);
   }
   
   //Private
   
   //Private validateClassRoom
   //IMPORT: inClassRoom (integer)
   //EXPORT: isValid (boolean)
   private boolean validateClassroom(int inClassroom)
   {
      boolean isValid = false;
      if(inClassroom >= 1 && inClassroom <= 400)
      {
         isValid = true;
      }
      return isValid;
   }
}

