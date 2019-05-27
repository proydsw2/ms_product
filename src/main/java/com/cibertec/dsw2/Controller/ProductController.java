package com.cibertec.dsw2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.cibertec.dsw2.Model.Product;
import com.cibertec.dsw2.Repository.ProductRepository;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository repository;


    @RequestMapping("/")
    public String loadingpage(){
        return "<h1>Ingresa un path para obtener los datos</h1>";
    }

    @GetMapping(path = "/product")
    public List<Product> retriveAll() {
        log.info("Encontrando todos los objetos");
        return repository.findAll();
    }

    @GetMapping(path = "/product/{id}")
    public Product retriveOne(@PathVariable Long id) {
        log.info("Encontrando un objeto");
        return repository.findOne(id);
    }

    @PostMapping(path = "/product")
    public ResponseEntity<Object> create(@RequestBody Product prod) {
        log.info("Agregando un objeto");
        Product entity = repository.save(prod);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_product_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/product/{id}", "/product/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Product prod) {
        log.info("Actualizando un objeto");
        Product entity = repository.findOne(id);

        Optional<Product> resp = Optional.ofNullable(entity);

        if (!resp.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        prod.setNum_product_id(id);
        repository.save(prod);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/product/{id}", "/product/{id}/"})
    public void delete(@PathVariable Long id) {
        log.info("Eliminando un objeto");
        repository.delete(id);
    }
}
