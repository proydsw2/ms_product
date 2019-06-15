package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Model.Product;
import com.cibertec.dsw2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/product")
    public ResponseEntity<Object> retriveAll() {
        return productService.getAll();
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }

    @PostMapping(path = "/product")
    public ResponseEntity<Object> create(@RequestBody Product product) {
        return productService.insert(product);
    }

    @PutMapping(path = "/product/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return productService.delete(id);
    }
}
