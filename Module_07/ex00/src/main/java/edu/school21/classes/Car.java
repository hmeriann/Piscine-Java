package edu.school21.classes;

public class Car {

    private String brand;
    private Integer price;
    private String color;
    private Integer maxSpeed;

    public Car() {
        this.brand = "Default brand";
    }

    public Car(String brand, Integer price, String color, Integer maxSpeed) {
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public int changePrice(int value) {
        return this.price += value;
    }

    public String setNewColor(String newColor) {
        return this.color = newColor;
    }

    public String setNewBrand(String newBrand) {
        return this.color = newBrand;
    }

    public int changeMaxSpeed(int value) {
        return this.maxSpeed += value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
