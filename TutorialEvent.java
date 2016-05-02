/**************************************************************************
 * Public Class TutorialEvent IHERITS UniEvents
 * Implements ISchedule interface, forcing methods toString & printAlert
 * Serves as a template for creating Tutorial events
 **************************************************************************/
public class TutorialEvent extends UniEvents implements ISchedule
{
	private int classroom;
	public TutorialEvent()
	{
		super();
		classroom = 0;
	}
	
	public TutorialEvent(String inUnit, int inClassroom, int inDay, int inMonth, int inYear, 
	                    int inHour, int inMinute)
	{
		super(inUnit, inMinute, inHour, inDay, inMonth, inYear);
		if(validateClassroom(inClassroom))
		{
			classroom = inClassroom;
		}
      else
         throw new IllegalArgumentException("invalid classroom");
	}
   
   public TutorialEvent(TutorialEvent inTutorialEvent)
   {
      super(inTutorialEvent);
      classroom = inTutorialEvent.getClassroom();
   }
   
   	
	public void setTurorialEvent(String inUnit, int inClassroom , int inDay,
								 int inMonth, int inYear, int inHour,
								 int inMinute)
	{
		super.setEvent(inUnit, inMinute, inHour, inDay, inMonth, inYear);
		classroom = inClassroom;
	}
	
   
   public void setClassroom(int inClassroom)
   {
      if(validateClassroom(inClassroom))
      {
         classroom = inClassroom;
      }
   }
   
   public int getClassroom()
   {
      return classroom;
   }
   
   public String eventLocation()
   {
      String classroomString;
      classroomString = Integer.toString(classroom);
      return classroomString;
   }
   
   public boolean equals(UniEvents inEvent)
   {
	  String inLocation = inEvent.eventLocation();
      boolean isEqual = false;
      if(super.equalUnitAndTime(inEvent) && 
         eventLocation().equals(inLocation))
      {
         isEqual = true;
      }
      return isEqual;
   }
   
   //Display events
   public String toString()
   {
      String outString;
      outString = ("Tutorial for "+ getUnit() + " in classroom " + 
                   eventLocation() + " on " + super.getDateTime().getTime()); 
      return outString;
   }
   
   //print alert
   public void printAlert()
   {
      String timeRemaining = super.timeTilEvent();
      System.out.println("You have a tutorial in " + eventLocation() +
                         " for " + getUnit() + " in " + super.timeTilEvent());
   }
   
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
