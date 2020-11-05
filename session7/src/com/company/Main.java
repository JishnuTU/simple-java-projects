package com.company;

public class Main {

    public static void main(String[] args) {
        Car c = Car.getInstance();
        c.setColor("black");
        c.setModelName("ds");
        c.display();
    }
}
