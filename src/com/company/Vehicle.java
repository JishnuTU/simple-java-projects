package com.company;

class Vehicle{
    public Vehicle() {
        System.out.println("I am Super Constructor ");
    }
    protected String brand;
    public void display (){
        System.out.println("This is the brand " + brand);
    }

    public Vehicle(String brand) {
        this.brand = brand;
    }


}