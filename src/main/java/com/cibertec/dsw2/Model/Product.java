package com.cibertec.dsw2.Model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="seq_product_id", allocationSize=1)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sq_product_id")
    @Column(name = "num_product_id")
    private Integer num_product_id;

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

}
