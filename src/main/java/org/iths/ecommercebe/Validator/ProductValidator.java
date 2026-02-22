package org.iths.ecommercebe.Validator;

import org.iths.ecommercebe.Exceptions.ProductNotValidFieldException;
import org.iths.ecommercebe.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public void validateProduct(Product product) {
        isValidTitle(product.getTitle());
        isValidPrice(product.getPrice());
    }

    public void isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new ProductNotValidFieldException("Product title cannot be null or empty");
        }
    }

    public void isValidPrice(Double price) {
        if (price == null || price < 0) {
            throw new ProductNotValidFieldException("Product price cannot be null or negative");
        }
    }
}
