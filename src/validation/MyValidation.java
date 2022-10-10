/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class MyValidation {

    public static Scanner sc = new Scanner(System.in);
    public static Calendar instance = Calendar.getInstance();

    public static String getString(String inputMsg, String errorMsg) {
        String tmp;
        while (true) {
            System.out.print(inputMsg);
            tmp = sc.nextLine().trim();
            if (tmp.length() == 0 || tmp.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return tmp;
            }
        }
    }

    public static int getInt(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String yesNo(String inputMsg, String errorMsg) {
        String n;
        while (true) {
            System.out.println(inputMsg);
            n = sc.nextLine().trim().toLowerCase();
            if (n.length() >= 1 && (n.equalsIgnoreCase("yes") || n.equalsIgnoreCase("no"))) {
                return n;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    public static String updateString(String oldValue, String message) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static String updataYesNo(String oldValue, String inputMsg, String errorMsg) {
        String n;
        while (true) {
            System.out.println(inputMsg);
            n = sc.nextLine().trim().toLowerCase();
            if (n.length() >= 1 && (n.equalsIgnoreCase("yes") || n.equalsIgnoreCase("no"))) {
                return n;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    public static int updateInt(int oldValue, String message) {
        int result = oldValue;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        try {
            do {
                System.out.println(message);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } while (check);

        } catch (Exception e) {
        }
        return result;
    }

    public static int yearOfThePast(String msg, String errorMsg) {
        int n;
        int currentYear = instance.get(Calendar.YEAR);
        while (true) {
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n >= 0 && n <= currentYear) {
                    return n;
                } else {
                    System.out.println(errorMsg);
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int updateyearOfThePast(int oldvalue, String inputMsg, String errorMsg) {
        int n;
        int currentYear = instance.get(Calendar.YEAR);
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n >= 0 && n <= currentYear) {
                    return n;
                } else {
                    System.out.println(errorMsg);
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getId(String message, String errorMessage, String id, String format) {
        while (true) {
            try {
                String pattern = format;
                System.out.println(message);
                id = sc.nextLine().trim().toLowerCase();
                if (!id.matches(pattern)) {
                    throw new Exception();
                } else {
                    return id;
                }
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }
    
   
  
}
