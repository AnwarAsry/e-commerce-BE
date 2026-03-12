package org.iths.ecommercebe.Repository;

import org.iths.ecommercebe.Model.Category;
import org.iths.ecommercebe.Model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryAndActiveTrue(Category category, Sort sort);

    List<Product> findByFeaturedTrueAndActiveTrue();

    @Query("""
                SELECT p FROM Product p
                WHERE p.active = true
                AND (
                    LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))
                )
            """)
    List<Product> searchByName(@Param("query") String query);
}