package com.sales.franchise.domain.port;

import com.sales.franchise.domain.model.Branch;
import java.util.Optional;

public interface BranchRepositoryPort {
    Branch save(Branch branch);
    Boolean ValidatorIfExists(Long id);
    Optional<Branch> GetAllBranchForId(Long id);
}
