package com.LockedMe;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputHandler {

  private static final Scanner sc = new Scanner(System.in);

  static Integer getIntInput(String instruction) {

    boolean isPosInt = false;
    int value = 0;

    do {

      System.out.print(instruction);

      try {
        value = Integer.parseInt(sc.nextLine());
        if (value > -1) {
          isPosInt = true;
        }
      } catch (Exception e) {
        if (e.getClass() == IllegalArgumentException.class) {
          System.out.println(e.getMessage());
        } else {
          System.out.println(value + " is invalid input!\t");
          break;
        }
      }
    } while (!isPosInt);

    return value;
  }

  static String getStringInput(String instruction) {
    boolean exit = false;
    String query = "";

    do {

      System.out.print(instruction);

      try {
        query = StringUtils.trim(sc.nextLine());

        if (!query.isEmpty()) {
          exit = true;
        }
      } catch (Exception e) {
        if (e.getClass() == IllegalArgumentException.class) {
          System.out.println(e.getMessage());
        } else {
          System.out.println(query + " is invalid input!\t");
          break;
        }
      }
    } while (!exit);

    return query;
  }

  private static final Pattern FILENAME_REGEX = Pattern.compile("" +
      "^([a-zA-Z\\d.\\-_]){1,255}$");

  public static boolean isValidFilename(String name) {

    name = name.replaceAll("^[\\s+]", "");
    name = name.toLowerCase();

    String firstAndLast = name.substring(0,1) + name.substring(name.length() - 1);

    boolean invalidFirstOrLast = StringUtils.containsAny(firstAndLast, ".-_");

    if (invalidFirstOrLast) {
      return false;
    }

    Matcher matcher2 = FILENAME_REGEX.matcher(name);
    return matcher2.find();
  }
}
