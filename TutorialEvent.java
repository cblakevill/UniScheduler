/**************************************************************************
 * Public Class TutorialEvent IHERITS UniEvents, ISchedule
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
      if(inClassroom >= 1 && inClassroom <= 400)
      {
         classroom = inClassroom;
      } 
      else
      {
         throw new IllegalArgumentException("Classroom must be" + 
                                            "between 1 and 400");
      }
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
      if(inClassroom >= 1 && inClassroom <= 400)
      {
         classroom = inClassroom;
      }
      else
      {
         throw new IllegalArgumentException("Classroom must be" + 
                                            "between 1 and 400"); 
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
   //Overrides equals method in UniEvents
   @Override
   public boolean equals(Object inObject)
   {
      boolean isEqual = false;
      TutorialEvent inTutorial;
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
      String eventTime = super.getDateTime().getTime().toString();
      outString = ("Tutorial for "+ super.getUnit() + " in classroom " + 
                   classroom + " on " + eventTime); 
      return outString;
   }
   
   //Accessor printAlert
   //IMPORT: None
   //EXPORT: outString (string)
   public String printAlert()
   {
      String timeRemaining = super.timeTilEvent();
      String outString; 
      outString = "You have a tutorial in room " + classroom +
                  " for " + getUnit() + " in " + timeRemaining;
      return outString;
   }
}

