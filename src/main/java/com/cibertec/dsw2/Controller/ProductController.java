package com.cibertec.dsw2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.cibertec.dsw2.Model.Product;
import com.cibertec.dsw2.Repository.ProductRepository;

@RestController
public class ProductController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ProductRepository repository;


    @GetMapping(path = "/product")
    public List<Product> retriveAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/product/{id}")
    public Product retriveOne(@PathVariable long id) {
        Optional<Product> prod = repository.findById(id);

        return prod.get();
    }

    @PostMapping(path = "/product")
    public ResponseEntity<Object> create(@RequestBody Product prod) {
        Product entity = repository.save(prod);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_product_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/product/{id}", "/product/{id}/"})
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Product prod) {
        Optional<Product> entity = repository.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        prod.setNum_product_id(id);
        repository.save(prod);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/product/{id}", "/product/{id}/"})
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
