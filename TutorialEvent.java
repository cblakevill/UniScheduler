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
      {
         classroom = 0;
      }
	}
   
   public TutorialEvent(TutorialEvent inTutorialEvent)
   {
      super(inTutorialEvent);
      classroom = inTutorialEvent.getClassroom();
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
      if(classroom == 0)
      {
         classroomString = "Invalid classroom";
      }
      else
      {
         classroomString = Integer.toString(classroom);
      }
      return classroomString;
   }
   
   public boolean equals(UniEvents inEvent)
   {
      boolean isEqual = false;
      if(super.equalUnitAndTime(inEvent) && 
         this.eventLocation().equals(inEvent.eventLocation()))
      {
         isEqual = true;
      }
      return isEqual;
   }
   
   //Display events
   public String toString()
   {
      String outString;
      outString = ("Tutorial for "+ this.getUnit() + " in classroom " + 
                   this.eventLocation() + " at " +
                   this.dateTimeEvent.getTime()); 
      return outString;
   }
   
   //print alert
   public void printAlert()
   {
      String timeRemaining = this.timeTilEvent();
      System.out.println("You have a tutorial in " + this.eventLocation() +
                         " for " + this.getUnit() + " in " + this.timeTilEvent());
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
