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
@RequestMapping(path = "{/dsw2}")
public class ProductController {

    @Autowired
    private ProductRepository rep;


    @GetMapping(path = {"/product", "/product/"})
    public List<Product> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = {"/product/{id}", "/product/{id}/"})
    public Product retriveOne(@PathVariable Integer id) {
        Optional<Product> prod = rep.findById(id);

        return prod.get();
    }

    @PostMapping(path = {"/product", "/product/"})
    public ResponseEntity<Object> create(@RequestBody Product prod) {
        Product entity = rep.save(prod);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/product/{id}", "/product/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Product prod) {
        Optional<Product> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        prod.setId(id);
        rep.save(prod);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/product/{id}", "/product/{id}/"})
    public void delete(@PathVariable Integer id) {
        rep.deleteById(id);
    }
}
