package br.com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.model.ProductModel;
import br.com.api.products.model.ResponseModel;
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

    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel productModel) {
        return productService.saveProduct(productModel, "update");
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<ResponseModel> deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
