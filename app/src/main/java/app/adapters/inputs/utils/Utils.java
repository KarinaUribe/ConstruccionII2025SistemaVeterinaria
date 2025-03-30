/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.inputs.utils;

/**
 *
 * @author USUARIO
 */
import java.util.Scanner;

public abstract class Utils {
    private static final Scanner reader = new Scanner(System.in);

    public static Scanner getReader() {
        return reader;
    }

    public static String readString(String message) {
        System.out.print(message + ": ");
        return reader.nextLine().trim();
    }

    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message + ": ");
                return Integer.parseInt(reader.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero entero valido.");
            }
        }
    }

    public static long readLong(String message) {
        while (true) {
            try {
                System.out.print(message + ": ");
                return Long.parseLong(reader.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero largo valido.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message + ": ");
                return Double.parseDouble(reader.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero decimal valido.");
            }
        }
    }

    public static void closeScanner() {
        reader.close();
    }
}
