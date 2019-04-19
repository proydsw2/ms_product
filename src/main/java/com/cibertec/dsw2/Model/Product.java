package com.cibertec.dsw2.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@javax.persistence.Entity
public class Product {

    @Id
    @GeneratedValue()
    @JsonProperty("id")
    private int id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private double price;

    @JsonProperty("stock")
    private int stock;

    @JsonProperty("console_id")
    private int console_id;

    @JsonProperty("videogame_id")
    private int videogame_id;

    @JsonProperty("status")
    private char status;

    public Product(){

    }

    public Product(int id, String description, double price, int stock, int console_id, int videogame_id, char status){
        this.id = id;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.console_id = console_id;
        this.videogame_id = videogame_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public int getVideogame_id() {
        return videogame_id;
    }

    public void setVideogame_id(int videogame_id) {
        this.videogame_id = videogame_id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString(){

        return "Product: {"+
                "id = "+getId() +
                "description = " + getDescription() +
                "pice ="+getPrice()+
                "status"+getStatus()+
                "console_id"+getConsole_id()+
                "videogame_id"+getVideogame_id()+"}";

    }

}
