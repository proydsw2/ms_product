package com.cibertec.dsw2.Service.Implement;

import com.cibertec.dsw2.Model.Product;
import com.cibertec.dsw2.Repository.ProductRepository;
import com.cibertec.dsw2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Object> getAll() {
        try {
            List<Product> products = productRepository.findAll();

            if (products == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        try {
            Optional<Product> product = productRepository.findById(id);

            if (!product.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> insert(Product product) {
        try {
            Product entity = productRepository.save(product);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getNum_product_id()).toUri();

            return ResponseEntity.ok().body(entity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> update(Integer id, Product product) {
        try {
            Optional<Product> entity = productRepository.findById(id);

            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            product.setNum_product_id(id);
            Product cust = productRepository.save(product);
            return ResponseEntity.ok().body(cust);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> delete(Integer id) {

        try {
            Optional<Product> entity = productRepository.findById(id);
            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
