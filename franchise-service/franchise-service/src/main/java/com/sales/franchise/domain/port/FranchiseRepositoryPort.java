
package com.sales.franchise.domain.port;

import com.sales.franchise.domain.model.Franchise;

import java.util.Optional;


public interface FranchiseRepositoryPort {
    Franchise save(Franchise franchise);
    Boolean ValidatorIfExists(Long id);
    Optional<Franchise> GetAllFranchiseForId(Long id);
}
