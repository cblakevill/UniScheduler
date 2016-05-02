/**************************************************************************
 * Public Class LectureEvent INHERITS UniEvents
 * Implements ISchedule interface, forcing a toString printAlert method
 * Serves as a template for creating Lecture events
 **************************************************************************/
public class LectureEvent extends UniEvents implements ISchedule
{
	private String lectureHall;
	
	public LectureEvent()
	{
		super();
		lectureHall = "Unspecified lecture hall";
	}
	
	public LectureEvent(String inUnit, String inLectureHall, int inDay,
								 int inMonth, int inYear, int inHour,
								 int inMinute)
	{
		super(inUnit, inMinute, inHour, inDay, inMonth, inYear);
		lectureHall = inLectureHall;
	}
	
	public LectureEvent(LectureEvent inLectureEvent)
	{
		super(inLectureEvent);
		lectureHall = inLectureEvent.eventLocation();
	}
	
	public void setLectureEvent(String inUnit, int inMinute, int inHour,         
	                            int inDay, int inMonth, int inYear, 
	                            String inLectureHall)
	{
		super.setEvent(inUnit, inMinute, inHour, inDay, inMonth, inYear);
		lectureHall = inLectureHall;
	}
	
	
	public String eventLocation()
	{
		return lectureHall;
	}
	
	public boolean equals(UniEvents inEvent)
	{
		String inLocation = inEvent.eventLocation(); 
		boolean isEqual = false;
		if(super.equalUnitAndTime(inEvent) &&
		   lectureHall.equals(inLocation))
		{
			isEqual = true;
		}
		return isEqual;
	}
	
	//Display events
	public String toString()
   {
      String outString;
      outString = ("Lecture for "+ super.getUnit() + " in lecture hall " + 
                   eventLocation() + " on " + super.getDateTime().getTime()); 
      return outString;
   }
   
   //print alert
   public void printAlert()
   {
      String timeRemaining = timeTilEvent();
      System.out.println("You have a lecture in " + eventLocation() +
                         " for " + super.getUnit() + " in " + super.timeTilEvent());
   }

}
