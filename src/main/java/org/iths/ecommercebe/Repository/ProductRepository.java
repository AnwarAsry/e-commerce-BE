package org.iths.ecommercebe.Repository;

import org.iths.ecommercebe.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
