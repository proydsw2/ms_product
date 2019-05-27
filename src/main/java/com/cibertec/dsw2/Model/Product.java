package com.cibertec.dsw2.Model;

import javax.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "num_product_id")
    private Long num_product_id;

    @Column(name = "str_description")
    private String description;

    @Column(name = "num_price")
    private Double price;

    @Column(name = "num_stock")
    private int stock;

    @Column(name = "num_console_id")
    private int console_id;

    @Column(name = "num_videogame_id")
    private int videogame_id;

    @Column(name = "chr_status")
    private String status;

    public Product() {
    }

    public Product(Long num_product_id, String description, double price, int stock, int console_id, int videogame_id, String status) {
        this.num_product_id = num_product_id;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.console_id = console_id;
        this.videogame_id = videogame_id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "num_product_id=" + num_product_id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", console_id=" + console_id +
                ", videogame_id=" + videogame_id +
                ", status=" + status +
                '}';
    }

    public Long getNum_product_id() {
        return num_product_id;
    }

    public void setNum_product_id(Long num_product_id) {
        this.num_product_id = num_product_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
