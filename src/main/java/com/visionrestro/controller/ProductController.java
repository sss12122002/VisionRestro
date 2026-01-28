package com.visionrestro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visionrestro.entity.Product;
import com.visionrestro.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "https://vision-restro.netlify.app/") // React use
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }
}

