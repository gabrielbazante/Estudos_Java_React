package br.com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/registerProduct")
    public ResponseEntity<?> saveProduct(@RequestBody ProductModel productModel) {
        return productService.saveProduct(productModel, "create");
    }
}
