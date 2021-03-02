package com.LockedMe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;
import java.util.List;

public class LockMeFunctions {

  private static final Logger logger = LogManager.getLogger(LockMeFunctions.class);
  private static List<String> filenames = FileService.getFilenames();

  public static void viewFiles() {
    System.out.println("\nThe following files are stored:");
    filenames.forEach(System.out::println);
    System.out.println("\n");
  }

  public static void searchFiles() {
    boolean exit = false;

    do {

      String fileToSearch = UserInputHandler.getStringInput("\nWhat filename are you looking for?\t");

      if (!UserInputHandler.isValidFilename(fileToSearch)) {
        System.out.println("Filename was invalid, please try again");
        continue;
      }

      if (filenames.contains(fileToSearch)) {
        System.out.printf("%s found!%n", fileToSearch);
      } else {
        System.out.printf("%s not found.%n", fileToSearch);
      }

      int value = UserInputHandler.getIntInput("\nWould you like to search again?" +
          "\n\t1) Search for another file" +
          "\n\t2) Return to main menu" +
          "\nEnter your choice:\t"
      );

      switch (value) {
        case 1:
          continue;
        case 2:
          exit = true;
          break;
        default:
          System.out.println("You have made an invalid choice!");
      }

    } while (!exit);

    Menu.mainMenu();
  }

  public static void addFile() {
    boolean exit = false;

    do {

      String fileToAdd = UserInputHandler.getStringInput("\nWhat is the name of your file?\t");

      if (!UserInputHandler.isValidFilename(fileToAdd)) {
        System.out.println("Filename contained invalid characters, please try again");
        continue;
      }

      if (filenames.contains(fileToAdd)) {
        System.out.println("File already exists, please try again");
        continue;
      }

      try {
        FileService.addFile(fileToAdd);
      } catch (URISyntaxException ur) {
        logger.error(ur.getMessage());
      }

      filenames = FileService.getFilenames();

      int value = UserInputHandler.getIntInput("\nWould you like to add another file?" +
          "\n\t1) Add another file" +
          "\n\t2) Return to main menu" +
          "\nEnter your choice:\t"
      );

      switch (value) {
        case 1:
          continue;
        case 2:
          exit = true;
          break;
        default:
          System.out.println("You have made an invalid choice!");
      }

    } while (!exit);

    Menu.mainMenu();
  }

  static void deleteFile() {
    boolean exit = false;

    String fileToDelete = UserInputHandler.getStringInput("\nWhich file would you like to remove?\t");

    do {
       int value = 0;

      if (filenames.contains(fileToDelete)) {

        value = UserInputHandler.getIntInput(
          "\n File found. Are you sure you want to delete it permanently?" +
          "\n\t1) YES, please proceed to delete " + fileToDelete +
          "\n\t2) No, I don't want to remove this file" +
          "\nEnter your choice:\t");

      } else {
        System.out.println(fileToDelete + " not found.");
      }

      switch (value) {
        case 1:
          confirmedDelete(fileToDelete);
          exit = true;
          break;
        case 2:
          exit = true;
          break;
        default:
          System.out.println("You have made an invalid choice!");
      }

    } while (!exit);

    deleteAnotherMenu();
  }

  private static void confirmedDelete(String fileToDelete) {
    FileService.deleteFile(fileToDelete);
    filenames = FileService.getFilenames();
    deleteAnotherMenu();
  }

  private static void deleteAnotherMenu() {
    boolean exit = false;

    do {
      int value = UserInputHandler.getIntInput("\nWould you like to delete another file?" +
          "\n\t1) Yes, remove another file" +
          "\n\t2) Return to main menu" +
          "\nEnter your choice:\t"
      );

      switch (value) {
        case 1:
          deleteFile();
          break;
        case 2:
          exit = true;
          break;
        default:
          System.out.println("You have made an invalid choice!");
      }

    } while (!exit);

    Menu.mainMenu();
  }
}
