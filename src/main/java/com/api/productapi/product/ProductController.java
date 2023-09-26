package com.api.productapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void createProduct(
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("description") String description
    ) {
        try {
            byte[] imageBytes = imageFile.getBytes();
            Product product = new Product(imageBytes, name, description);
            productService.addProduct(product);
        } catch (IOException e) {
            System.err.println("An arithmetic exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/{productId}")
    public void removeProduct(@PathVariable("productId") Long id) {
        productService.removeProduct(id);
    }

    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) MultipartFile imageFile,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ) {
        try {
            byte[] imageBytes = imageFile != null ? imageFile.getBytes() : null;
            productService.updateProduct(productId, imageBytes, name, description);
        } catch (IOException e) {
            System.err.println("An arithmetic exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/{productId}")
    public ResponseEntity<String> updateProductWithParams(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) MultipartFile imageFile,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ) {
        try {
            byte[] imageBytes = imageFile != null ? imageFile.getBytes() : null;
            productService.updateProduct(productId, imageBytes, name, description);
            return ResponseEntity.ok("Product updated successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product");
        }
}


}