/**************************************************************************
 * Public EventItems
 * Constructs eventItems from user input in the form of ISchedule objects.
 * events are put into the ScheduleList array via the Menu class
 **************************************************************************/
public class EventItems
{
	//Class fields
	private ISchedule event;
	
	//Default constructor
	//IMPORT: None
	public EventItems()
	{
		event = null;
	}
	
	//Lecture constructor
	//IMPORT: inUnit, inLectureHall inDay, inMonth, inYear, inHour, inMinute
	public EventItems(String inUnit, String inLectureHall, int inDay,
					  int inMonth, int inYear, int inHour, int inMinute)
	{
		event = new LectureEvent(inUnit, inLectureHall, inDay, inMonth, 
								 inYear, inHour, inMinute);
	}
	
	//Tutorial constructor
	//IMPORT: 
	public EventItems(String inUnit, int inClassroom, int inDay, int inMonth, 
					  int inYear, int inHour, int inMinute)
	{
		event = new TutorialEvent(inUnit, inClassroom, inDay, inMonth, inYear,
								  inHour, inMinute);
	}

	//Accessor getISchedule
	//IMPORT: None
	//EXPORT: event (ISchedule object)
	//returns a given event as an ISchedule object
	public ISchedule getISchedule()
	{
			return event;
	}
	
}
