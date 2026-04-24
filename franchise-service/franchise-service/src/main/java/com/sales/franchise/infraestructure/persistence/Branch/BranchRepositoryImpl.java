
package com.sales.franchise.infraestructure.persistence.Branch;

import com.sales.franchise.domain.model.Branch;
import com.sales.franchise.domain.port.BranchRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BranchRepositoryImpl implements BranchRepositoryPort{

    private final BranchJpaRepository jpaRepository;
    
    @Override
    public Branch save(Branch branch) {
        return jpaRepository.save(branch);
    }

     @Override
    public Boolean ValidatorIfExists(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Optional<Branch> GetAllBranchForId(Long id) {
       return jpaRepository.findById(id);
    }

    @Override
    public List<Branch> GetAllBranchForFranchise(Long id) {
        return jpaRepository.findByFranchise_IdFranchise(id);
    }
}
