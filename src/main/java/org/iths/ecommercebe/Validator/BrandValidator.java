package org.iths.ecommercebe.Validator;

import org.iths.ecommercebe.Exceptions.BrandNotValidFieldException;
import org.springframework.stereotype.Component;

@Component
public class BrandValidator {
    public void isValidName(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new BrandNotValidFieldException("Brand cannot be null or empty.");
        }
    }
}
