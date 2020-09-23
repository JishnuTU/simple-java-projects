package com.company;

public class UnaryOperator {

    public static void main (String[] args){
        int number =3;
        System.out.println("The number is "+number);
        System.out.println("The incremented Value is " + (++number));

        System.out.println("Again the ++ Value is "+ number);

        number =3;

        System.out.println("The incremented Value is " + (number++));

        System.out.println("Again the Value++ is "+ number);

    }
}
