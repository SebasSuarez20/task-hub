
package com.sales.franchise.infraestructure.persistence.Product;

import com.sales.franchise.domain.model.Product;
import com.sales.franchise.domain.port.ProductRepositoryPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort{

    private final ProductJpaRepository jpaRepository;
    
    @Override
    public Product save(Product product) {
        return jpaRepository.save(product);
    }

    @Override
    public Optional<Product> GetAllProductForId(Long id) {
       return jpaRepository.findById(id);
    }
    
    public Product filterInformationProductForId(Long idProduct){
       return jpaRepository.findById(idProduct).
                orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
