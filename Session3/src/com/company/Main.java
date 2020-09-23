package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Value : ");
        int a = sc.nextInt();
        System.out.println("Enter the Second Value");
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("The sum of Values is "+ sum);
    }
}
