package org.iths.ecommercebe.Service;

import org.iths.ecommercebe.Model.Category;
import org.iths.ecommercebe.Model.Product;
import org.iths.ecommercebe.Repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private Sort resolveSort(String sort) {
        return switch (sort) {
            case "price_asc" -> Sort.by("price").ascending();
            case "price_desc" -> Sort.by("price").descending();
            case "rating" -> Sort.by("averageRating").descending();
            case "newest" -> Sort.by("createdAt").descending();
            default -> Sort.by("id").descending();
        };
    }

    // Gets All products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Gets the Product
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Gets products only in certain categories
    public List<Product> getProductsByCategory(Category cat, String sortParam) {
        Sort resolvedSort = resolveSort(sortParam);

        return productRepository.findByCategoryAndActiveTrue(cat, resolvedSort);
    }

    // Gets the featured products
    public List<Product> getFeaturedProducts() {
        return productRepository.findByFeaturedTrueAndActiveTrue();
    }

    // Gets products that matches the search
    public List<Product> search(String query) {
        return productRepository.searchByName(query);
    }
}
