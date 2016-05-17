/**************************************************************************
 * Public Class LectureEvent INHERITS UniEvents
 * Implements ISchedule interface, forcing a toString printAlert method
 * Serves as a template for creating Lecture events
 **************************************************************************/
public class LectureEvent extends UniEvents implements ISchedule
{
	//Class fields
	private String lectureHall;
	
	//Constructors
	
   //Default Constructor
   //IMPORT: None
	public LectureEvent()
	{
		super();
		lectureHall = "";
	}
	
   //Alternate Constructor
   //IMPORT: inUnit, inLectureHall, inDay, inMonth, inYear, inHour, inMinute
	public LectureEvent(String inUnit, String inLectureHall, int inDay,
                       int inMonth, int inYear, int inHour,
                       int inMinute)
	{
		super(inUnit, inMinute, inHour, inDay, inMonth, inYear);
		lectureHall = inLectureHall;
	}
	
   //Copy Constructor
   //IMPORT: inLectureEvent (LectureEvent object)
	public LectureEvent(LectureEvent inLectureEvent)
	{
		super(inLectureEvent);
		lectureHall = inLectureEvent.getLectureHall();
	}
	
	//Mutators
   
   //Mutator setLectureHall
   //IMPORT: inLectureHall (string)
   //EXPORT: None
	public void setLectureHall(String inLectureHall)
	{
		lectureHall = inLectureHall;
	}
	
	//Accessors
   
   //Accessor getLectureHall
   //IMPORT: None
   //EXPORT: copy of lectureHall
	public String getLectureHall()
	{
		return new String(lectureHall);
	}
	
   //Accessor equals
   //IMPORT: inObject (Object object)
   //EXPORT: isEqual (boolean)
	public boolean equals(Object inObject)
	{
		boolean isEqual = false;
		LectureEvent inLecture = null;
		if(inObject instanceof LectureEvent)
		{
			inLecture = (LectureEvent)inObject;
			if(super.equals(inLecture))
				if(lectureHall.equals(inLecture.getLectureHall()))
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
      outString = ("Lecture for "+ super.getUnit() + " in lecture hall " + 
                   lectureHall + " on " + super.getDateTime().getTime()); 
      return outString;
   }
   
   //IMPERATIVES
   
   //Imperative printAlert
   //IMPORT: None
   //EXPORT: None
   public void printAlert()
   {
      String timeRemaining = super.timeTilEvent();
      System.out.println("You have a lecture in " + lectureHall +
                         " for " + super.getUnit() + " in " + timeRemaining);
   }

}

