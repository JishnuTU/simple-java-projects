package com.company;

public class Car {
   private String color;
    private String modelName;
    
    private static int carCount;

    private static Car singleObjectOfCar ;

    public static Car getInstance (){

        if(singleObjectOfCar ==null){
            singleObjectOfCar = new Car("","");
        }
        return  singleObjectOfCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static void setCarCount() {
        carCount = carCount +1;
    }

    public void display(){
        System.out.println("The color is :"+color);
        System.out.println("The modelName is  :"+ modelName);
        System.out.println("Number of cars "+carCount);
    }
    public Car(String color, String modelName){
       this.color = color;
       this.modelName = modelName;
    }
    
}
