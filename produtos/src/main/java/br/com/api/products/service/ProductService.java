package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.products.model.ProductModel;
import br.com.api.products.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductModel> listAllProducts() {
        return productRepository.findAll();
    }
}
