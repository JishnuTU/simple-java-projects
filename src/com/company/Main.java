package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a car model : ");
        String a = input.next();
        System.out.println("BRAND:");
        String b = input.next();

        Car carOne = new Car(a,b);
        carOne.display();
    }
}


