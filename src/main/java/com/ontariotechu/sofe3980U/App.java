package com.ontariotechu.sofe3980U;
import java.util.Scanner;
import org.joda.time.LocalTime;

public class App {
    public static void main(String[] args) {
        // print the current time using joda
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
        
        // get the user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first binary number: ");
        Binary b1 = new Binary(scanner.nextLine());
        System.out.print("Enter second binary number: ");
        Binary b2 = new Binary(scanner.nextLine());

        // show the results of all operations
        System.out.println("Addition: " + Binary.add(b1, b2).getValue());
        System.out.println("Bitwise OR: " + Binary.or(b1, b2).getValue());
        System.out.println("Bitwise AND: " + Binary.and(b1, b2).getValue());
        System.out.println("Multiplication: " + Binary.multiply(b1, b2).getValue());
    }
}
