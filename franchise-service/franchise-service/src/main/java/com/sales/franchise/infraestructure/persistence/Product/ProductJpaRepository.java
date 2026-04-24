
package com.sales.franchise.infraestructure.persistence.Product;
import com.sales.franchise.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductJpaRepository extends JpaRepository<Product, Long>{}
    

