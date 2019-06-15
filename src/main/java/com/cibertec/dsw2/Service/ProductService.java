package com.cibertec.dsw2.Service;

import com.cibertec.dsw2.Model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<Object> getAll();

    ResponseEntity<Object> getOne(Integer id);

    ResponseEntity<Object> insert(Product product);

    ResponseEntity<Object> update(Integer id, Product product);

    ResponseEntity<Object> delete(Integer id);
}