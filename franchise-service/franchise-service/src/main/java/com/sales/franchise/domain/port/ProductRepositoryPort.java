package com.sales.franchise.domain.port;

import com.sales.franchise.domain.model.Product;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> GetAllProductForId(Long id);
}
