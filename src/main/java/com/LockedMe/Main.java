package com.LockedMe;

public class Main {

  public static void main(String[] args) {
    System.out.println(welcome);
    FileService.refreshFilenames();
    Menu.mainMenu();
  }

  private static final String welcome = "" +
        "+----------------------------------------------------------------------------+\n" +
        "|   L   O   C   K   E   D   M   E   .   C   O   M                            |\n" +
        "|   ======================================================================   |\n" +
        "|   Developed by: Mindy Tillman                      mindy.tillman@hcl.com   |\n" +
        "+----------------------------------------------------------------------------+\n";
}
