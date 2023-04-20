package br.com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.model.ProductModel;
import br.com.api.products.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/listAllProducts")
    public Iterable<ProductModel> listAllProducts() {
        return productService.listAllProducts();
    }
}
