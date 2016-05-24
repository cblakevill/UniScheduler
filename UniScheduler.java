 /**************************************************************************
 * Program: UniScheduler
 * Author: Christopher Villegas
 * Student ID: 18359884 
 * Unit: OOPD 
 **************************************************************************/
import java.util.*;

public class UniScheduler
{
   public static void main(String args[])
   {
      boolean exitMenu = false;
      while(!exitMenu)
      {
         try
         {
            exitMenu = Menu.mainMenu();
         }
         catch(ArrayIndexOutOfBoundsException e)
         {
            System.out.println("---------------------------");
            System.out.println("Error: Already 10 items in the list");
         }
         catch(InputMismatchException e)
         {
            System.out.println("---------------------------");
            System.out.println("Error: Invalid input");
            System.out.println("Invalid character detected");
         }
      }
      System.out.println("---------------------------");
      System.out.println("Exiting Program");
      System.out.println("---------------------------");
   }
}

