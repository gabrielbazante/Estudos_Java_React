package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.model.ProductModel;
import br.com.api.products.model.ResponseModel;
import br.com.api.products.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResponseModel responseModel;

    public Iterable<ProductModel> listAllProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<?> saveProduct(ProductModel productModel, String action){
        if(productModel.getName().equals("")) {
            responseModel.setMessage("Product name cannot be empty");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if (productModel.getBrand().equals("")) {
            responseModel.setMessage("Product brand cannot be empty");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else {
            if(action.equals("create")){
                return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.OK);
            }
            
        }
    }
}
