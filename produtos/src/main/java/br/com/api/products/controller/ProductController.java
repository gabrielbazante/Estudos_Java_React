package br.com.api.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @GetMapping("/")
    public String routeTest() {
        return "Products API is running!";
    }
}
