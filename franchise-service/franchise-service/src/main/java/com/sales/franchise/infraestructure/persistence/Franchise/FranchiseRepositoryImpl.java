
package com.sales.franchise.infraestructure.persistence.Franchise;

import com.sales.franchise.domain.model.Franchise;
import com.sales.franchise.domain.port.FranchiseRepositoryPort;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FranchiseRepositoryImpl implements FranchiseRepositoryPort{

    private final FranchiseJpaRepository jpaRepository;
    
    @Override
    public Franchise save(Franchise franchise) {
       return jpaRepository.save(franchise);
    }

    @Override
    public Boolean ValidatorIfExists(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Optional<Franchise> GetAllFranchiseForId(Long id) {
        return jpaRepository.findById(id);
    }

    
    
}
