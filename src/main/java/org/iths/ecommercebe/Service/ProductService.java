package org.iths.ecommercebe.Service;

import org.iths.ecommercebe.Exceptions.ProductNotFoundException;
import org.iths.ecommercebe.Model.Product;
import org.iths.ecommercebe.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product (id=" + id + ") not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product (id=" + id + ") not found");
        }
        updatedProduct.setId(id);
        return productRepository.save(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product (id=" + id + ") not found");
        }
        productRepository.deleteById(id);
    }
}
