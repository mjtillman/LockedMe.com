package com.LockedMe;

public class Menu {

  public static void mainMenu() {

    boolean exit = false;

    do {

      System.out.println(mainMenuTxt);

      int options = UserInputHandler.getIntInput("\nEnter your choice:\t");

      switch (options) {
        case 1:
          LockMeFunctions.viewFiles();
          break;
        case 2:
          LockMeFunctions.searchFiles();
          break;
        case 3:
          LockMeFunctions.addFile();
          break;
        case 4:
          LockMeFunctions.deleteFile();
          break;
        case 0:
          exit = true;
          break;
        default:
          System.out.println("You have made an invalid choice!");
      }
    } while (!exit);

    closeApp();
  }

  static void closeApp() {
    System.out.println("Good-bye!");
  }

  private static final String mainMenuTxt = "" +
      "\n  M A I N   M E N U\n" +
      "---------------------------\n" +
      "\t1)  View files\n" +
      "\t2)  Search for a file\n" +
      "\t3)  Add a file\n" +
      "\t4)  Delete a file\n" +
      "\t0)  Exit";
}
