package com.company;

public class Main {

    public static void main(String[] args) {

	// write your code here
        int a = 8;
        if (a==5){
            System.out.println("A is 5");
            a=a+5;
        }
        else {
            System.out.println("A is not 5");
            a=a+4;
        }
        a++;
        System.out.println("A is"+a);
    }
}
