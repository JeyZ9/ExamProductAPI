package com.api.productapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductById(product.getId());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Id Taken");
        }
        productRepository.save(product);
    }

    public void removeProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalArgumentException("Product Not Found: " + productId);
        }
        productRepository.deleteById(productId);
    }

    public void updateProduct(Long productId, byte[] image, String name, String description, int price) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product Not Found: " + productId));

        if (name != null && !Objects.equals(product.getName(), name)) {
            product.setName(name);
        }

        if (description != null && !Objects.equals(product.getDescription(), description)) {
            product.setDescription(description);
        }

        if (image != null) {
            product.setImage(image);
        }

        if (!Objects.equals(product.getPrice(), price)) {
            product.setPrice(price);
        }

        productRepository.save(product);
    }
}
