package org.iths.ecommercebe.Validator;

import org.iths.ecommercebe.Exceptions.CategoryNotValidFieldException;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidator {
    public void isValidName(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new CategoryNotValidFieldException("Category cannot be null or empty.");
        }
    }
}
