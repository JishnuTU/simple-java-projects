package com.company;

class Car extends Vehicle{
    private String model;

    @Override
    public void display(){
        super.display();
        System.out.println("This is model " + model);
    }

    public Car(String model,String brand) {
        super(brand);
        this.model = model;
    }
}
