package edu.school21.models;

public class Product {

    private static Long prevId = 0L;
    private Long id;
    private String name;
    private int price;


    public Product(String name, int price) {
        this.id = prevId++;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
