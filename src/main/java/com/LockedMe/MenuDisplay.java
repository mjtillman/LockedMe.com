package com.LockedMe;

public class MenuDisplay {

  public static void welcome() {
    System.out.println("" +
        "+----------------------------------------------------------------------------+" +
        "|   L   O   C   K   E   D   M   E   .   C   O   M                            |" +
        "|   ======================================================================   |" +
        "|   Developed by: Mindy Tillman                      mindy.tillman@hcl.com   |" +
        "+----------------------------------------------------------------------------+"
    );
  }

  final String mainMenu() {

    StringBuilder str = new StringBuilder();
    str.append("  M A I N   M E N U")
      .append(" 1)  View files")
      .append(" 2)  Search for a file")
      .append(" 3)  Add a file")
      .append(" 4)  Delete a file")
      .append(" 0)  Exit");

    return str.toString();
  }

  public static String viewFileMenu() {

  }

  public static String searchFileMenu() {

  }

  public static String addFileMenu() {

  }

  public static String deleteFileMenu() {

  }
}
